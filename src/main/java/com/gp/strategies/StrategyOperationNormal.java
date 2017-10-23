package com.gp.strategies;


import com.gp.model.User;
import com.gp.model.UserType;

public class StrategyOperationNormal implements Strategy {

    @Override
    public void changeLimit(User user) {
        // a complex calculation..
        user.setType(UserType.NORMAL);
        user.setLimitCredit(1000D);
    }

}
