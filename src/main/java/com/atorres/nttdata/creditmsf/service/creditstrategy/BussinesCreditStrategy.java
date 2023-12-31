package com.atorres.nttdata.creditmsf.service.creditstrategy;

import com.atorres.nttdata.creditmsf.exception.CustomException;
import com.atorres.nttdata.creditmsf.model.CreditDto;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BussinesCreditStrategy implements CreditStrategy{
    @Override
    public Mono<Boolean> verifyCredit(Flux<CreditDto> listCredit) {
        return listCredit
                .all(creditDao ->  creditDao.getBalance().doubleValue() <=10000)
                .flatMap(  exist -> Boolean.TRUE.equals(exist) ? Mono.just(Boolean.TRUE):Mono.error(new CustomException(HttpStatus.BAD_REQUEST,"El credito no debe pasar 10 000")));
    }
}
