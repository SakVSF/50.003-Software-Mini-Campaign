import java.io.*;
import java.util.*;

public class week8
{ 
    static String filePath1;
    static String filePath2;
    static String filePath3;
    public static void setFile(String f1, String f2, String f3)
    {
        filePath1 = f1;
        filePath2 = f2;
        filePath3 = f3;
        
    }

    public static String[] getFile()
    {

        String[] filearray = new String[3];
        filearray[0] = filePath1;
        filearray[1] = filePath2;
        filearray[2] = filePath3;

        return filearray;
    }

    public static boolean checkExt(String filePath)
    {
        int n = filePath.length();
        String ext1 = filePath.substring(n-4,n);

        return ext1.equals(".csv");
    }
    
    public static boolean checkEmpty(String filePath)
    {
        try 
        {   System.out.print(filePath);
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            line = br.readLine();
            br.close();
            return (line == null);
            
        } catch (Exception e) {
            
            return false;
        }
        
    }
    public static void main(String[] args) 
    {
        setFile("sample_file_1.csv", 
        "sample_file_3.csv", 
        "output_file.csv");

        args = getFile();
        for (int i = 0; i<2; i++)
        {
            boolean extension = checkExt(args[i]);
            if (extension == false)
            {System.out.println("Wrong extension");}
            else 
            {System.out.println("File Not Found");}
        }
        try
        {
            
            File file1 = new File(args[0]);
            File file2 = new File (args[1]);
            File file3 = new File(args[2]);

            FileReader fr1 = new FileReader(file1);
            FileReader fr2 = new FileReader(file2);
            FileWriter fr3 = new FileWriter(file3);

            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2);
            BufferedWriter bw1 = new BufferedWriter(fr3);

            String line1 = " ";
            String line2 = " ";
            ArrayList <String> ar1 = new ArrayList<>();
            ArrayList <String> ar2 = new ArrayList<>();
            ArrayList <String> ar3 = new ArrayList<>();

            while (((line1 = br1.readLine()) != null))
            {ar1.add(line1 + "\n");}
            while ((line2 = br2.readLine()) != null)
            { ar2.add(line2 + "\n"); }

            for (int i = 0 ; i < ar2.size(); i++)
            {

                if ((ar1.get(i)).equals(ar2.get(i)))
                {continue;}
                else
                {  
                    ar3.add(ar1.get(i));
                    ar3.add(ar2.get(i));
                }
            }
            for (int j = 0; j<ar3.size(); j++)
            {
                bw1.write(ar3.get(j));
            }

            br1.close();
            br2.close();
            bw1.close();
            //System.out.println("ar3 : " + ar3);

        }
        catch (IOException ioe)
        {
           System.out.println();
           
        }
    }
}