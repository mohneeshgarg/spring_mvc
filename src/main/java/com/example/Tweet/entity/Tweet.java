package com.example.Tweet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="twitter_tweet")
public class Tweet {

    @Id
    @Column(name = "tweet_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tweetId;

    @Column(name = "body")
    private String body;

    @Column(name = "owner_id")
    private int ownerID;

    private String ownerName;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date time;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Tweet() {};

    public Tweet(int tweetId, String body, int ownerID, Date date, Date time) {
        this.tweetId = tweetId;
        this.body = body;
        this.ownerID = ownerID;
        this.date = date;
        this.time = time;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", body='" + body + '\'' +
                ", ownerID=" + ownerID +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}