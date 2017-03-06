package edu.ss.deathnote.option.command;

import edu.ss.deathnote.option.Option;

import java.util.Collection;

/**
 * Created by dznor on 23.02.2017.
 */
public abstract class AbstractCommand implements Command {

    protected Collection<Option> globalOptions;

    @Override
    abstract public void execute();

    public Collection<Option> getOptions() {
        return globalOptions;
    }

    public void setOptions(Collection<Option> options) {
        this.globalOptions = options;
    }
}
