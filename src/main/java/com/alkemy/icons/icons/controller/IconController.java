package com.alkemy.icons.icons.controller;


import com.alkemy.icons.icons.dto.IconBasicDto;
import com.alkemy.icons.icons.dto.IconDto;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping("/all")
    public ResponseEntity<List<IconBasicDto>> getAll(){

        List<IconBasicDto> icons = iconService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(icons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IconDto> getDetailsById(@PathVariable Long id){
        IconDto icon = iconService.getDetailsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(icon);
    }

    @PostMapping()
    public ResponseEntity<IconDto> save(@RequestBody IconDto icon){
        IconDto iconGuardado = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(iconGuardado);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<IconDto> update(@PathVariable Long id, @RequestBody IconDto icon){
        IconDto iconUpdate = iconService.update(id, icon);
        return  ResponseEntity.status(HttpStatus.OK).body(iconUpdate);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
