

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;


import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



public class SimplefuzzTest {

    @Test
    public void writeOutput_check() {
        try{
            ArrayList<String> content2 = new ArrayList<>();
            content2.add(Fuzzer.simple());
            content2.add(Fuzzer.simple());
            content2.add(Fuzzer.simple());
            content2.add("end");


        //week8.setFile(Fuzzer.simple() ,  "sample_file_1.csv", "output_file.csv");
          CompareCsv.Writeoutput("test.csv", content2);
    }
    catch(Exception e){
        e.printStackTrace();
    }
}


       
        
    }

 

 

  



    

