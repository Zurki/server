package com.build;

import com.build.*;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String dirPath;
        ArrayList dirs = new ArrayList();
        dirs.add("/");

        boolean on = true;

        while(on){
            try{
                dirPath = createPath(dirs);

                Window.printAllFilesInDir(Filehandler.readAllFilesFromPath(dirPath));
                System.out.print("Command/Path:");
                String c = s.next();
                Commands.VALUE type = Commands.VALUE.getType(c);

                switch(type){
                    case RESTORE: {
                        dirs = restoreDir();
                        break;
                    }

                    case BACK: {
                        if(dirs.size() <= 1)
                            dirs = restoreDir();
                        else
                            dirs.remove(dirs.size() - 1);
                        break;
                    }

                    case EXIT: {
                        on = false;
                        break;
                    }
                    case COMMAND: {
                        Commands.read(c);
                        break;
                    }
                    case PATH: {
                        dirs.add(c);
                        break;
                    }
                }
            }
            catch(Exception ex){
                System.out.println("not a valid input");
                if(dirs.size() <= 1)
                    dirs = restoreDir();
                else
                    dirs.remove(dirs.size() - 1);
            }
        }
        s.close();
        //System.out.println();        //Window.printAllFilesInDir(Filehandler.readAllFilesFromPath(lastDir));
    }

    private static ArrayList restoreDir(){
        ArrayList out = new ArrayList();
        out.add("/");
        return out;
    }

    private static String createPath(ArrayList arr){
        String dir = "";
        for(int i = 0; i < arr.size(); i++)
            dir += arr.get(i) + "/";
        return dir;
    }
}

