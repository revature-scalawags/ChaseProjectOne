import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.Text

/**
  * Mapper Class for determining how to map input data into key value pairs for the reducer function
  */
class WordMapper extends Mapper[LongWritable, Text, Text, IntWritable]{

  //val legoSetMap: Map[String, LegoSet] = 

  // Override map function from hadoop libraries
  override def map(key: LongWritable, value: Text, context: Mapper[LongWritable, Text, Text, IntWritable]#Context): Unit = {
    val line = value.toString

    // Filter each line and separate values
    line.split(",").filter(_.length > 0).map(_.trim).foreach(
        (word: String) => {
            if (word.contains("Star Wars")) {
              context.write(new Text(word), new IntWritable(1))
            }
        }
    )
  }
}
