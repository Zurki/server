package com.build;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Filehandler{
    public static File readFileFromPath(String path){
        return new File(path);
    }

    public static File[] readAllFilesFromPath(String path){
        File folder = new File(path);
        File[] allFiles = folder.listFiles();
        return allFiles;
    }

    public static void deleteFile(){
    }

    public static void createFile(String path) throws IOException{
        Scanner s = new Scanner(System.in);
        System.out.println("to create File in current folder use '.'");
        System.out.print("Path> ");
        String ans = s.next();
        System.out.print("\nFilename> ");
        String name = s.next();

        if(ans.equals(".")){
            Path p = Paths.get(path + name);
            System.out.println("creating in here");
            Files.createFile(p);
            System.out.println("done");
        }
        else{
            Path p = Paths.get(ans + name);
            Files.createFile(p);
        }

        s.close();
    }

    public static void createFolder(String path, String name){

    }
}
