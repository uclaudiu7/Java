package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Manager {
    private Catalog catalog;

    public Manager(Catalog catalog) {
        this.catalog = catalog;
    }

    public void add(Document document) {
        catalog.add(document);
    }

    public void remove(Document document) {
        catalog.remove(document);
    }

    public void list() {
        for (Document document : catalog.getDocuments()) {
            System.out.println(document);
        }
    }

    public void SaveCatalog(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public void LoadCatalog(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        catalog = objectMapper.readValue(new File(path), Catalog.class);
    }

}