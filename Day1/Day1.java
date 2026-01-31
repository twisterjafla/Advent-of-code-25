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
                System.out.print(position + " : ");
                int isPos = line.charAt(0)=='L'? -1 : 1; 
                int addVal = Integer.valueOf(line.substring(1));
                position+=isPos*addVal;
                //System.out.print(position + " : ");
                while (position>99){
                    position-=99;
                }
                while (position<0){
                    position+=99;
                }

                System.out.println(line + " : " + position);

                if (position==0){
                    ZeroCount++;
                }

            }

            System.out.println("Passcode is " + ZeroCount);

        }
        catch (IOException e){
            System.err.println("Could not read file");
        }

    }
}
