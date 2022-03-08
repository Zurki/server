package com.build;

import java.io.*;
import java.util.*;

public class Commands{
    public enum VALUE{
        EXIT,
        COMMAND,
        PATH,
        RESTORE;

        VALUE(){}

        static VALUE getType(String type){
            switch(type){
                default:
                    return PATH;
                case "!help":
                    return COMMAND;

                case "~":
                    return RESTORE;
                case "!exit":
                    return EXIT;
            }
        }
    }

    public Commands(){
    }

    public static void read(String c){
        System.out.println("COMMAND");
    }
}
