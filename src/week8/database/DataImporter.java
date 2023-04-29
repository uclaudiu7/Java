package org.example.database;

import org.example.DAOs.AlbumDAO;
import org.example.DAOs.AlbumGenreDAO;
import org.example.DAOs.ArtistDAO;
import org.example.DAOs.GenreDAO;
import org.example.models.Album;
import org.example.models.Artist;
import org.example.models.Genre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataImporter {
    private static final String CSV_FILE_PATH = "D:\\faculta\\ProgrAvansata\\week8\\src\\main\\java\\org\\example\\resources\\albumlist.csv";

    public void importData() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String otherThanQuote = " [^\"] ";
                String quotedString = String.format(" \" %s* \" ", otherThanQuote);
                String regex = String.format("(?x) "+ // enable comments, ignore white spaces
                                ",                         "+ // match a comma
                                "(?=                       "+ // start positive look ahead
                                "  (?:                     "+ //   start non-capturing group 1
                                "    %s*                   "+ //     match 'otherThanQuote' zero or more times
                                "    %s                    "+ //     match 'quotedString'
                                "  )*                      "+ //   end group 1 and repeat it zero or more times
                                "  %s*                     "+ //   match 'otherThanQuote'
                                "  $                       "+ // match the end of the string
                                ")                         ", // stop positive look ahead
                        otherThanQuote, quotedString, otherThanQuote);

                String[] values = line.split(regex, -1);
                int releaseYear = Integer.parseInt(values[1]);
                String albumTitle = values[2];
                String artistName = values[3];

                GenreDAO genreDAO = new GenreDAO();
                List<Genre> genres = new ArrayList<>();
                String[] genresString = values[4].split(",");
                Genre genre;
                for (String genreString : genresString) {
                    genreString = genreString.replace("\"", "");
                    if(genreDAO.getGenreByName(genreString) == null)
                        genre = new Genre(genreString);
                    else {
                        genre = genreDAO.getGenreByName(genreString);
                    }
                    genres.add(genre);
                }
                String[] subgenresString = values[5].split(",");
                for (String subgenreString : subgenresString) {
                    subgenreString = subgenreString.replace("\"", "");
                    if(genreDAO.getGenreByName(subgenreString) == null)
                        genre = new Genre(subgenreString);
                    else {
                        genre = genreDAO.getGenreByName(subgenreString);
                    }
                    genres.add(genre);
                }

                ArtistDAO artistDAO = new ArtistDAO();
                Artist artist;
                if(artistDAO.getArtistByName(artistName) == null)
                    artist = new Artist(artistName);
                else
                    artist = artistDAO.getArtistByName(artistName);
                artistDAO.addArtist(artist);

                Album album = new Album(releaseYear, albumTitle, artist, genres);
                AlbumDAO albumDAO = new AlbumDAO();
                albumDAO.addAlbum(album);

                for (Genre g : genres) {
                    genreDAO.addGenre(g);
                }

                AlbumGenreDAO albumGenreDAO = new AlbumGenreDAO();
                for (Genre g : genres) {
                    albumGenreDAO.addAlbumGenre(album.getId(), g.getId());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllData(){
        try(Connection conn = ConnectionPool.getConnection()) {
            String sql = "DELETE FROM album_genres";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "DELETE FROM albums";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "DELETE FROM artists";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "DELETE FROM genres";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "ALTER TABLE albums AUTO_INCREMENT = 0";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "ALTER TABLE artists AUTO_INCREMENT = 0";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "ALTER TABLE genres AUTO_INCREMENT = 0";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            sql = "ALTER TABLE album_genres AUTO_INCREMENT = 0";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
