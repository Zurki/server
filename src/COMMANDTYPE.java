package com.build;

public class COMMANDTYPE{
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
}
