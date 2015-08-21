package com.infonal.dao.impl;

import com.infonal.dao.inf.UserDAO;
import com.infonal.entity.User;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hikuley on 21.08.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void create(User user) {
        this.mongoTemplate.insert(user);
    }

    @Override
    public void update(User user) {
        this.mongoTemplate.save(user);
    }

    @Override
    public Long delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoTemplate.remove(query, User.class);
        return Long.valueOf(result.getN());
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoTemplate.findOne(query, User.class);
    }
}
