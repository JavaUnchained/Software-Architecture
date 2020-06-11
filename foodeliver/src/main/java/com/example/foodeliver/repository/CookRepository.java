package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Cook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookRepository extends CrudRepository<Cook,Long> {
}
