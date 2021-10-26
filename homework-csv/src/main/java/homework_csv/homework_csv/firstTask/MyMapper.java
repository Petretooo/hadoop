package homework_csv.homework_csv.firstTask;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MyMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		String line = value.toString();
		String[] columns = line.split(",");
		if(!columns[3].equals("Payment_Type") && columns.length == 12) {
			StringTokenizer tokens = new StringTokenizer(columns[3].trim());
			
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				output.collect(new Text(token), new IntWritable(1));		
			}
		}
	}
}
