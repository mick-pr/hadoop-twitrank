package com.github.emtrane;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable>
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
            Matcher matcher = patt.matcher(tweet.getText());
            while(matcher.find()){
                String url = matcher.group();
                System.out.println("Found: " + url);
                context.write(new Text(url), new LongWritable(1L));
            }
        }





    }

}

