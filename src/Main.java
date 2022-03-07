package com.build;

import com.build.*;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String lastDir = "/";
        String latestDir = "/";

        System.out.println(latestDir + ": \n");

        boolean on = true;

        while(on){
            try{
                Window.printAllFilesInDir(Filehandler.readAllFilesFromPath(latestDir));
                System.out.print("Command/Path:");
                String c = s.next();
                COMMANDTYPE.VALUE type = COMMANDTYPE.VALUE.getType(c);

                switch(type){
                    case EXIT: {
                        on = false;
                        break;
                    }
                    case COMMAND: {
                        Commands.read(c);
                        break;
                    }
                    case PATH: {
                        lastDir = latestDir;
                        latestDir += c + "/";
                        break;
                    }
                    case RESTORE: {
                        latestDir = "/";
                        break;
                    }
                }
            }
            catch(Exception ex){
                System.out.println("not a valid input");
                latestDir = lastDir;
            }
        }
        s.close();
        //System.out.println();        //Window.printAllFilesInDir(Filehandler.readAllFilesFromPath(lastDir));
    }
}

