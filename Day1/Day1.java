package Day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {
    public static void main(String[] args){
        Path filePath = Paths.get("/home/artemis/code/Advent of code 25/Day1/input.txt");

        int position=50;
        int ZeroCount=0;

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line:lines){
                boolean allowScoring = position!=0;

                System.out.print(position + " : ");
                int isPos = line.charAt(0)=='L'? -1 : 1; 
                int addVal = Integer.valueOf(line.substring(1));
                position+=isPos*addVal;
                //System.out.print(position + " : ");

                if (position>99||position<0)
                    while(position>99||position<0){
                        if (position>0) position-=100;
                        else{
                            position+=100;
                            if (position==0) ZeroCount++;
                        }
                        
                        // if (position==0){
                        //     ZeroCount++;
                        //     allowScoring=false;
                        // }
                        if (allowScoring){ 
                            ZeroCount++;
                            allowScoring=true;
                        }
                        
                    }

                else if (position==0){
                    ZeroCount++;
                }

                System.out.println(line + " : " + position + " : " + ZeroCount);



            }

            System.out.println("Passcode is " + ZeroCount);

        }
        catch (IOException e){
            System.err.println("Could not read file");
        }

    }
}
