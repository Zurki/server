package com.build;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Window{
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public Window(){}

    public static void error(String msg){
        System.out.println(ANSI_RED + "[ERROR]" + ANSI_RESET + msg);
    }

    public static void denied(String msg){
        System.out.println(ANSI_YELLOW + "[DENIED] " + ANSI_RESET + msg);
    }

    public static void warning(String msg){
        System.out.println(ANSI_CYAN + "[WARNING] " + ANSI_RESET + msg);
    }

    public static void message(String msg){
        System.out.println("[CONSOLE] " + msg);
    }

    public static void success(String msg){
        System.out.println(ANSI_GREEN + "[SUCCESS] " + ANSI_RESET + msg);
    }

    public static void printAllFilesInDir(File[] allFiles){
        int i = 0;
        if(allFiles.length <= 0)
            warning("This directory is empty");
        for(File f : allFiles){
            System.out.println(getOutputString(f, ++i));
        }
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
            String type = "File";
            if(f.isDirectory())
                type = "Folder";

            att = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
            return String.format("%-5s", index) + "| " + String.format("%-15s", formatFileName(f))
                + " | " + String.format("%-6s", type)
                + " | " + String.format("%-30s", att.creationTime()) +
                " | " + att.size();
        }
        catch(IOException e){
            System.out.println("FileNotFound");
        }
        return "";
    }
}
