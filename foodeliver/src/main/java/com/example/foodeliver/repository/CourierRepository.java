package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Courier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends CrudRepository<Courier,Long> {
}
