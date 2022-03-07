package com.build;

public class COMMANDTYPE{
    public enum VALUE{
        COMMAND("COMMAND"),
        PATH("PATH"),
        EXIT("EXIT"),
        RESTORE("RESTORE");


        VALUE(){}

        static VALUE getType(String type){
            switch(type){
                default:
                    return PATH;

                case "!help":
                    return COMMAND;
                case "!back":
                    return COMMAND;

                case "~":
                    return RESTORE;

                case "!exit":
                    return EXIT;
            }
        }
    }
}
