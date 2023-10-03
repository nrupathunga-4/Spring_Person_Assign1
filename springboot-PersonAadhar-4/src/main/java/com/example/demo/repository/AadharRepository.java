package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AadharCard;

public interface AadharRepository extends JpaRepository<AadharCard, String> {

}
