package com.github.emtrane;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: daxiage
 * Date: Jul 27, 2010
 * Time: 1:41:44 PM
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
    Long followers_count;
    String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Long followers_count) {
        this.followers_count = followers_count;
    }
}
