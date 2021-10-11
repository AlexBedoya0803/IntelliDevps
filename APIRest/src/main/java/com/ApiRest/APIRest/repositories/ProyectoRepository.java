package com.ApiRest.APIRest.repositories;

import com.ApiRest.APIRest.models.Proyecto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends MongoRepository<Proyecto, String> {
}
