package org.example.commands;

import org.example.Catalog;
import org.example.Document;
import org.example.exceptions.CommandException;
import org.example.exceptions.FileOpenException;
import org.example.exceptions.NullDocumentException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command {
    private Catalog catalog;
    private Document document;
    public ViewCommand(Catalog catalog, Document document){
        this.catalog = catalog;
        this.document = document;
    }
    @Override
    public void execute() throws CommandException, FileOpenException {
        if(document == null)
            throw new NullDocumentException();
        if(Desktop.isDesktopSupported()){
            File file = new File(document.getPath());
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                throw new FileOpenException();
            }
        }
    }

}
