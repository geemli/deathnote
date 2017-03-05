package edu.ss.deathnote.option.description;

import edu.ss.deathnote.option.Option;
import edu.ss.deathnote.option.command.AbstractCommand;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandDescription {

    private String name;
    private String description;
    private Collection<Option> options;
    private AbstractCommand command;

    public CommandDescription(String name, String description, AbstractCommand command, Collection<Option> options) {
        this.name = name;
        this.description = description;
        this.command = command;
        this.options = options;
    }

    public void execute(Map<String, String> args) {
        if(command == null) {
            throw new IllegalStateException("command is null. sorry ;(");
        }

        Class c = command.getClass();

        args.entrySet().forEach(entry -> {
            try {
                Field temp = c.getDeclaredField(entry.getKey());
                temp.setAccessible(true);
                temp.set(command, entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

//            System.out.println(entry.getKey() + entry.getValue());
        });
        command.execute();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AbstractCommand getCommand() {
        return command;
    }

    public Collection<Option> getOptions() {
        return options;
    }
}
