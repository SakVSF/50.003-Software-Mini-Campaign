
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//This java test class checks if the check_empty_string() returns true if an empty string is passed

@RunWith(Parameterized.class)
public class CheckEmpty {

    String root_folder= "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/";   //please change path to your directory while running
    String file1;
    String file2;

    public CheckEmpty(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { "sample_file.csv" ,  "" },
                { "", "randomstring.csv" },
                { "" , "" },

                
        });
    }

    @Test
    public void test_check() {

        assertTrue(CompareCSV.check_empty_string(file1, file2)==true);
    }

}
