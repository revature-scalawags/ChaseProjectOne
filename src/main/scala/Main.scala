object Main extends App {
  // Read in the file using the given input
  //val fileName = scala.io.StdIn.readLine("Enter the filename of the Lego Set Database:")
  val fileName = "input/sets.csv"
  var sourceReader = new CSVReader(fileName)
  val legoSetSequence = sourceReader.importDatabase()
  legoSetSequence.foreach(println)
}