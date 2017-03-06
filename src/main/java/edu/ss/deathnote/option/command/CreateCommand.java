package edu.ss.deathnote.option.command;

import java.io.*;

public class CreateCommand extends AbstractCommand {

    private String name;
    private String number;
    private String file;
    private String charset;

    @Override
    public void execute() {
        if (file == null || file.isEmpty()) {
            file = "1.txt";
        }

        if (charset == null || charset.isEmpty()) {
            charset = "UTF-8";
        }

        System.out.println("CreateCommand execute() with param: name = " + name + " and number = " + number);
//        System.out.println(file + "   " + charset);

        try {
            FileOutputStream fos = new FileOutputStream(new File(file));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeChars(name);
            oos.writeChars(number);

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
