package com.gp.strategies;


import com.gp.model.User;
import com.gp.model.UserType;

public class StrategyOperationFull implements Strategy {

    @Override
    public void changeLimit(User user) {
        user.setType(UserType.FULL);
        user.setLimitCredit(5000D);
    }

}
