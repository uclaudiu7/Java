package org.example;

import java.io.File;
import java.util.HashMap;

public class Document {
    private String name;
    private int id;
    private String path;

    HashMap<String, String> tags;

    public Document() {
        this.tags = new HashMap<String, String>();
    }

    public Document(int id, String name, String path) {
        this.name = name;
        this.id = id;
        this.path = path;
        this.tags = new HashMap<String, String>();
        File file = new File(path);
        try{
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", path='" + path + '\'' +
                ", tags=" + tags +
                '}';
    }

    public void addTag(String key, String value) {
        tags.put(key, value);
    }

    public void removeTag(String key) {
        tags.remove(key);
    }

    public HashMap<String, String> getTags() {
        return tags;
    }

    public void setTags(HashMap<String, String> tags) {
        this.tags = tags;
    }

    public String getTag(String key) {
        return tags.get(key);
    }

    public void printValueByKey(String key) {
        System.out.println(tags.get(key));
    }
}