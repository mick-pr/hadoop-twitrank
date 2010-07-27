package com.github.emtrane;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMapper extends Mapper<LongWritable, Text, Text, Text>
{
    static String regex = "(https?)://[^ \"()]*";
    static Pattern patt = Pattern.compile(regex);

    @Override
    protected void map(LongWritable offset, Text input, Context context) throws IOException, InterruptedException
    {
        String line = input.toString();

        ObjectMapper mapper = new ObjectMapper();
        Tweet tweet = mapper.readValue(line, Tweet.class);

        if(tweet.getText()!=null){
            String text = tweet.getTruncated() ? tweet.getRetweeted_status().getText() : tweet.getText();

            long retweets = (tweet.getRetweeted_status()!=null) ? 1L : 0L;
            long followers = tweet.getUser().getFollowers_count();
            String language = tweet.getUser().getLang();

            Matcher matcher = patt.matcher(text);
            while(matcher.find()){
                String url = matcher.group();
                context.write(new Text(url), new Text(retweets+","+followers+","+language));
            }
        }





    }

}

