package org.example;

import java.io.IOException;

public class Compulsory {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("My Catalog");
        Document firstDocument = new Document(0,"First Document","C:/Users/urses/Desktop/firstDocument.txt");
        Document secondDocument = new Document(1,"Second Document","C:/Users/urses/Desktop/secondDocument.txt");

        firstDocument.addTag("author", "Marcel");
        firstDocument.addTag("type", "text");


        secondDocument.addTag("author", "John");
        secondDocument.addTag("type", "text");

        firstDocument.printValueByKey("author");
        Manager catalogManager = new Manager(catalog);

        catalogManager.add(firstDocument);
        catalogManager.add(secondDocument);

        firstDocument.getTag("author");
        secondDocument.getTag("author");

        catalogManager.list();

        catalogManager.SaveCatalog("C:/Users/urses/Desktop/catalog.json");

    }
}