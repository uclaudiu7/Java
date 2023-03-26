package org.example.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {
    private String path;
    Catalog catalog;

    public SaveCommand(String path, Catalog catalog){
        this.path = path;
        this.catalog = catalog;
    }
    @Override
    public void execute(){

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
