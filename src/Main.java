package com.build;

import com.build.*;
import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader s;


    public static void main(String[] args){
        s = new BufferedReader(new InputStreamReader(System.in));
        String dirPath = "";
        ArrayList dirs = new ArrayList();
        dirs.add("/");

        boolean on = true;

        while(on){
            try{
                dirPath = createPath(dirs);
                System.out.println(dirPath);

                Window.printAllFilesInDir(Filehandler.readAllFilesFromPath(dirPath));
                System.out.print("Command/Path:");
                String c = s.readLine();
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
                                      Commands.read(s, c, dirPath);
                                      break;
                    }
                    case PATH: {
                                   dirs.add(c);
                                   System.out.println(c);
                                   break;
                    }
                }
            }
            catch(Exception ex){
                if(dirs.size() < 1)
                    dirs = restoreDir();
                else
                    dirs.remove(dirs.size() - 1);
            }
            finally{
                cleanUp();
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

    private static void cleanUp()throws IOException{
        s.close();
    }
}
