package com.revature.music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistRepository {
    // @Autowired
    // private DataSource dataSource;

    // public ArtistRepository(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }

    public List<Artist> getAll() {
        List<Artist> artists = new ArrayList<>();
            try {
                Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://db:5432/postgres", "postgres", "postgres");
                ResultSet rs = connection.prepareStatement("select * from artist").executeQuery();
                while (rs.next()) {
                    artists.add(new Artist(rs.getInt("artist_id"), rs.getString("name")));
                }
            } catch (SQLException e) {
                System.err.println("Failed to retrieve from db: " + e.getMessage());
                e.printStackTrace();
            }
        return artists;
    }
}
