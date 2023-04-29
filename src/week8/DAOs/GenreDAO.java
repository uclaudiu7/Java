package org.example.DAOs;

import org.example.database.ConnectionPool;
import org.example.models.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    public void addGenre(Genre genre) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "INSERT INTO genres (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, genre.getName());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting genre failed, no rows affected.");
            }
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                genre.setId(id);
            } else {
                throw new SQLException("Inserting genre failed, no ID obtained.");
            }
            generatedKeys.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Genre getGenreByName(String name){
        Genre genre = null;
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT id FROM genres WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                genre = new Genre(id, name);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    public Genre getGenreById(int id) {
        Genre genre = null;
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT name FROM genres WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                genre = new Genre(id, name);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT id, name FROM genres";
            PreparedStatement stmt = conn.prepareStatement(sql);
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

    public void deleteGenre(Genre genre) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "DELETE FROM genres WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, genre.getId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting genre failed, no rows affected.");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
