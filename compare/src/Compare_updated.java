import java.io.*;
import java.util.ArrayList;


public class Compare_updated{
    static String root_folder = "C:/Users/Saakshi Saraf/OneDrive/Documents/SUTD/ESC/compare/src/";



    public static int compare(String file1, String file2, String combination, boolean column ) throws FileNotFoundException, IOException
    {
      
        String file3= root_folder+"sample_output.csv";
        int max_length = 25;
        if(file1.length()>25 || file2.length()>25 || combination.length()>25){
            file1 =file1.substring(0,max_length) ;
            file2 =file2.substring(0,max_length) ;
            combination =combination.substring(0,max_length) ;

        }
        
        
        


        if(check_empty_string(file1, file2, combination)){
            System.out.println("Empty string passed to function");
            return 1;
        }

        if(!check_extension(file1, file2)){
            System.out.println("Wrong extension. Must be a .csv file");
            return 1;

        }
        
  

        String[] combo= combination.trim().split(",");//get combination to compare against
      /*   if(combo.length==0){
            System.out.println("Empty combination entered. Aborting");
            return 1;

        }
        */
        ArrayList<Integer> indices= new ArrayList<>();
        try{
                    //split combo to get indices that have to be ignored 
                for(String i:combo){
                    if(i.matches("[0-9.]+")){
                    indices.add(Integer.parseInt(i));
                    }
                }

                }
        catch (NumberFormatException e) {
                System.out.println("wrong format for combination, aborting");
                return 1;
            
            }




    
        try{
               
            
            //-----------------------------------------------------------------------------------------------------------------------
                
                    BufferedReader CSVFile1 = new BufferedReader(new FileReader(file1));    //open file1 to read
                    BufferedReader CSVFile2 = new BufferedReader(new FileReader(file2));    //open file2 to read    
                    
                    int rowno1 =0;
                    int rowno2= 0; 
                    String dataRow1 = CSVFile1.readLine();  //reading header row 
                    String dataRow2 = CSVFile2.readLine();   //reading header row 
                // if(!column){
                    rowno1++;
                    rowno2++;
                    String header = new String(dataRow1);
                // }
                    
                    String[] line1 = dataRow1.split(",");
                    String[] line2 = dataRow2.split(","); 

                    if(line1.length<2 || line2.length<2){
                        System.out.println("input file needs to have atleast 2 columns.Aborting");
                        CSVFile1.close();  //closing all buffers 
                        CSVFile2.close();  
                    
                        return 1;
                    }
                    else if(line1.length>5 || line2.length>5){
                        System.out.println("input file needs to have maximum 5 columns. Aborting");
                        CSVFile1.close();  //closing all buffers 
                        CSVFile2.close();  
                        
                        return 1;
                    }
                    else if(line1.length!=line2.length){
                        System.out.println("Both files need to have same number of columns. Aborting");
                        CSVFile1.close();  //closing all buffers 
                        CSVFile2.close();  
                    
                        return 1;

                    }
                    else if(line1.length<=combo.length){
                        System.out.println("Combination entered is more than/ equal to number of columns in files.");
                        CSVFile1.close();  //closing all buffers 
                        CSVFile2.close();  
                
                        return 1;

                    }
                
                //-------------------------------------------------------------------------------------


                    //will only proceed if above conditions unsatisfied
                    int colno = line1.length;
                    
                    ArrayList<String> records1= new ArrayList<>(); //contains strings to be compared in csvfile1
                    ArrayList<String> records2 = new ArrayList<>(); //contains strings to be compared in csvfile1
                    ArrayList<String> records1_full= new ArrayList<>(); //contains strings to be compared in csvfile1
                    ArrayList<String> records2_full = new ArrayList<>(); //contains strings to be compared in csvfile1
                    
                    

                    if(column==true){
                        //need to skip first row as its reserved for column headers 
                    dataRow1 = CSVFile1.readLine(); 
                    dataRow2 = CSVFile2.readLine();
                    if(dataRow1!=null)
                    { rowno1++;}
                    if(dataRow1!=null)
                    { rowno2++;}
                   
                    

                    }
                

                //read first file 

                    
                 //--------------------------------------------------------------------------------
                    while (dataRow1 != null)
                    {   String[] wholerow= dataRow1.split("/n");
                  //     System.out.print("went in");
                  //     System.out.print(dataRow1);
                        String[] dataArray1 = wholerow[0].split(",");
                    //  System.out.print(dataArray1);
                        String row = "";
                        //choose which cells to add and which cells to be ignored

                        for (int i =0 ; i<dataArray1.length; i++)
                        {
                            int flag =0 ; //to be compared
                            for(Integer j: indices){
                                if (i==j){
                                    flag =1; //to be ignored
                                    break ;
                                }

                            }

                            if(flag==0){
                                //to be added to compare list
                                String result = dataArray1[i].replaceAll("\"", "");
                                String record = result.toString();  //add cell to string

                                row+=record;
                                row+=",";
                                            
                                
                            }
                           }

                        //row contains string to be added to record1
                            row =row.substring(0, row.length() - 1) ;   
                            records1.add(row);
                            records1_full.add(wholerow[0]);

                          /*  System.out.print("full row1:  ");
                            System.out.println(records1_full);
                            System.out.print("\n  ");
                            System.out.print(records1);
                            System.out.print("\n  ");

 */

                            dataRow1 = CSVFile1.readLine(); // Read next line of data.
                            rowno1++;

                            if(column && rowno1>1001 || !column && rowno1>1000){
                                System.out.print("Max row limit reached. Stopped reading file1  ");

                            }
                    

                    }    
                 //   System.out.print(records1.get(0));

                 //--------------------------------------------------------------------------------------------------------------------------

                    //now storing into records2
                    while (dataRow2 != null)
                        {   String[] wholerow= dataRow2.split("/n");
                        //   System.out.print(wholerow);

                            String[] dataArray2 = wholerow[0].split(",");
                        //  System.out.print(dataArray1);
                            String row2 = "";
                            //choose which cells to add and which cells to be ignored

                            for (int i =0 ; i<dataArray2.length; i++)
                            {
                                int flag =0 ; //to be compared
                                for(Integer j: indices){
                                    if (i==j){
                                        flag =1; //to be ignored
                                        break ;
                                    }

                                }

                                if(flag==0){
                                    //to be added to compare list
                                    String result = dataArray2[i].replaceAll("\"", "");
                                    String record = result.toString();  //add cell to string

                                    row2+=record;
                                    row2+=",";
                                                
                                    
                                }
                            }

                            //row contains string to be added to record1
                            row2 =row2.substring(0, row2.length() - 1) ;   
                            records2_full.add(wholerow[0]);
                            records2.add(row2);
                           /*System.out.print("Full record2 ");
                            System.out.println(records2_full);
                            System.out.print("\n ");
                            System.out.print(records2);
                            System.out.print("\n ");
                            System.out.print("a cell in full record2 ");
                            System.out.println(records2_full.get(0));
                            */



                            dataRow2= CSVFile2.readLine(); // Read next line of data.
                            rowno2++;
                            if(column && rowno2>1001 || !column && rowno2>1000){
                                System.out.print("Max row limit reached. Stopped reading file1  ");

                            }
                

                


                    }
                   // System.out.print(records1);
                  //  System.out.print(records2);
                  System.out.println(rowno1);
                  System.out.println(rowno2);

                    if (column && rowno1==1 || !column && rowno1<1){
                        System.out.println("Minimum row limit not satisfied");
                        CSVFile1.close();  //closing all buffers 
                        CSVFile2.close();  
                    //    writer.flush();
                    //    writer.close();
                        return 1;

                    }  
                    System.out.println(records1.size());
                    System.out.println(records1_full.size());
                    System.out.println(records2.size());
                    System.out.println(records2_full.size());


                //--------------------------------------------------------------------------
                ArrayList<String> output= new ArrayList<>(); //contains strings to be compared in csvfile1
                    for (String match : records2) {
                      //  System.out.println(match);
                        if (records1.contains(match)) {
                           int index_remove = records1.indexOf(match);
                            //String match_remove = records1_full.get(index_remove);
                            //System.out.println("Match found");
                            //System.out.println("Index to be removed from:");
                            //System.out.println(index_remove);
                            String match_remove= records1_full.get(index_remove);
                            records1.remove(match);
                            records1_full.remove(match_remove);
                        } else {
                           int index_add = records2.indexOf(match);
                           //System.out.println("Match not found");
                          // System.out.println("Index to be added from:");
                          //System.out.println(index_add);
                          String match_add= records2_full.get(index_add);
                   
                            records1.add(match);
                            records1_full.add(match_add);

            
                        }
                    }
                  
                   // System.out.print("Mismatched output:");
                   // System.out.print("/n");
                   // System.out.print(records1_full);


                   
            
                    int size = records1_full.size();
                    System.out.println(size);

                    FileWriter writer=new FileWriter(file3);   //open file to write 
                    if(column){
                        writer.append("" + header);
                        writer.append('\n');
                        
                        
                    }
                    while (size != 0) {
                        size--;
                        writer.append("" + records1_full.get(size));
                        writer.append('\n');
                    }
                    writer.flush();
                    writer.close();

              
                    CSVFile1.close();  //closing all buffers 
                    CSVFile2.close();  
                    //writer.flush();
                    //writer.close();
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


public static boolean check_empty_string(String file1, String file2, String combo){
    if(file1=="" | file2=="" | combo==""){
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
    String file1="./src/sample_file_4.csv";
    String file2="./src/sample_file_4.csv";
    String combo = "0";
    try{
        int a = compare(file1, file2, combo,true);
        if (a==0){
            System.out.println("Program executed successfully");
        }
        if (a==1){
            System.out.println("Program executed unsuccessfully");
        }

    }
    catch(Exception e){
        System.out.println("exception occured");
        e.printStackTrace();

    }
    finally{

    }

  
    
    }
}
