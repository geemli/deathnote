package edu.ss.deathnote.handle;

import edu.ss.deathnote.option.Option;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by dznor on 28.02.2017.
 */
public class ValidatorAndCreator {

    public Map<String, String> doIt(Collection<Option> options, Collection<String> argv) {
//        Set<Option> optionSet = new HashSet<>(options);
        Map<String, String> result = new HashMap<>();

        boolean valid;//check everyone arg from argv
        String a;//parsed name argument
        String value;//parsed value of argument

        for (String arg : argv) {
            valid = false;
            if (Pattern.matches("--//w+=//w+", arg)) {
                String[] temp = arg.split("=");
                if (temp.length > 2) {
                    throw new IllegalStateException("=.=");
                }

                a = temp[0];
                value = temp[1];

                for (Option option : options) {
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
            return null;
        }
    }
}
