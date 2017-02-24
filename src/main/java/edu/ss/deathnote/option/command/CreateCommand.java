package edu.ss.deathnote.option.command;

public class CreateCommand extends AbstractCommand {

    private String name;
    private String number;
    private String file;

    @Override
    public void execute() {
        if (file.isEmpty()) {
            file = "1.txt";
        }
        System.out.println("CreateCommand execute()");
    }
}
