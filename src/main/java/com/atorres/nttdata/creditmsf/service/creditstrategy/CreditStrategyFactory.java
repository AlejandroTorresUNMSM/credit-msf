package com.atorres.nttdata.creditmsf.service.creditstrategy;

import com.atorres.nttdata.creditmsf.model.clientms.ClientType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class CreditStrategyFactory {
    private final Map<ClientType, CreditStrategy> strategies = new EnumMap<>(ClientType.class);

    public CreditStrategyFactory() {
        initStrategies();
    }

    public CreditStrategy getStrategy(ClientType userType) {
        if (userType == null || !strategies.containsKey(userType)) {
            throw new IllegalArgumentException("Invalid " + userType);
        }
        return strategies.get(userType);
    }

    private void initStrategies() {
        strategies.put(ClientType.PERSONAL, new PersonalCreditStrategy());
        strategies.put(ClientType.VIP, new PersonalCreditStrategy());
        strategies.put(ClientType.BUSSINES, new BussinesCreditStrategy());
        strategies.put(ClientType.MYPE, new BussinesCreditStrategy());
    }
}
