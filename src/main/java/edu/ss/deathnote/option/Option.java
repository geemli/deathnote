package edu.ss.deathnote.option;

/**
 * Created by dznor on 23.02.2017.
 */
public class Option {
    String arg;
    boolean required;
    String description;
//    String setterMethod;

    public Option(String arg, boolean required, String description) {
        this.arg = arg;
        this.required = required;
        this.description = description;
    }
}
