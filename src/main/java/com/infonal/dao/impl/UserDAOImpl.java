package com.infonal.dao.impl;

import com.infonal.dao.inf.UserDAO;
import com.infonal.entity.User;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by hikuley on 21.08.2015.
 */

public class UserDAOImpl implements UserDAO {

    @Autowired
    private MongoTemplate mongoTemplate;


    public static final String COLLECTION = "USER";

    @Override
    public void create(User user) {
        this.mongoTemplate.insert(user, COLLECTION);
    }

    @Override
    public void update(User user) {
        this.mongoTemplate.save(user, COLLECTION);
    }

    @Override
    public Long delete(Long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoTemplate.remove(query, User.class, COLLECTION);
        return Long.valueOf(result.getN());
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class, COLLECTION);
    }

    @Override
    public User findById(Long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoTemplate.findOne(query, User.class, COLLECTION);
    }
}
