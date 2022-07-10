import java.io.*;

public class CompareCSV {


    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        
        String file1="sample_file_1.csv";
        String file2="sample_file_3.csv";
        String file3="sample_output.csv";
    

        BufferedReader CSVFile1 = new BufferedReader(new FileReader(file1));    //open file1 to read
        String dataRow1 = CSVFile1.readLine();  //reading header row 
       
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(file2));    //open file2 to read
        String dataRow2 = CSVFile2.readLine();   //reading header row 

        
        FileWriter writer=new FileWriter(file3);   //open file to write 


        dataRow1 = CSVFile1.readLine(); 
        dataRow2 = CSVFile2.readLine();

     
        while (dataRow1 != null && dataRow2!=null)
        {
            String[] line1 = dataRow1.split(",");   //getting array of cells in one row 
            String[] line2 = dataRow2.split(","); 

            String currency1= line1[2].replaceAll("\"", "");
            String currency2 = line2[2].replaceAll("\"", "");
             

            String type1 = line1[3].replaceAll("\"", "");
            String type2 = line2[3].replaceAll("\"", "");
            
           
            int balance1 = Integer.parseInt(line1[4].replaceAll("\"", ""));
            int balance2 = Integer.parseInt(line2[4].replaceAll("\"", ""));
            

                if(balance1!=balance2 | !currency1.equals(currency2) | !type1.equals(type2) ){   //checking for mismatch 
                  
                    //write to output file if mismatch found
                    int i;
                    for( i=0; i<line1.length-1; i++){
                        writer.write(line1[i]+",");

                    }
                    writer.write(line1[i]+"\n");

                    int j;
                    for( j=0; j<line2.length-1; j++){
                        writer.write(line2[j]+",");

                    }
                    writer.write(line2[j]+"\n");
                }
           
            dataRow1 = CSVFile1.readLine(); // Read next line of file1
            dataRow2= CSVFile2.readLine();  //Read next line of file2


        }       

        CSVFile1.close();  //closing all buffers 
        CSVFile2.close();  
        writer.flush();
        writer.close();
    
        }

        
        
}
