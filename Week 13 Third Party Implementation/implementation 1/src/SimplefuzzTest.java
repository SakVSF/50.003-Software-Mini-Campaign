

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;



import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class SimplefuzzTest {
   // String root_folder = "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/"; 
    String file1;
    String file2;
    String file3;
   

    public  SimplefuzzTest(String file1, String file2, String combo){
        this.file1 = file1;
        this.file2 = file2;
        this.file3 = file3;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { Fuzzer.simple() ,  "sample_file_1.csv", "output_file.csv"},
                { "sample_file_1.csv", Fuzzer.simple(), "sample_file_3.csv" },
                { "sample_file_1.csv" ,"sample_file_2.csv", Fuzzer.simple() },

                
        });
    }


    @Test
    public void setFile_check() {
        try{

        //week8.setFile(Fuzzer.simple() ,  "sample_file_1.csv", "output_file.csv");
          week8.setFile(file1, file2, file3);
    }
    catch(Exception e){
        e.printStackTrace();
    }
}


       
        
    }

 

 

  



    

