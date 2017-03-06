package edu.ss.deathnote.handle;

import edu.ss.deathnote.option.Option;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by dznor on 28.02.2017.
 */
public class ValidatorAndCreator {

    public Map<String, String> createCommandArgsMap(Collection<Option> options, Collection<String> argv) {
        Map<String, String> result = new HashMap<>();

        boolean valid;//check everyone arg from argv
        String a;//parsed name argument
        String value;//parsed value of argument

        for (String arg : argv) {
            valid = false;
            if (Pattern.matches("--\\w+=\\w+", arg)) {
                String[] temp = arg.split("=");
                if (temp.length != 2) {
                    throw new IllegalStateException("=.=");
                }

                a = temp[0].substring(2);
                value = temp[1];

                for (Option option : options) {
                    System.out.println(options.size() + option.getArg() + "________" + a + "=" + value);
                    if (a.equals(option.getArg())) {
                        valid = true;
                        options.remove(option);
                        break;
                    }
                }

                if (valid) {
                    result.put(a, value);
                } else {
                    throw new IllegalArgumentException("option " + a + " hasn't any arguments");
                }
            } else {
                throw new IllegalArgumentException("pattern doesn't matches");
            }
        }

        if(!checkRequiredParams(options)) {
            throw new IllegalArgumentException("fill all required params");
        }
        return result;
    }

    private boolean checkRequiredParams(Collection<Option> options) {
        if (options.isEmpty()) return true;
        boolean b = true;
        for (Option option : options) {
            if(option.isRequired()) {
                return false;
            }
        }
        return b;
    }

}
