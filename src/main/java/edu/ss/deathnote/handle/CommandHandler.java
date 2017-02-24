package edu.ss.deathnote.handle;

import edu.ss.deathnote.option.Option;
import edu.ss.deathnote.option.command.*;
import edu.ss.deathnote.option.description.CommandDescription;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandHandler {

//    AbstractCommand command;
    Set<CommandDescription> commands = new HashSet<>();

    public CommandHandler() {
        Set<Option> createOptions = new HashSet<>();
        createOptions.add(new Option("name", true, "user's name"));
        createOptions.add(new Option("number", true, "user's number"));
        createOptions.add(new Option("date", false, "date of created"));
        CommandDescription createCommandDescription = new CommandDescription("add", "add note", new CreateCommand());

        Set<Option> deleteOptions = new HashSet<>();
        deleteOptions.add(new Option("number", true, "user's number"));
        CommandDescription deleteCommandDescription = new CommandDescription("delete", "delete note", new DeleteCommand());

        Set<Option> readOptions = new HashSet<>();
        readOptions.add(new Option("number", true, "number"));
        CommandDescription readCommandDescription = new CommandDescription("read", "read note", new ReadCommand());

        Set<Option> updateOptions = new HashSet<>();
        CommandDescription updateCommandDescription = new CommandDescription("update", "update note", new UpdateCommand());

        Set<Option> sortOptions = new HashSet<>();
        CommandDescription sortCommandDescription = new CommandDescription("sort", "sort note", new SortCommand());

        commands.add(createCommandDescription);
        commands.add(readCommandDescription);
        commands.add(updateCommandDescription);
        commands.add(deleteCommandDescription);
        commands.add(sortCommandDescription);
    }

    public void handle(String[] args) {
        for (String arg : args) {
            for(CommandDescription cd : commands) {
                if(arg.equals(cd.getName())) {
                    cd.execute();
                }
            }
            System.out.println(arg);
        }
    }
}
