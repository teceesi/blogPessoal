package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{

}
