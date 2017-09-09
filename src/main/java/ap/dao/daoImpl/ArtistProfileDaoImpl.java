package ap.dao.daoImpl;

import ap.dao.ArtistProfileDao;
import ap.entity.ArtistProfile;
import org.springframework.stereotype.Component;

@Component
public class ArtistProfileDaoImpl extends BasicDaoImpl<ArtistProfile> implements ArtistProfileDao {
    public ArtistProfileDaoImpl() {
        super(ArtistProfile.class);
    }
}
