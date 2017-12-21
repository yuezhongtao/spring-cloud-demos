package com.example.oauth2authorizationserver.repository;

import com.example.oauth2authorizationserver.entity.MyUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUserDetail,Long>{

    UserDetails findByUsername(String username);
}
