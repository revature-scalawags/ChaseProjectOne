/**
  * Trait for importing the emitter database as a CSV file. Have a sequence
  * of RadarThreat objects returned rather than only strings. 
  */
trait CSVFileReader {
  /**
    * @return Returns a sequence of RadarThreat objects
    */
  def importDatabase(): Seq[LegoSet]
}

/** CSVReader
  * Implementation of [[CSVFileReader]] responsible for parsing the LEGO 
  * database from the source files.
  * @param fileName the name of the file containing the threat database information in CSV format
  */
class CSVReader(val fileName: String) extends CSVFileReader{
  
  // Override the function inherited from the CSVFileReader trait
  override def importDatabase(): Seq[LegoSet] = {
    // Grab the file, returns a Buffered Source
    val file = io.Source.fromFile(fileName)
    // loop through the source file and convert each line to a collection/sequence of RadarThreat objects
    for {
      line <- file.getLines().toVector
      values = line.split(",").map(_.trim)
      // Return the values parsed in as parameters to the RadarThreat class constructor
      // Convert strings as necessary into the proper data type for each parameter
      // as defined in the RadarThreat class
    } yield LegoSet(values(0), values(1), values(2), values(3), values(4))
  }
}
