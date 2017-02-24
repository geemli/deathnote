package edu.ss.deathnote.option.description;

import edu.ss.deathnote.option.command.AbstractCommand;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandDescription {

    protected String name;
    protected String description;

    protected AbstractCommand command;

    public CommandDescription(String name, String description, AbstractCommand command) {
        this.name = name;
        this.description = description;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
