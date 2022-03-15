package com.build;

import java.io.*;
import java.util.*;


public class Sorter{
    public static File[] sortByName(File[] f){
        String[] toSort = getNamesFromFileArr(f);
        Arrays.sort(toSort);
        return toSort;
    }

    public static File[] sortByDate(File[] f){
        return f;
    }

    public static File[] sortBySize(File[] f){
        return f;
    }

    private static String getNamesFromFileArr(File[] f){
        ArrayList<String> out;
        for (int i = 0; i < f.length; f++){
            out.add(f[i].getName());
        }
        return out.toArray();
    }
}
