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

    AbstractCommand command;
    Set<CommandDescription> commands = new HashSet<>();

    public CommandHandler() {
        Set<Option> createOptions = new HashSet<>();
        createOptions.add(new Option("name", true, "user's name"));
        createOptions.add(new Option("number", true, "user's number"));
        createOptions.add(new Option("date", false, "date of created"));
        CommandDescription createCommandDescription = new CommandDescription("create", "add note", new CreateCommand(), createOptions);

        Set<Option> readOptions = new HashSet<>();
        readOptions.add(new Option("number", true, "number"));
        CommandDescription readCommandDescription = new CommandDescription("read", "read note", new ReadCommand(), readOptions);

        Set<Option> updateOptions = new HashSet<>();
        updateOptions.add(new Option("number", true, "user's number"));
        updateOptions.add(new Option("name", true, "user's name"));
        updateOptions.add(new Option("date", false, "date of created"));
        CommandDescription updateCommandDescription = new CommandDescription("update", "update note", new UpdateCommand(), updateOptions);

        Set<Option> deleteOptions = new HashSet<>();
        deleteOptions.add(new Option("number", true, "user's number"));
        CommandDescription deleteCommandDescription = new CommandDescription("delete", "delete note", new DeleteCommand(), deleteOptions);

        Set<Option> sortOptions = new HashSet<>();
        CommandDescription sortCommandDescription = new CommandDescription("sort", "sort note", new SortCommand(), sortOptions);

//        Class c = AbstractCommand.class;
//        Class[] interfaces = c.getInterfaces();
//        for (Class cInterface : interfaces) {
//            System.out.println(cInterface.getName());
//        }

        commands.add(createCommandDescription);
        commands.add(readCommandDescription);
        commands.add(updateCommandDescription);
        commands.add(deleteCommandDescription);
        commands.add(sortCommandDescription);
    }

    public void handle(String[] args) throws NoSuchFieldException, IllegalAccessException {
        for (String arg : args) {
            for (CommandDescription cd : commands) {
                if (arg.equals(cd.getName())) {
                    //рефлекщен добавить поля
                    Class c = cd.getCommand().getClass();
                    for (String arg2 : args) {
                        if (Pattern.matches("--\\w+=\\w+", arg2)) {
                            String prefix = "--";
                            String equals = "=";

                            String expressionWithOutPrefix = arg2.substring(arg2.indexOf(prefix) + prefix.length());

                            String argument = expressionWithOutPrefix.split("=")[0];
                            String value = expressionWithOutPrefix.split("=")[1];
                            System.out.println("**********" + argument + "   " + value);
                            Field field = c.getDeclaredField(argument);
                            field.setAccessible(true);
                            field.set(cd.getCommand(), value);
                            System.out.println("set " + field.getName() + "=" + field.get(cd.getCommand()));

//                            реестр: рефлекшеном по интерфейсу или класс
//                            фабрику команд сделать. с методом() createcommand factory. патерн команда.
//                      СДЕЛАТЬ ВАЛИДАТОР+СОЗДАТЕЛЬ MAP<>. НА ВХОДЕ КОММАНД ДИСКРИПШН И КОЛЛЕКЦИЯ ОПШИНСОВ. ВЫБРАТЬ ОБЩЕЕ

                        }
                    }
                    cd.getCommand().execute();
//                    Field[] publicFields = c.getDeclaredFields();
//                    for (Field field : publicFields) {
//                        Class fieldType = field.getType();
//                        System.out.println("Имя: " + field.getName());
//                        System.out.println("Тип: " + fieldType.getName());
//                    }
                }
            }
            System.out.println(arg);
        }
    }
}
