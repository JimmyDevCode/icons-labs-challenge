package com.alkemy.icons.icons.controller;


import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.dto.PaisDto;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/all")
    public ResponseEntity<List<PaisDto>> getAll(){
        //save pais
        List<PaisDto> paises = paisService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }
    @GetMapping
    public ResponseEntity<List<PaisDto>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String continente,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<PaisDto> paises = this.paisService.getByFilters(name, continente, order);
        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }

    @PostMapping
    public ResponseEntity <PaisDto> save(@RequestBody PaisDto pais){
        //save pais
        PaisDto paisGuardado = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisGuardado);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PaisDto> update(@PathVariable Long id, @RequestBody PaisDto paisDto){
        PaisDto paisUpdate = paisService.update(id, paisDto);
        return  ResponseEntity.status(HttpStatus.OK).body(paisUpdate);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        this.paisService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/icons/{idIcon}")
    public ResponseEntity<Void> addIcon (@PathVariable Long id, @PathVariable Long idIcon){
        this.paisService.addIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}/icons/{idIcon}")
    public ResponseEntity<Void> removeIcon (@PathVariable Long id, @PathVariable Long idIcon){
        this.paisService.removeIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
