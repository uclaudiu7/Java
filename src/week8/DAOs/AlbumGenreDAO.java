package org.example.DAOs;

import org.example.database.ConnectionPool;
import org.example.models.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumGenreDAO {
    public void addAlbumGenre(int albumId, int genreId) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, albumId);
            stmt.setInt(2, genreId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting album_genres failed, no rows affected.");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Genre> getGenresByAlbumId(int albumId) {
        List<Genre> genres = new ArrayList<>();
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT g.id, g.name FROM genres g INNER JOIN album_genres ag ON g.id = ag.genre_id WHERE ag.album_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, albumId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    public void removeAlbumGenre(int albumId, int genreId) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "DELETE FROM album_genres WHERE album_id = ? AND genre_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, albumId);
            stmt.setInt(2, genreId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting album_genres failed, no rows affected.");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
