package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDto;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @GetMapping
    public ResponseEntity<List<ContinenteDto>> getAll() {
        //save continente
        List<ContinenteDto> continentes = continenteService.getAllContinentes();
        return ResponseEntity.status(HttpStatus.OK).body(continentes);
    }
    @PostMapping
    public ResponseEntity<ContinenteDto> save(@RequestBody ContinenteDto continente) {
        //save continente
        ContinenteDto continenteGuardado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }



}
