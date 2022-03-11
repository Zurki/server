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
                case "!fc":
                    return COMMAND;
                case "!filecreate":
                    return COMMAND;

                case "!mkdir":
                    return COMMAND;
                case "!makedirectory":
                    return COMMAND;

                case "!ls":
                    return COMMAND;
                case "!list":
                    return COMMAND;

                case "!curr":
                    return COMMAND;

                case "!back":
                    return BACK;
                case "..":
                    return BACK;

                case "~":
                    return RESTORE;

                case "!exit":
                    return EXIT;
                case "!q":
                    return EXIT;
            }
        }
    }


    public static void read(String c, String path) throws IOException{
        switch(c){
            case "!help":
                Window.help("ALL COMMANDS: ");
                Window.help("!help - See all commands available to you");
                Window.help("!curr - see current file you are in");
                Window.help("!filecreate, !fcreate, !fc - Create a file");
                Window.help("!makedirectory, !mkdir, Create a directory");
                Window.help("!back, '..' - Go back to previous directory");
                Window.help("'~' - Restore to base directory");
                Window.help("!exit, !q - Quit the application");
                break;

            case "!ls":
            case "!list":
                Window.printAllFilesInDir(path, Filehandler.readAllFilesFromPath(path));
                break;

            case "!curr":
                Window.message("current folder: " + path);
                break;

            case "!fc":
            case "!filecreate":
            case "!fcreate":
                Filehandler.createFile(path);
                break;

            case "!makedirectory":
            case "!mkdir":
                Filehandler.createDir(path);
                break;
        }
    }
}
