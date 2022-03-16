package com.revature.music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistRepository {
    @Autowired
    private DataSource dataSource;

    public ArtistRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Artist> getAll() {
        List<Artist> artists = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            ResultSet rs = connection.prepareStatement("select * from artist").executeQuery();
            while (rs.next()) {
                artists.add(new Artist(rs.getInt("artist_id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve from db: " + e.getMessage());
        }
        return artists;
    }

    public Artist getArtist(int id) {
        Artist artist = new Artist();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from artist where artist_id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                artist = new Artist(rs.getInt("artist_id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve artist: " + e.getMessage());
        }

        return artist;
    }
}
