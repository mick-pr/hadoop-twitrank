package com.github.emtrane;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: daxiage
 * Date: Jul 27, 2010
 * Time: 11:30:15 AM
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tweet {
    private String text;
    private Boolean truncated;
    private Tweet retweeted_status;
    private User user;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Tweet retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
