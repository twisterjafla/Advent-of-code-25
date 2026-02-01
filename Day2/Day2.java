package Day2;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day2 {
    public static void main(String[] Args){
        long count=0;

        try {
            Scanner scanner = new Scanner(new File("/home/artemis/code/Advent of code 25/Day2/input.txt"));
            scanner.useDelimiter(Pattern.compile("[,]"));


            while (scanner.hasNext()) {
                String token = scanner.next();
                Long[] range = {Long.valueOf(token.split("-")[0]), Long.valueOf(token.split("-")[1])};

                for (long i=range[0]; i<=range[1]; i++){
                    String iStr = Long.toString(i);
                    String firstHalf, secondHalf;
                    if (iStr.length()%2==0){
                        firstHalf = iStr.substring(0, iStr.length()/2);
                        secondHalf = iStr.substring(iStr.length()/2);
                        if (firstHalf.equals(secondHalf)){

                        System.out.println(i + " Identified as a number. Incrementing count from " + count + " to " + (count+i));
                        count+=i;
                    }
                    }
                    // else{
                    //     firstHalf = iStr.substring(0, (iStr.length()-1)/2);
                    //     secondHalf = iStr.substring((iStr.length()+1)/2);
                    // }
                    //System.out.println(firstHalf + "+" + secondHalf);
                   
                }
            }
        }
        catch (IOException e){
            System.err.println("Could not read file");
        }

        System.out.println("Final Awnser: " + count);
    }
}
