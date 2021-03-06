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

    public static void deleteFile(String path)throws IOException{
        Window.message("If you want to delete file in current folder use '.'");
        String ans = Window.input("Path> ");
        if(ans.equals("."))
            ans = path + Window.input("File> ");
        Path p = Paths.get(ans);

        if(Files.exists(p)){
            Files.delete(p);
            Window.success(ans + " was deleted");
        }

        else
            Window.error("File does not exist");
    }


    public static void createFile(String path) throws IOException{
        Window.message("To create File in current folder use '.'");
        String ans = Window.input("Path> ");
        String name = Window.input("Filename> ");

        if(!ans.equals("."))
            path = ans;

        if(generateFile(path+ name)){
            Window.success("File created");
        }
        else
            Window.denied("File already exists");
    }

    public static void createDir(String path) throws IOException{
        Window.message("To create Directory in current folder use '.'");
        String ans = Window.input("Path> ");
        String name = Window.input("Filename> ");

        if(!ans.equals("."))
            path = ans;

        if(generateDir(path+ name)){
            Window.success("Directory created");
        }
        else
            Window.denied("Directory already exists");
   }


    private static boolean generateFile(String path) throws IOException{
        Path p = Paths.get(path);
        if(!Files.exists(p)){
            Files.createFile(p);
            return true;
        }
        return false;
    }

    private static boolean generateDir(String path) throws IOException{
        Path p = Paths.get(path);
        if(!Files.exists(p)){
            Files.createDirectory(p);
            return true;
        }
        return false;
    }

    public static boolean isDirectoryExisting(String path){
        Path p = Paths.get(path);
        if(Files.exists(p) && Files.isDirectory(p))
            return true;
        return false;
    }
}
