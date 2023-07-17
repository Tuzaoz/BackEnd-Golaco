package com.devs.backendgolaco.repositories;

import com.devs.backendgolaco.entities.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampoRepository extends JpaRepository<Campo,Long> {
}
