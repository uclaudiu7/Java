package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    private Connection conn;

    public ArtistDAO() {
        conn = DatabaseManager.getInstance().getConnection();
    }

    public List<String> getAllArtists() {
        List<String> artists = new ArrayList<String>();
        try {
            String sql = "SELECT name FROM artists";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                artists.add(name);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }

    public void addArtist(String name) {
        try {
            String sql = "INSERT INTO artists (name) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

