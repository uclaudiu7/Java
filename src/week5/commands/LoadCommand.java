package org.example.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command{
    private static Catalog catalog;
    private String path;
    public LoadCommand(Catalog catalog, String path){
        this.catalog = catalog;
        this.path = path;
    }
    @Override
    public void execute() {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Catalog load(){
        return catalog;
    }

}
