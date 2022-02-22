package com.api.charpg.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.api.charpg.dtos.CharpgDto;
import com.api.charpg.models.Charpg;
import com.api.charpg.services.CharpgService;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/charpg")
public class CharpgController {
    
    final CharpgService charpgService;

    public CharpgController(CharpgService charpgService){
        this.charpgService = charpgService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CharpgDto charpgDto){
        var charpgModel = new Charpg();
        BeanUtils.copyProperties(charpgDto, charpgModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(charpgService.save(charpgModel));
    }

    @GetMapping
    public ResponseEntity<List<Charpg>> getAllCharpg(){
        return ResponseEntity.status(HttpStatus.OK).body(charpgService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCharpg(@PathVariable(value = "id") UUID id){
        Optional<Charpg> charpgModelOptional = charpgService.findById(id);
        if(!charpgModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse ID");
        }
        return ResponseEntity.status(HttpStatus.OK).body(charpgModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCharpg(@PathVariable(value = "id") UUID id){
        Optional<Charpg> charpgModelOptional = charpgService.findById(id);
        if(!charpgModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse ID");
        }
        charpgService.delete(charpgModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Apagado esse ID/Personagem");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCharpg(@PathVariable(value = "id") UUID id, @RequestBody @Valid CharpgDto charpgDto){
        Optional<Charpg> charpgModelOptional = charpgService.findById(id);
        if(!charpgModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe esse ID");
        }
        var charpgModel = charpgModelOptional.get();
        charpgModel.setNome(charpgDto.getNome());
        charpgModel.setClasse(charpgDto.getClasse());
        charpgModel.setNivel(charpgDto.getNivel());
        charpgModel.setForca(charpgDto.getForca());
        charpgModel.setDestreza(charpgDto.getDestreza());
        charpgModel.setConstituicao(charpgDto.getConstituicao());
        charpgModel.setInteligencia(charpgDto.getInteligencia());
        charpgModel.setSabedoria(charpgDto.getSabedoria());
        charpgModel.setCarisma(charpgDto.getCarisma());

        return ResponseEntity.status(HttpStatus.OK).body(charpgService.save(charpgModel));
    }
}
