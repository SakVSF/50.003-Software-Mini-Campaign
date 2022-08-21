import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CompareCsv {
    public static void main(String[] args) throws Exception {

       
        ArrayList<String> differences = new ArrayList<String>();
        try{
            Scanner sc1 = new Scanner(new File("sample_file_1.csv"));
            Scanner sc2 = new Scanner(new File("sample_file_3.csv"));
            sc1.useDelimiter(",");
            sc2.useDelimiter(",");
            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                String line2 = sc2.nextLine();
                if (!line.equals(line2)) {
                    differences.add(line);
                    differences.add(line2);
                }
            }
            sc1.close();
            sc2.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        // Output file
        
        Writeoutput("output.csv",differences);
        
    }

    public static void Writeoutput(String filepath,ArrayList<String> content)
    {
        String output = "";
        try{
            FileWriter fw = new FileWriter(filepath);

            for (int i = 0; i < content.size(); i++) {
                output += content.get(i) + "\n";
            
            }
            System.out.print(output);
            System.out.print(filepath);
            fw.write(output);
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file!");
        } 
    }
}