package org.example.commands;

import org.example.Catalog;

public class ListCommand extends Command {
    private Catalog catalog;
    public ListCommand(Catalog catalog){
        this.catalog = catalog;
    }
    @Override
    public void execute() {
        catalog.getDocuments().forEach(System.out::println);
    }
}
