package com.atorres.nttdata.creditmsf.repository;

import com.atorres.nttdata.creditmsf.model.dao.CreditDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<CreditDao,String> {
}
