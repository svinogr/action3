package ap.service.serviceImpl;

import ap.entity.ArtistProfile;
import ap.service.ArtistSearchService;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class ArtistSearchServiceImpl implements ArtistSearchService {

    //  private final static String SELECT = "from  ap.entity.ArtistProfile  as artist where name =:name" ;

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<ArtistProfile> search(ArtistProfile artistProfileFrom, ArtistProfile artistProfileTo) {

        if (artistProfileFrom == null) {
            return null;
        }

        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(ArtistProfile.class);

        if (artistProfileTo != null) {
            criteria.add(Restrictions.between("age", artistProfileFrom.getAge(), artistProfileTo.getAge()));
        }
        if (!artistProfileFrom.getName().equals("")) {
            criteria.add(Restrictions.eq("name", artistProfileFrom.getName()));
        }


        List<ArtistProfile> artistProfiles = criteria.list();

        return artistProfiles;
    }
}
