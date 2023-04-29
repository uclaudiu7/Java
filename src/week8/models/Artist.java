package org.example.models;

public class Artist {
    private int id;
    private String name;

    public Artist(String name) {
        this.name = name;
    }
    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public int setId(int id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
