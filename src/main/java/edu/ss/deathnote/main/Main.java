package edu.ss.deathnote.main;

import edu.ss.deathnote.handle.CommandHandler;
import edu.ss.deathnote.option.Option;
import edu.ss.deathnote.option.description.CommandDescription;

import java.util.*;

/**
 * Created by dznor on 23.02.2017.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        args = new String[]{ "create", "--name=dima", "--number=666"};
        Collection<String> arguments = new ArrayList<>(Arrays.asList(args));
        if (args.length > 0) {
            CommandHandler handler = new CommandHandler();
            handler.handle(arguments);
        } else {
            throw new IllegalArgumentException("no parameters");
        }
    }

}