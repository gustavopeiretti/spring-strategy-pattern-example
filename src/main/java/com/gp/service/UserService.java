package com.gp.service;

import com.gp.model.User;
import com.gp.model.UserType;
import com.gp.repository.UserRepository;
import com.gp.strategies.Strategy;
import com.gp.strategies.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final StrategyFactory strategyFactory;
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository, StrategyFactory strategyFactory) {
        this.repository = repository;
        this.strategyFactory = strategyFactory;
    }

    public User get(long userId) {
        return repository.findOne(userId);
    }

    public List<User> list() {
        Iterable<User> users = repository.findAll();
        List<User> list = new ArrayList<>();
        users.forEach(list::add);
        return list;
    }

    public User create(User user) {
        Strategy strategy = strategyFactory.getStrategy(UserType.NORMAL);
        strategy.changeLimit(user);
        return repository.save(user);
    }


    public User changeType(long id, UserType type) {
        Strategy strategy = strategyFactory.getStrategy(type);
        User user = repository.findOne(id);
        strategy.changeLimit(user);
        return repository.save(user);
    }

}
