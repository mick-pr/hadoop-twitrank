package com.github.emtrane;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Date;

public class MyReducer extends Reducer<Text, Text, Text, DoubleWritable>
{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
        Double sum = Double.valueOf(0);

        String language;
        Date date;


        for (Text value : values)
        {
            String[] arr = value.toString().split(",");

            Double multiplier = Long.valueOf(arr[0])==0L ? 1 : 1.2;
            Double score = multiplier * (1+Math.log10(Long.valueOf(arr[1]) + 1));
            sum += score;
        }

        // the key could also be NullWritable and the value could be any String/Text you want
        context.write(key, new DoubleWritable(sum));
    }
}

