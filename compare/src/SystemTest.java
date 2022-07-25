


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import org.junit.Test;
//system level testing for boundary values 
public class SystemTest {
    String root_folder = "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/"; 
   

   
    @Test
    public void testEmpty(){
        String file1="sample_file_1.csv";
        String file2="";
        try{
            int a = CompareCSV.compare(file1, file2, true);
            assertTrue(a==1);
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{

        }
        
    }

    @Test
    public void testNotFound(){
        String file1="sample_file_1.csv";
        String file2="file_not_in_folder.csv";
        try{
            assertEquals(CompareCSV.compare(file1, file2, true), 1);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{

        }

    }
 
    @Test
    public void testWrongExtension(){
        String file1="./src/wrong_extension.docx";
        String file2="./src/sample_file_2.csv";
        try{
            assertEquals(CompareCSV.compare(file1, file2, true), 1);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }

 
    @Test
    public void testBoundary_1row(){
        String file1= root_folder + "row1_samplefile.csv";
        String file2= root_folder + "sample_file_2.csv";
        try{
            assertTrue(CompareCSV.compare(file1, file2, true)==0);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }



    @Test
    public void testBoundary_1col(){
        String file1=root_folder + "1col_samplefile.csv";
        String file2=root_folder + "sample_file_2.csv";
        try{
            assertEquals(CompareCSV.compare(file1, file2, true), 1);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }



    @Test
    public void testBoundary_6col(){
        String file1=root_folder + "6col_samplefile.csv";
        String file2=root_folder+ "sample_file_2.csv";
        try{
            assertEquals(CompareCSV.compare(file1, file2, true), 1);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }


    @Test
    public void testBoundary_1001rows(){
        String file1=root_folder + "1001rows_sample.csv";
        String file2=root_folder + "1001rows_sample.csv";
        try{
            assertEquals(CompareCSV.compare(file1, file2, true), 1);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }



    @Test
    public void  CorrectOutput(){
        String file1=root_folder + "sample_file_1.csv";
        String file2=root_folder+ "sample_file_3.csv";
        
        try{
            assertEquals(CompareCSV.compare(file1, file2, true), 0);
            
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }

    @Test
    public void  EmptyOutput(){
        String file1=root_folder + "sample_file_1.csv";
        String file2=root_folder+ "sample_file_1.csv";
        String output= root_folder + "sample_output.csv";
        
        try{
            int a = CompareCSV.compare(file1, file2, true); 
            BufferedReader CSVFile1 = new BufferedReader(new FileReader(output)); 
            String dataRow1 = CSVFile1.readLine(); 
            String[] line1 = dataRow1.split(",");
            assertTrue(line1.length==0);
            CSVFile1.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
        }

    }



    @Test
    public void MatchOutput(){

        String file1=root_folder + "sample_file_1.csv";
        String file2=root_folder+ "sample_file_2.csv";
        String output= root_folder + "sample_output.csv";
        
        try {
        int a = CompareCSV.compare(file1, file2, true); 
        assertTrue(a==0);
        InputStream is = new BufferedInputStream(new FileInputStream(output));
        byte[] c = new byte[1024];
        int count = 0;
        int readChars = 0;
        boolean empty = true;
        while ((readChars = is.read(c)) != -1) {
            empty = false;
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n') {
                    ++count;
                }
            }
        }
       
        assertTrue(count==2000);
        is.close();
        
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    }


    
}
