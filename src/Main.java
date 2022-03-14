package com.build;

import com.build.*;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        boolean autolist = Window.boolInput("Turn on autolist? (y/n)> ");
        ArrayList dirs = new ArrayList();
        dirs.add("/");
        String dirPath = createPath(dirs);

        boolean on = true;

        while(on){
            try{
                if(autolist)
                    Window.printAllFilesInDir(dirPath, Filehandler.readAllFilesFromPath(dirPath));

                System.out.print("Command/Path> ");
                String c = Window.reader.readLine();
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
                                      Commands.read(c, dirPath);
                                      break;
                    }
                    case PATH: {
                                   dirs.add(c);
                                   dirPath = createPath(dirs);
                                   if(!Filehandler.isDirectoryExisting(dirPath)){
                                        Window.error("Directory does not exist");
                                        dirs.remove(dirs.size() - 1);
                                   }
                                   break;
                    }
                }
                dirPath = createPath(dirs);
            }
            catch(Exception ex){
                Window.error("Action not possible");
                if(dirs.size() < 1)
                    dirs = restoreDir();
                else
                    dirs.remove(dirs.size() - 1);
            }
        }
    }

    private static ArrayList restoreDir(){
        ArrayList out = new ArrayList();
        out.add("/");
        return out;
    }

    private static String createPath(ArrayList arr){
        String dir = "/";
        for(int i = 1; i < arr.size(); i++){
            dir += arr.get(i);
            dir += "/";
        }
        return dir;
    }
}
