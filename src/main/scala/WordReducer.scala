import org.apache.hadoop.mapreduce.Reducer
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import java.{util => ju}
import org.apache.hadoop.mapred.{OutputCollector, Reporter}

/**
  * Reducer Class for determining how to take input data of key value pairs from the mapper function
  * and right to output file
  */
class WordReducer extends Reducer[Text, IntWritable, Text, IntWritable]{
  override def reduce(key: Text, values: java.lang.Iterable[IntWritable], context: Reducer[Text, IntWritable, Text, IntWritable]#Context): Unit = {
      var count = 0
      values.forEach(count += _.get())
      context.write(key, new IntWritable(count))
  }
}
