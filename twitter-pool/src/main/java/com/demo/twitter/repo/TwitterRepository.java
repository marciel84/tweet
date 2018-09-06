package com.demo.twitter.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.twitter.model.Twitter;

@Repository
public interface TwitterRepository extends MongoRepository<Twitter, String> {

}
