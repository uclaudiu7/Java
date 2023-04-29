package org.example.DAOs;

import org.example.models.Artist;
import org.example.database.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    public void addArtist(Artist artist) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "INSERT INTO artists(name) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, artist.getName());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating artist failed, no rows affected.");
            }

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    int id = rs.getInt(1);
                    artist.setId(id);
                    System.out.println("Artist id: " + id);
                } else {
                    throw new SQLException("Creating album failed, no ID obtained.");
                }
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Artist getArtistByName(String name){
        Artist artist = null;
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT * FROM artists WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                artist = new Artist(id, name);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    public Artist getArtistById(int id) {
        Artist artist = null;
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT * FROM artists WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                artist = new Artist(id, name);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "SELECT id, name FROM artists";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                artists.add(new Artist(Integer.parseInt(id), name));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }

    public void deleteArtist(Artist artist) {
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "DELETE FROM artists WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, artist.getName());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting artist failed, no rows affected.");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllArtists(){
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "DELETE FROM artists";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

