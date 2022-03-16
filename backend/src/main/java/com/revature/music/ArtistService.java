package com.revature.music;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> retrieveAllArtists() {
        return artistRepository.getAll();
    }

    public Artist retrieveArtist(int id) {
        return artistRepository.getArtist(id);
    }
}
