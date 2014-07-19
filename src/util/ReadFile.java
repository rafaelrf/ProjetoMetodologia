package util;

import java.io.*;

public class ReadFile {
    BufferedReader in;
    String read;
  
    public ReadFile(){
        try {
            //open a bufferedReader to file helloworld.txt
            in = new BufferedReader(new FileReader("helloworld.txt"));
 
            //read a line from helloworld.txt and save into a string
            read = in.readLine();
 
            //print out the line
            System.out.println("file output: " + read);
 
            //safely close the BufferedReader after use
            in.close();
        }catch(IOException e){
            System.out.println("There was a problem:" + e);
        }
    }
    public static void main(String[] args){
        ReadFile File = new ReadFile();
    }


}

