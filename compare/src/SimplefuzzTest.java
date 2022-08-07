


import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;



import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class SimplefuzzTest {
    String root_folder = "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/"; 
    String file1;
    String file2;
    String combo;
   

    public  SimplefuzzTest(String file1, String file2, String combo){
        this.file1 = file1;
        this.file2 = file2;
        this.combo = combo;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { Fuzzer.simple() ,  "sample_file_1.csv", "0"},
                { "sample_file_1.csv", Fuzzer.simple(), "0" },
                { "sample_file_1.csv" ,"sample_file_2.csv", Fuzzer.simple() },

                
        });
    }


    @Test
    public void test_check() {
        try{

        assertTrue(Compare_updated.compare(file1, file2, combo, true )==1);
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

       
        
    }

 

 

  



    

