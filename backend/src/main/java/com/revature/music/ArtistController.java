package com.revature.music;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class ArtistController {
    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<Artist> getArtists() {
        return artistService.retrieveAllArtists();
    }

    @GetMapping("/artists/{id}")
    public Artist getArtist(@PathVariable("id") int id) {
        return artistService.retrieveArtist(id);
    }

    @PostMapping("/artists")
    public void postArtist(Artist artist) {
        
    }
}
