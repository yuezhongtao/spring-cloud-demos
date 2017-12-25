package com.example.oauth2authorizationserver.repository;

import com.example.oauth2authorizationserver.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{
}
