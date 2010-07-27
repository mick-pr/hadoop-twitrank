package com.github.emtrane;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: daxiage
 * Date: Jul 27, 2010
 * Time: 11:30:15 AM
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tweet {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
