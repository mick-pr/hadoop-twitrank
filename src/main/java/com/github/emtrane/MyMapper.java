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

            Matcher matcher = patt.matcher(text);
            while(matcher.find()){
                String url = matcher.group();

                MapOutputValue output = new MapOutputValue();
                output.setFollowers(tweet.getUser().getFollowers_count());
                output.setRetweet(tweet.getRetweeted_status()!=null);
                output.setText(text);
                output.setLanguage(tweet.getUser().getLang());

                context.write(new Text("["+tweet.getUser().getLang()+"]"+url), new Text(mapper.writeValueAsString(output)));
            }
        }
    }

}

