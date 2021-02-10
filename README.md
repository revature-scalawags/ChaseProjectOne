# ChaseProjectOne


## Project Description
Scala-Hadoop application to answer interesting questions about large datasets, using MapReduce and Hive. 
The dataset I chose to utilize in this project (linked below) was a LEGO Database with some interesting
data about the various sets, inventories, themes and more.

## Technologies Used
* Hadoop MapReduce
* YARN
* HDFS
* Scala
* Git + GitHub

## Features
* Reads in data from a database consisting of multiple CSV files and stores the data in case class
* Stores the data on HDFS for processing using a custom Hadoop Job
* Custom Mapper class extending Hadoop API in Scala
* Custom Reducer class extending Hadoop API in Scala
* Analyzes data stored on HDFS using HQL and Hive 

# Usage/Getting Started
### Initializing the Hadoop-Hive docker
* cd ~
* cd docker-hive/
* docker-compose up -d
### Initializ ing the Hadoop docker
* cd ~
* cd docker-hadoop/
* docker-compose up -d
### Running the Jar using Hadoop CLI
* docker cp JarName nameNodeID:NewJarName (from local terminal)
* hadoop jar JarName InputDirName OutputDirName (in bash inside docker hadoop)
