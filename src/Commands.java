package com.build;

import java.io.*;
import java.util.*;

public class Commands{
    public enum VALUE{
        EXIT,
        COMMAND,
        PATH,
        BACK,
        RESTORE;

        VALUE(){}

        static VALUE getType(String type){
            switch(type){
                default:
                    return PATH;


                case "!help":
                    return COMMAND;
                case "!fcreate":
                    return COMMAND;
                case "!mk":
                    return COMMAND;

                case "!back":
                    return BACK;
                case "..":
                    return BACK;
                case "~":


                    return RESTORE;
                case "!exit":
                    return EXIT;
            }
        }
    }


    public static void read(String c, String path) throws IOException{
        switch(c){
            case "!help":
                Window.message("HELP");
                break;
            case "!fcreate":
                Filehandler.createFile(path);
                break;
            case "!mkdir":
                //Filehandler.createDir(path);
                break;
        }
    }
}
