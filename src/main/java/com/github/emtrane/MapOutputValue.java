package com.github.emtrane;

/**
 * Created by IntelliJ IDEA.
 * User: daxiage
 * Date: Jul 27, 2010
 * Time: 3:10:04 PM
 */
public class MapOutputValue {
    Boolean retweet;
    Long followers;
    String language;
    String text;

    public Boolean getRetweet() {
        return retweet;
    }

    public void setRetweet(Boolean retweet) {
        this.retweet = retweet;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
