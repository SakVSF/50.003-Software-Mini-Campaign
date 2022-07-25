

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//This java test class checks if check_extension() returns false if wrong extension/no extension strings are passed 

@RunWith(Parameterized.class)
public class CheckExtension_test {

    String root_folder= "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/";  //please change path to your directory while running
    String file1;
    String file2;

    public CheckExtension_test(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { "sample_file.csvv" ,  "sample_file_1.exe" },
                { "sample_file.csvv", "randomstring" },
                { "wrong_extension.docx" , "a2.csv" },

                
        });
    }

    @Test
    public void test_check() {

        assertTrue(CompareCSV.check_extension(file1, file2)==false);
    }

}
