package edu.ss.deathnote.option.command;

import edu.ss.deathnote.option.description.CommandDescription;

/**
 * Created by dznor on 23.02.2017.
 */
public class CreateCommand extends AbstractCommand {

    private String name;
    private String number;
    private CommandDescription commandDescription;

    @Override
    public void execute() {
        System.out.println("CreateCommand execute()");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CommandDescription getCommandDescription() {
        return commandDescription;
    }
}
