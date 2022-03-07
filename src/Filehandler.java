package com.build;

import java.io.*;
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

    public static void createFile(String name, String type){

    }

    public static void createFolder(String name){

    }
}
