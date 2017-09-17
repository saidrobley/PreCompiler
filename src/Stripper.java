import java.util.*;
import java. io.*;
import java.text.*;

public class Stripper
{
    public static void main(String[] args) throws Exception
    {

        String filename = "striptest-10a.txt"; // input file
       // PrintWriter outFile = new PrintWriter("test10.txt");
//        Scanner inFile = new Scanner(new FileReader(filename));

        removeEmptyLine();
        //removeWhitespace();
        // removeFullLineComment(); // don't need it anymore
        // removeInlineComment(); // good for both full-line comment and inline
        //removeMultComment();


        //outFile.close();


    }
//****************************************************************

    private static void removeEmptyLine() throws Exception {

        Scanner file = new Scanner(new File("striptest-10a.txt"));

        while(file.hasNextLine()){
            String line = file.nextLine();
            if(line.length() != 0){
                System.out.println(line);


            }

        }


    }
    //****************************************************************
    private static void removeWhitespace() throws Exception {

        Scanner file = new Scanner(new File("striptest-10a.txt"));

        while(file.hasNextLine()){
            String line = file.nextLine();
            int m = line.length();
            int n = 0;
            for(int i =0; i<m; i++){
                if(line.charAt(i) == '\t' || line.charAt(i) == ' '){
                    n++;
                }
            }
            if(m != n){
                System.out.println(line);
            }
        }
    }

    //****************************************************************
    private static void removeFullLineComment() throws Exception {
        Scanner file = new Scanner(new File("striptest-10a.txt"));

        while(file.hasNextLine()){
            String line = file.nextLine();

            if(line.length() >= 2 && line.charAt(0) != '/' && line.charAt(1) != '/'){
                System.out.println(line);
            }
        }
    }

    //****************************************************************
    private static void removeInlineComment() throws Exception {
        Scanner file = new Scanner(new File("striptest-10a.txt"));
        while(file.hasNextLine()){
            String line = file.nextLine();

            int count = 0;
            for(int i = 0; i < line.length()
                    ; i++){
                if(line.charAt(i) == '/'){
                    count = i;
                    if(line.charAt(count+1) == '/'){
                        break;
                    }
                } else
                    System.out.print(line.charAt(i));
            }
            System.out.println();
        }
    }
    //****************************************************************
    private static void removeMultComment() throws Exception {
        Scanner file = new Scanner(new File("striptest-10a.txt"));

        while(file.hasNextLine()){
            String line = file.nextLine();
            int count = 0;
            int count2 = 0;
            for(int i=0; i<line.length()-1; i++){
                if(line.charAt(i) == '/' && line.charAt(i + 1) == '*'){
                    break;

                } else
                    System.out.print(line.charAt(i));
            }
            for(int j =0; j<line.length(); j++){
                if(line.charAt(j) == '*'){
                    count2 = j;
                    if(line.charAt(count2 + 1) == '/'){
                        break;
                    }
                } else
                    System.out.print(line.charAt(j));
            }
            System.out.println();
        }

    }

}
  


 
