package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Ratio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatioRepository extends CrudRepository<Ratio,Long> {
}
