package org.example;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;

    List<Document> documents;

    public Catalog() {
        documents = new ArrayList<Document>();
    }

    public Catalog(String name) {
        this.name = name;
        documents = new ArrayList<Document>();
    }

    public void add(Document document) {
        documents.add(document);
    }

    public void remove(Document document) {
        documents.remove(document);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public Document getDocumentById(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document;
            }
        }
        return null;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String toString() {
        return "Catalog: " + name + " (" + documents.size() + " documents)";
    }

}