package com.atorres.nttdata.creditmsf.service.creditstrategy;

import com.atorres.nttdata.creditmsf.exception.CustomException;
import com.atorres.nttdata.creditmsf.model.CreditDto;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonalCreditStrategy implements CreditStrategy{
    @Override
    public Mono<Boolean> verifyCredit(Flux<CreditDto> listCredit) {
        return listCredit
                .single()
                .map(creditDao ->  creditDao.getBalance().doubleValue() <=1000)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND,"No cumple con el balance")))
                .onErrorResume( error ->Mono.error(new CustomException(HttpStatus.BAD_REQUEST, "Personal solo debe tener 1 credito")));
    }
}
