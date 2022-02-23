package com.api.charpg.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.api.charpg.models.Charpg;
import com.api.charpg.repositories.CharpgRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

@Service
public class CharpgService {

    final CharpgRepository charpgRepository;

    public CharpgService(CharpgRepository charpgRepository){
        this.charpgRepository = charpgRepository;
    }

    @Transactional
    public Charpg save(Charpg charpgModel){
        return charpgRepository.save(charpgModel);
    }

    public List<Charpg> findAll(){
        return charpgRepository.findAll();
    }

    public Optional<Charpg> findById(UUID id){
        return charpgRepository.findById(id);
    }

    @Transactional
    public void delete(Charpg charpgModel) {
        charpgRepository.delete(charpgModel);
    }

}
