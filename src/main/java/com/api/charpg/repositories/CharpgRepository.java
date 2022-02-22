package com.api.charpg.repositories;

import java.util.UUID;

import com.api.charpg.models.Charpg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharpgRepository extends JpaRepository<Charpg, UUID>{
}
