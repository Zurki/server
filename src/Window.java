package com.build;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Window{
    public Window(){}
    public static void printAllFilesInDir(File[] allFiles){
        int i = 0;
        if(allFiles.length <= 0)
            System.out.println("THIS DIR IS EMPTY\n");
        for(File f : allFiles){
            System.out.println(getOutputString(f, ++i));
        }
    }

    private String getFileType(File f){
        //soll die Dateiendungen rausfindenr
        return "needs implementation";
    }

    private static String formatFileName(File f){
        if(f.getName().length() <= 15)
            return f.getName();
        else{
            return f.getName().substring(0, (Math.min(f.getName().length(), 12))) + "...";
        }
    }
    private static String getOutputString(File f, int index){
        BasicFileAttributes att;
        try{
            att = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
            return String.format("%-5s", index) + "| " + String.format("%-15s", formatFileName(f)) + " | " + String.format("%-30s", att.creationTime()) + " | " + att.size();
        }
        catch(IOException e){
            System.out.println("FileNotFound");
        }
        return "";
    }
}
