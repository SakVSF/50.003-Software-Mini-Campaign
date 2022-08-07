 
## Source Code :  /src/Compare_updated.java
Compare_updated class has 3 functions :

  1. compare(String file1, String file2, String combo, boolean column) - function that is called directly from main()
        - __file1__ and __file2__ are the csv files to be compared. They need to be in the same folder (/src) 
        - __combo__ is the input combination   which serves as a unique key. For example, if you want to keep the first 2 columns as unique key ( rest 3 columns are checked for mismatch), then you need to pass "0,1" as the combination
        - __column__ is a boolean value. If it is true, then the program assumes that both files have column headers. If it is false, then the program assumes both files do not have column headers. 
        
  2. check_empty_string(String file1, String file2, String combo)  - function is called from within compare()
        - returns true if either file1 or file2 or combo strings are empty, returns false otherwise
  
  3. check_extension(String file1, String file2) - function is called from within compare()
        - returns true if both Strings have a .csv extension, returns false otherwise


How to run? go to main() function of Compare_updated.java > pass in the necessary arguments into compare()  > run Compare_updated.java  > view output in __sample_output.csv__

### Note 
Change the path of "root_folder" defined in the class to your directory before running the source code or any of the test files 
