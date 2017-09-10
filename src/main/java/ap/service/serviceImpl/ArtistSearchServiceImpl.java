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
        System.err.println(artistProfileFrom);
        System.err.println(artistProfileTo);

        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(ArtistProfile.class);

        if (artistProfileTo != null) {
            criteria.add(Restrictions.
                    between("age",
                            artistProfileFrom.getAge(),
                            artistProfileTo.getAge()));
        }
        if (artistProfileFrom.getName() != null) {
            criteria.add(Restrictions.eq("name", artistProfileFrom.getName()));
        }
        if (artistProfileFrom.getPatronymic() != null) {
            criteria.add(Restrictions.eq("patronymic", artistProfileFrom.getPatronymic()));
        }
        if (artistProfileFrom.getSubname() != null) {
            criteria.add(Restrictions.eq("subname", artistProfileFrom.getSubname()));
        }
        if (artistProfileFrom.getProfession() != null) {
            criteria.add(Restrictions.eq("profession", artistProfileFrom.getProfession()));
        }
        if (artistProfileFrom.getAge() > 0 && artistProfileTo == null) {
            criteria.add(Restrictions.eq("age", artistProfileFrom.getAge()));
        }

        List<ArtistProfile> artistProfiles = criteria.list();

        return artistProfiles;
    }
}
