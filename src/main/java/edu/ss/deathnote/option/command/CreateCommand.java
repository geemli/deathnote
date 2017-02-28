package edu.ss.deathnote.option.command;

public class CreateCommand extends AbstractCommand {

    private String name;
    private String number;
    private String file;
    private String charset;

    @Override
    public void execute() {
        if (file != null && file.isEmpty()) {
            file = "1.txt";
        }

        if (charset != null && charset.isEmpty()) {
            charset = "UTF-8";
        }

        System.out.println("CreateCommand execute() with param: name = " + name + " and number = " + number);
        System.out.println(file + "   " + charset);
    }
}
