package edu.ss.deathnote.option.description;

import edu.ss.deathnote.option.Option;

import java.util.Set;

/**
 * Created by dznor on 23.02.2017.
 */
public class CommandDescription {

    protected String name;
    protected String description;
    protected String setter;

    protected Set<Option> set;

    public CommandDescription(String name, String description, String setter, Set<Option> set) {
        this.name = name;
        this.description = description;
        this.setter = setter;
        this.set = set;
    }

    public void setSet(Set<Option> set) {
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public Set<Option> getSet() {
        return set;
    }
}
