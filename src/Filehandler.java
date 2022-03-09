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
        System.out.println("to create File in current folder use '.'");
        System.out.print("Path> ");
        String ans = Window.reader.readLine();
        System.out.print("Filename> ");
        String name = Window.reader.readLine();


        System.out.println(path + name);
        if(ans.equals(".")){
            Path p = Paths.get(path + name);
            if(!Files.exists(p)){
                Files.createFile(p);
                Window.success("File created");
            }
            else
                Window.denied("File already exists");
        }
        else{
            Path p = Paths.get(ans + name);
            if(!Files.exists(p)){
                Files.createFile(p);
                Window.success("File created");
            }
            else
                Window.denied("File already exists");
        }
    }

    public static void createFolder(String path, String name){

    }
}
