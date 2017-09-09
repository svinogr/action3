package ap.service.serviceImpl;

import ap.dao.ArtistProfileDao;
import ap.entity.ArtistProfile;
import ap.service.ArtistService;

public class ArtistServiceImpl extends BasicServiceImpl<ArtistProfile> implements ArtistService {

    public ArtistServiceImpl(ArtistProfileDao dao) {
        super(ArtistProfile.class);
        this.dao = dao;
    }

}
