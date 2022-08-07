
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//This java test class checks whether the output file has the corrrect extension.
//Expected to return a IllegalArgument exception.

@RunWith(Parameterized.class)
public class Combination {

    String root_folder= "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/"; 
    String file1;
    String file2;
    String combo;

    public Combination(String file1, String file2, String combo) {
        this.file1 = file1;
        this.file2 = file2;
        this.combo = combo;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { "sample_file_1.csv" ,  "sample_file_2.csv" , "0,1,2,3,4,5"},
                { "sample_file_1.csv", "sample_file_2.csv", "not a combination" },
                { "sample_file_1.csv", "sample_file_2.csv", "0,20,45,6" },
              
                
        });
    }

    @Test
    public void test_check() {
        try{assertTrue(Compare_updated.compare(file1, file2, combo, true)==1);}
        catch(Exception e){
            e.printStackTrace();
        }

        
    }

}
