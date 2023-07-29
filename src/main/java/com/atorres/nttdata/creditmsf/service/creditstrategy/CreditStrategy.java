package com.atorres.nttdata.creditmsf.service.creditstrategy;

import com.atorres.nttdata.creditmsf.model.CreditDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditStrategy {
    Mono<Boolean> verifyCredit(Flux<CreditDto> listCredit);
}
