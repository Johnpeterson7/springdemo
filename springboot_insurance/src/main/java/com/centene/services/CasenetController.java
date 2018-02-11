package com.centene.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centene.casenet.domain.Bar;
import com.centene.casenet.repo.CasenetRepository;
import com.centene.umv.repo.CenteneRepository;
import com.centener.umv.domain.Foo;

@Service
public class CasenetController {

  private final CenteneRepository fooRepo;
  private final CasenetRepository barRepo;

  @Autowired
  CasenetController(CenteneRepository fooRepo, CasenetRepository barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }

  public void fooBar() {
	  long id = 2;
    Foo foo = fooRepo.findById(id);
    Bar bar = barRepo.findById(id);

  System.out.println("result : " + foo.getFoo() +" :  :  "+  bar.getBar());
  }

}
