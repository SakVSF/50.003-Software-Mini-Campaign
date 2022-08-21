import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;



import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



public class tests {
   // String root_folder = "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/"; 
   @Test
public void EmptyFile_check() {
    try{

    //week8.setFile(Fuzzer.simple() ,  "sample_file_1.csv", "output_file.csv");
      assertTrue(!week8.checkEmpty("file_check.csv"));
      assertTrue(!week8.checkEmpty(Fuzzer.simple()));
      assertFalse(week8.checkEmpty(""));

}
catch(Exception e){
    e.printStackTrace();
}
}

@Test
public void Extension_check() {
    try{

    //week8.setFile(Fuzzer.simple() ,  "sample_file_1.csv", "output_file.csv");
      assertTrue(week8.checkExt("file_check.csv"));
      assertFalse(week8.checkExt(Fuzzer.simple()));
      assertFalse(week8.checkExt("file_check.csvv"));

}
catch(Exception e){
    e.printStackTrace();
}
}



       
        
    }

 

 

  



    

