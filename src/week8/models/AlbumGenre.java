package org.example.models;

public class AlbumGenre {
    private int albumId;
    private int genreId;

    public AlbumGenre(int albumId, int genreId) {
        this.albumId = albumId;
        this.genreId = genreId;
    }

    public int getAlbumId() {
        return albumId;
    }
    public int getGenreId() {
        return genreId;
    }
}
