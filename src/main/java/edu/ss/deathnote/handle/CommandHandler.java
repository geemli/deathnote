package edu.ss.deathnote.handle;

import edu.ss.deathnote.option.Option;
import edu.ss.deathnote.option.command.AbstractCommand;
import edu.ss.deathnote.option.command.CreateCommand;
import edu.ss.deathnote.option.command.DeleteCommand;
import edu.ss.deathnote.option.description.CommandDescription;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandHandler {

    AbstractCommand command;

    Set<Option> createOptions;
    Set<Option> readOptions;
    Set<Option> updateOptions;
    Set<Option> deleteOptions;
    Set<Option> sortOptions;

    CommandDescription createCommandDescription;
    CommandDescription readCommandDescription;
    CommandDescription updateCommandDescription;
    CommandDescription deleteCommandDescription;
    CommandDescription sortCommandDescription;

    public CommandHandler() {
        createOptions = new HashSet<>();createOptions.add(new Option("name", true, "user's name"));createOptions.add(new Option("number", true, "user's number"));createOptions.add(new Option("date", false, "date of created"));
        createCommandDescription = new CommandDescription("add", "add note", "add", createOptions);

        deleteOptions = new HashSet<>();deleteOptions.add(new Option("number", true, "user's number"));
        deleteCommandDescription = new CommandDescription("delete", "delete note", "delete", deleteOptions);
    }

    public void handle(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
            if (Pattern.matches("\\w+", arg)) {
                if (arg.equals(createCommandDescription.getName())) {
                    command = new CreateCommand();
                    System.out.println("CreateCommand");
                    command.execute();

                } else if (arg.equals(deleteCommandDescription.getName())) {
                    command = new DeleteCommand();
                } else {
                    throw new IllegalArgumentException("no such command");
                }
            } else {
//                throw new IllegalArgumentException("no command with this pattern");
            }
        }
    }
}
