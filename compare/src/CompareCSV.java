import java.io.*;


public class CompareCSV {
    static String root_folder = "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/";  //please change path to your directory while running



    public static int compare(String file1, String file2, boolean column ) throws FileNotFoundException, IOException
    {
      
        String file3= root_folder+"sample_output.csv";


        if(check_empty_string(file1, file2)){
            System.out.println("Empty string passed to function");
            return 1;
        }

        if(!check_extension(file1, file2)){
            System.out.println("Wrong extension. Must be a .csv file");
            return 1;

        }
        
    


    
        try{
        
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(file1));    //open file1 to read
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(file2));    //open file2 to read    
        FileWriter writer=new FileWriter(file3);   //open file to write 

        int rowno =0;
        String dataRow1 = CSVFile1.readLine();  //reading header row 
        String dataRow2 = CSVFile2.readLine();   //reading header row 
        if(!column){
            rowno++;
        }
        
        String[] line1 = dataRow1.split(",");
        String[] line2 = dataRow2.split(","); 

        if(line1.length<2 || line2.length<2){
            System.out.println("input file needs to have atleast 2 columns");
            CSVFile1.close();  //closing all buffers 
            CSVFile2.close();  
            writer.flush();
            writer.close();
            return 1;
        }
        else if(line1.length>5 || line2.length>5){
            System.out.println("input file needs to have maximum 5 columns");
            CSVFile1.close();  //closing all buffers 
            CSVFile2.close();  
            writer.flush();
            writer.close();
            return 1;
        }
        else if(line1.length!=line2.length){
            System.out.println("Both files need to have same number of columns");
            CSVFile1.close();  //closing all buffers 
            CSVFile2.close();  
            writer.flush();
            writer.close();
            return 1;

        }
        int colno = line1.length;
        



        


        if(column==true){
        dataRow1 = CSVFile1.readLine(); 
        dataRow2 = CSVFile2.readLine();
        rowno++;

        }
    

      

     
        while (dataRow1 != null && dataRow2!=null)
        {
            line1 = dataRow1.split(",");   //getting array of cells in one row 
            line2 = dataRow2.split(","); 

            if(colno==2){

                String match1= line1[2].replaceAll("\"", "");
                String match2 = line2[2].replaceAll("\"", "");

                if(!match1.equals(match2)){

                    write_to_output(line1, line2, writer);
                    

                }

                
            }
            else if(colno==3){
                String match1= line1[2].replaceAll("\"", "");
                String match2 = line2[2].replaceAll("\"", "");

                String type1 = line1[3].replaceAll("\"", "");
                String type2 = line2[3].replaceAll("\"", "");

                if(!match1.equals(match2) | !type1.equals(type2)){
                    write_to_output(line1, line2, writer);

                }

            }

            else {
                String match1= line1[2].replaceAll("\"", "");
                String match2 = line2[2].replaceAll("\"", "");
             

                String type1 = line1[3].replaceAll("\"", "");
                String type2 = line2[3].replaceAll("\"", "");
                
            
                int balance1 = Integer.parseInt(line1[4].replaceAll("\"", ""));
                int balance2 = Integer.parseInt(line2[4].replaceAll("\"", ""));
            

                if(balance1!=balance2 | !match1.equals(match2) | !type1.equals(type2) ){   //checking for mismatch 
                    write_to_output(line1, line2, writer);
              }

            }
           
            dataRow1 = CSVFile1.readLine(); // Read next line of file1
            dataRow2= CSVFile2.readLine();  //Read next line of file2
            rowno++;

            System.out.println(rowno);

            if(rowno>1001){
                System.out.println("Max row limit reached");
                CSVFile1.close();  //closing all buffers 
                CSVFile2.close();  
                writer.flush();
                writer.close();
                return 1;

            }


        }    
        if (column && rowno==1){
            System.out.println("Minimum rows required in each file is 2 ");
            CSVFile1.close();  //closing all buffers 
            CSVFile2.close();  
            writer.flush();
            writer.close();
            return 1;

        }   

        if (!column && rowno<1){
            System.out.println("Minimum rows required in each file is 1 ");
            CSVFile1.close();  //closing all buffers 
            CSVFile2.close();  
            writer.flush();
            writer.close();
            return 1;

        }
        CSVFile1.close();  //closing all buffers 
        CSVFile2.close();  
        writer.flush();
        writer.close();
        return 0;
    
        }

    
    catch (FileNotFoundException e) {
        System.out.println("File not found");
        return 1;
    
    }
    catch (IOException e) {
        System.out.println("IOException occured ");
        return 1;
    
    }


        
        
}


public static boolean check_empty_string(String file1, String file2){
    if(file1=="" | file2==""){
        return true;
    }
    else{
        return false;
    }

}

public static boolean check_extension(String file1, String file2){
        String extension = "";
        int x = file1.lastIndexOf('.');
        if (x >= 0) { extension = file1.substring(x+1); }

        String extension2 = "";
        int x2 = file2.lastIndexOf('.');
        if (x2 >= 0) { extension2 = file2.substring(x2+1); }


        if(!extension.equals("csv") | !extension2.equals("csv")){
            return false;

        }
        else{
            return true ;
        }
}

public static void write_to_output(String[] line1, String[] line2, FileWriter writer){
    try{int i;
        for( i=0; i<line1.length-1; i++){
            writer.write(line1[i]+",");
    
        }
        writer.write(line1[i]+"\n");
    
        int j;
        for( j=0; j<line2.length-1; j++){
            writer.write(line2[j]+",");
    
        }
        writer.write(line2[j]+"\n");}

    catch(IOException e){
        e.printStackTrace();
    }
    
}
public static void main(String args[]){
    String file1="./src/sample_file_1.csv";
    String file2="./src/sample_file_2.csv";
    try{
        int a = compare(file1, file2, true);
        if (a==0){
            System.out.println("Program executed successfully");
        }
        if (a==1){
            System.out.println("Program executed unsuccessfully");
        }

    }
    catch(Exception e){
        System.out.println("exception occured");

    }
    finally{

    }
    
    }
}
