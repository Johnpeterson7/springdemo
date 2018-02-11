package com.centene.casenet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centene.casenet.domain.Bar;

@Repository
public interface CasenetRepository extends JpaRepository<Bar, Long> {

  Bar findById(Long id);

}
