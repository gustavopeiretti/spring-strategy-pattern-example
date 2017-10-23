package com.gp.strategies;

import com.gp.model.User;
import com.gp.model.UserType;

public class StrategyOperationGold implements Strategy {

    @Override
    public void changeLimit(User user) {
        user.setType(UserType.GOLD);
        user.setLimitCredit(20000D);
    }

}
