package ap.service;

import ap.entity.ArtistProfile;

import java.util.List;

public interface ArtistSearchService {
    List<ArtistProfile> search(ArtistProfile artistProfileFrom, ArtistProfile artistProfileTo);
}
