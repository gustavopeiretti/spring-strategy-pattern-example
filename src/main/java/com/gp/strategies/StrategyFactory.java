package com.gp.strategies;

import com.gp.model.UserType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class StrategyFactory {

    private Map<UserType, Strategy> strategies = new EnumMap<>(UserType.class);

    public StrategyFactory() {
        initStrategies();
    }

    public Strategy getStrategy(UserType userType) {
        if (userType == null || !strategies.containsKey(userType)) {
            throw new IllegalArgumentException("Invalid " + userType);
        }
        return strategies.get(userType);
    }

    private void initStrategies() {
        strategies.put(UserType.NORMAL, new StrategyOperationNormal());
        strategies.put(UserType.FULL, new StrategyOperationFull());
        strategies.put(UserType.GOLD, new StrategyOperationGold());
    }

}
