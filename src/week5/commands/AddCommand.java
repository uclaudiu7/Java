package org.example.commands;

import org.example.Catalog;
import org.example.Document;

public class AddCommand extends Command {
    private Catalog catalog;
    private Document document;
    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }
    @Override
    public void execute(){
        catalog.getDocuments().add(document);
    }

}
