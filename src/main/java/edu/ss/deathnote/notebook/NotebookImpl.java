package edu.ss.deathnote.notebook;

/**
 * Created by dznor on 23.02.2017.
 */
public class NotebookImpl implements Notebook {
    @Override
    public void create() {
        System.out.println("create");
    }

    @Override
    public void read() {
        System.out.println("read");

    }

    @Override
    public void update() {
        System.out.println("update");

    }

    @Override
    public void delete() {
        System.out.println("delete");

    }
}
