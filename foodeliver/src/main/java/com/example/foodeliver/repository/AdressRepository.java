package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Adress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends CrudRepository<Adress,Long> {
}
