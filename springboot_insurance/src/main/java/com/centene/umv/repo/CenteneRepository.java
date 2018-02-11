package com.centene.umv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centener.umv.domain.Foo;

@Repository
public interface CenteneRepository extends JpaRepository<Foo, Long> {

  Foo findById(Long id);

}
