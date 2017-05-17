************ PART - 1 ************ 

-> Initially run the majestic_schema.sql file for creating four tables i.e with no index( MAJESTIC ), with indexing on TLD ( MAJESTIC_INDEX1 ), with indexing on RefSubNets ( MAJESTIC_INDEX2 ), with indexing on RefIDs and TLD ( MAJESTIC_INDEX3 ).
  Use the following command to create tables
   - start majestic_schema.sql
-> Now load data into these tables using the following commands :
  
  To load data into majestic table 
   - sh Load_data.sh 
  The time taken to load this data is :
   - real    0m16.532s

     user    0m3.210s

     sys     0m0.258s
   
  To load data into majestic_index1 table
   - sh Load_index1.sh
  The time taken to load this data is :
   - real    0m21.510s
     
user    0m3.101s

     sys     0m0.189s

  To load data into majestic_index2 table
    - sh Load_index2.sh
  The time taken to load this data is :
    - real    0m20.820s
      
user    0m3.288s
      
sys     0m0.208s
  
  To load data into majestic_index3 table 
     - sh Load_index3.sh
  The time taken to load this data is:
     - real    0m35.657s

       user    0m3.181s

       sys     0m0.324s

-> Now execute query india domains query on all the tables using following commands:

   To execute it on majestic table:
     - start query_india_domains 
   The time elapsed in the command execution is :
     - Time taken: 00:00:04.85
   
   To execute it on majestic_index1 table:
     - start query_india_domains_index1
   The time elapsed in the command execution is :
     - Time taken: 00:00:04.98

   To execute it on majestic_index2 table:
     - start query_india_domains_index2
   The time elapsed in the command execution is :
     - Time taken: 00:00:03.51

   To execute it on majestic_index3 table:
     - start query_india_domains_index3
   The time elapsed in the command execution is :
     - Time taken: 00:00:05.48

-> Now execute query top domains query on all the tables using following commands:
   
    To execute it on majestic table:
     - start query_top_domains 
    The time elapsed in the command execution is :
     - Time taken:  00:00:00.30
    
    To execute it on majestic_index1 table:
     - start query_top_domains_index1 
    The time elapsed in the command execution is :
     - Time taken:  00:00:00.64
    
    To execute it on majestic_index2 table:
     - start query_top_domains_index2 
    The time elapsed in the command execution is :
     - Time taken:  00:00:00.49

    To execute it on majestic_index3 table:
     - start query_top_domains_index3 
    The time elapsed in the command execution is  :
     - Time taken:  00:00:00.72

-> Now execute query wikipedia query on all the tables using following commands:
    
    To execute it on majestic table:
     - start query_wikipedia
    The time elapsed in the command execution is :
     - Time taken:  00:00:00.05

    To execute it on majestic_index1 table:
     - start query_wikipedia_index1
    The time elapsed in the command execution is :
     - Time taken:  00:00:00.05
    
   To execute it on majestic_index2 table:
     - start query_wikipedia_index2
   The time elapsed in the command execution is :
     - Time taken:  00:00:00.10
   
   To execute it on majestic_index3 table:
     - start query_wikipedia_index3
   The time elapsed in the command execution is :
     - Time taken:  00:00:00.05

-> To clean all the data you can execute clean_data.sql using following command:
    - start clean_data.sql

********** PART - 2 ***********

-> Execute the domain_tld.js file I have attached using the following command
   - node domain_tld.js
   ( Copy all the html files into the node modules folder to execute this )

********** PART - 3 ************

-> Now execute the shell file for query1 as follows:
   - sh query1_curl.sh
  
   Time taken for searching in table without indexing (majestic):
   - real    0m0.105s
     
user    0m0.002s

     sys     0m0.003s
  
   Time taken for searching in table with index at TLD (majestic_index1):
   - real    0m0.091s
     
user    0m0.002s

     sys     0m0.003s
  
   Time taken for searching in table with index at RefSubNets (majestic_index2):
    - real    0m0.153s

      user    0m0.003s

      sys     0m0.001s

   Time taken for searching in table with index at TLD and RefIDs(majestic_index3):
    - real    0m0.269s

      user    0m0.002s
      
sys     0m0.003s

->Executing shell script for query2:
     -sh query2_curl.sh
 
  Time taken for searching in table without indexing (majestic):
     - real    0m16.532s
       
user    0m3.210s
       
sys     0m0.258s
  
  Time taken for searching in table with index at TLD (majestic_index1):
    - real    0m21.510s
      
user    0m3.101s

      sys     0m0.189s

  Time taken for searching in table with index at RefSubNets (majestic_index2):
    - real    0m20.820s
      
user    0m3.288s
      
sys     0m0.208s

  Time taken for searching in table with index at TLD and RefIDs(majestic_index3):
   - real    0m35.657s

     user    0m3.181s

     sys     0m0.324s

*********** PART - 4 ************

-> Now create a set of four new tables which are indexed using Bitmap indexes by using majestic_bitmap_schema.sql file.
  execute:
    - start majestic_bitmap_schema.sql
 
-> Now load data into these tables using the following commands :
  
  To load data into majestic table 
   - sh Load_data.sh 
  The time taken to load this data is :
   - real    0m16.532s

     user    0m3.210s

     sys     0m0.258s
  
  To load data into majestic_index1 table
   - sh Load_index1.sh
  The time taken to load this data is :
   - real    0m43.427s
     
user    0m3.417s

     sys     0m0.287s

   To load data into majestic_index2 table
    - sh Load_index2.sh
   The time taken to load this data is :
    - real    0m21.030s
      
user    0m3.381s
      
sys     0m0.297s

   To load data into majestic_index3 table
    - sh Load_index3.sh
   The time taken to load this data is :
    - real    0m49.503s
      
user    0m3.420s
      
sys     0m0.265s



-> Now execute query india domains query on all the tables using following commands:
   ->start query_india_domains 
     time Elapsed: 00:00:03.49
   ->start query_india_domains_index1
     time Elapsed: 00:00:02.67
   ->start query_india_domains_index2 
     time Elapsed: 00:00:00.50
   ->start query_india_domains_index3 
     time Elapsed: 00:00:00.45

-> Now execute query top domains query on all the tables using following commands:
   ->start query_top_domains 
     time Elapsed: 00:00:01.04
   ->start query_top_domains_index1 
     time Elapsed: 00:00:00.94
   ->start query_top_domains_index2
     time Elapsed: 00:00:00.01
   ->start query_top_domains_index3 
     time Elapsed: 00:00:00.22


-> Now execute query wikipedia query on all the tables using following commands:
   ->start query_wikipedia 
     time Elapsed: 00:00:00.61
   ->start query_wikipedia_index1 
     time Elapsed: 00:00:00.44
   ->start query_wikipedia_index2 
     time Elapsed: 00:00:00.68
   ->start query_wikipedia_index3 
     time Elapsed: 00:00:00.20

->Executing shell script for query1 :
  - sh query1_curl.sh

Time taken for searching in table without indexing (majestic):
real    0m0.290s
user    0m0.002s
sys     0m0.003s

Time taken for searching in table with index at TLD (majestic_index1):
real    0m0.266s
user    0m0.001s
sys     0m0.003s

Time taken for searching in table with index at RefSubNets (majestic_index2):
real    0m0.300s
user    0m0.001s
sys     0m0.003s

Time taken for searching in table with index at TLD and RefIDs(majestic_index3):
real    0m0.150s
user    0m0.000s
sys     0m0.005s

->Executing shell script for query2:
  -sh query2_curl.sh

Time taken for searching in table without indexing (majestic):
real    0m0.016s
user    0m0.000s
sys     0m0.005s


Time taken for searching in table with index at TLD (majestic_index1):
real    0m0.015s
user    0m0.003s
sys     0m0.001s


Time taken for searching in table with index at RefSubNets (majestic_index2):
real    0m0.060s
user    0m0.002s
sys     0m0.002s


Time taken for searching in table with index at TLD and RefIDs(majestic_index3):
real    0m0.015s
user    0m0.001s
sys     0m0.003s

---------------------------------------------------------------------------------------------------

CONCLUSIONS:

LOADING DATA :

   -> By observing the time taking in loading the data into both the tables with indexing and without indexing, we can conclude that the time taken for loading data into tables without indexing is less than loading data into tables with indexing (i.e both B+ and Bitmap indexing).
   -> It takes more time to index multiple columns(35.657s in case of B+) compared to single column(20.820s in case of B+).
   -> Bitmap indexing has better performance compared to B+ indexing which is evident from index to RefSubNets.

QUERIES :

   -> For query_india_domains, Bitmap performs better when compared to B+ indexing as it has repeated entries for TLD input in database.
   -> For query_top_domains also Bitmap performs better when compared to B+ indexing.
   -> For query_wikipedia, equal performance is observed as the combination of indexes are unique and only 1 entry is to be searched.

CURL :

For query2_curl
   -> B+  indexing performs better than Bitmap because unique values are present in the domain column.
   -> Space issues also occur, as many users read and write simultaniously causing lag in read time.







   