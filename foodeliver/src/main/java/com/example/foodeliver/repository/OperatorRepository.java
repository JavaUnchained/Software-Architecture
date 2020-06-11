package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends CrudRepository<Operator,Long> {
}
