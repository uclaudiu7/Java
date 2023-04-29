package org.example.DAOs;

import org.example.database.ConnectionPool;
import org.example.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    public void addAlbum(Album album) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "INSERT INTO albums(release_year, title, artist_id) VALUES(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, album.getReleaseYear());
            stmt.setString(2, album.getTitle());
            stmt.setInt(3, album.getArtist().getId());
            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    int id = rs.getInt(1);
                    album.setId(id);
                    System.out.println("Album id: " + id);
                } else {
                    throw new SQLException("Creating album failed, no ID obtained.");
                }
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Album getAlbumById(int id) {
        Album album = null;
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT * FROM albums WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                int artistId = rs.getInt("artist_id");
                Artist artist = new ArtistDAO().getArtistById(artistId);
                List<Genre> genres = new ArrayList<>();
                String sql2 = "SELECT * FROM album_genre WHERE album_id = ?";
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                stmt2.setInt(1, id);
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    int genreId = rs2.getInt("genre_id");
                    Genre genre = new GenreDAO().getGenreById(genreId);
                    genres.add(genre);
                }
                album = new Album(releaseYear, title, artist, genres);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT * FROM albums";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                Album album = getAlbumById(id);
                albums.add(album);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    public void deleteAlbum(Album album) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "DELETE FROM albums WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, album.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting album failed, no rows affected.");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
