package edu.ss.deathnote.option.command;

/**
 * Created by dznor on 23.02.2017.
 */
public class DeleteCommand extends AbstractCommand {

    private String number;

    @Override
    public void execute() {
        System.out.println("DeleteCommand execute()");
    }
}
