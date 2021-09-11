package com.example.Tweet.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Tweet.entity.Tweet;

import java.util.List;
@Repository
public interface TweetDAO extends JpaRepository<Tweet, Integer> {

    @Query(value="SELECT * FROM twitter_tweet WHERE owner_id = :owner_id", nativeQuery = true)
    List<Tweet> findByOwner(@Param("owner_id") int owner_email);
}