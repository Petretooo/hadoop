package homework_csv.homework_csv.firstTask;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RunningJob;
import org.apache.hadoop.mapred.TextOutputFormat;

import homework_csv.homework_csv.App;

public class ConfigurationFirstTask {
	
	public ConfigurationFirstTask() {
		// TODO Auto-generated constructor stub
	}
	
	public void runFirstTask() throws IOException {
		Configuration conf = new Configuration();
        
        Path inputPath = new Path("hdfs://127.0.0.1:9000/input/SalesJan2009.csv");
        Path outputPath = new Path("hdfs://127.0.0.1:9000/output_task_1");
        
        JobConf job = new JobConf(conf, App.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormat(TextOutputFormat.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        
        FileInputFormat.setInputPaths(job, inputPath);
        FileOutputFormat.setOutputPath(job, outputPath);
        
        FileSystem hdfs = FileSystem.get(URI.create("hdfs://127.0.0.1:9000"), conf);
        if(hdfs.exists(outputPath)) {
        	hdfs.delete(outputPath, true);
        }
        
        RunningJob task = JobClient.runJob(job);
        System.out.println("Is successful=" + task.isSuccessful());
	}

}
