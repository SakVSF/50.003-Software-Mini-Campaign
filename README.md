# 50.003-Software-Mini-Campaign

## Name : Saakshi Vinod Saraf 
## ID   : 1005380

### About
This repository contains submissions for the Software Mini Campaign for the module 50.003 : Elements of Software Construction  

### Note to Testers (Week12)

Please navigate to __/compare__ to find instructions about code.

### Week 8 Submission

A> Please find the use case diagram (with misuse case appended) under __Use-case diagram.jpg__ .

B> Please find the following in the __compare/src__ folder :
1. __CompareCSV.java__ : source code that takes in 2 csv files and stores mismatches found (balance, currency, type, etc.) in sample_output.csv

2. __sample_output.csv__ : csv file storing mismatches. CompareCSV.java writes to this file

3. __samplefile_1.csv, samplefile_2.csv, samplefile_3.csv__ : csv files read by CompareCSV.java

   To run the files and view desired output, simply run CompareCSV.java. Make sure that the csv files are in the same folder as CompareCSV.java.
   The output can be viewed in __sample_output.csv__. 

### Week 9 Submission

Please find the report for Equivalence Class and Boundary Value Analysis under the __Week 9__ folder.


### Week 10 Submission

A> Navigate to __compare/src/CompareCSV.java__ 

CompareCSV.java contains the updated code that takes in 2 file names and writes to sample_output.csv if any exceptions found. 

TESTS 

__NOTE__ : please change the location of root_folder variable used inside the test class to your directory before testing

B> Navigate to __compare/src/CheckEmpty.java__ : This is a unit test that tests the __check_empty_string()__ function of CompareCSV class. The tests included are parametrized. Running the test checks that if empty string(s) are passed to __check_empty_string()__, the function returns true.

C> Navigate to __compare/src/CheckExtension.java__ : This is a unit test that tests the __check_extension()__ function of CompareCSV class. The tests included are parametrized. Running the test checks that if strings with wrong/no extension are passed to __check_extension()__, the function returns false.

D> Navigate to __compare/src/SystemTest.java__ : this class contains system tests for boundary values and equivalence class mentioned in the pdf under __Week 9/Equivalence Partition_Boundary Values.pdf__. 

This contains tests to check if following invalid inputs to __compare()__ function of CompareCSV.java will give invalid outputs:

      1. testEmpty() : empty strings
      
      2. testNotFound() : file not found in folder
      
      3. testWrongExtension() : file with wrong/no extension passed
      
      4. testBoundary_1row() : files with just 1 row returns 1, program execution stopped( unsuccessful ) 
      
      5. testBoundary_1col():  files with just 1 column returns 1,  program execution stopped (unsuccessful)
      
      6. testBoundary_6col() : files with 6 (more than 5) columns - execution aborted
      
      7. testBoundary_1001rows() : files with more than 1000 rows - execution aborted
      
      
This also contains tests to check if valid inputs give valid outputs:

      1. MatchOutput() - 2 files with no similarities gives an output.csv whose length is length of file1 + length of file2
      
      2. EmptyOutput() - same file given for both inputs gives empty output file since no mismatch
      
      3. CorrectOutput() - valid input gives valid output
      


