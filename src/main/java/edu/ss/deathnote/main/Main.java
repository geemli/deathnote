package edu.ss.deathnote.main;

import edu.ss.deathnote.handle.CommandHandler;
import edu.ss.deathnote.option.Option;
import edu.ss.deathnote.option.description.CommandDescription;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dznor on 23.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        args = new String[]{"--arg=a", "add", "--name=dima", "--number=666"};
        if (args.length > 0) {
            CommandHandler handler = new CommandHandler();
            handler.handle(args);
        } else {
            throw new IllegalArgumentException("no parameters");
        }
    }

}
