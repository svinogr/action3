package ap.service.serviceImpl;

import ap.config.WebConfig;
import ap.entity.ArtistProfile;
import ap.service.ArtistSearchService;
import ap.service.ArtistService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class ArtistSearchServiceImplTest {

    @Autowired
    ArtistSearchService artistSearchService;
    @Autowired
    ArtistService artistService;

    ArtistProfile artistProfileFrom;
    ArtistProfile artistProfileTo;
    ArtistProfile artistProfile;

    @Before
    public void setUp() throws Exception {
        artistProfileFrom = new ArtistProfile();
        artistProfileFrom.setName("test");
        artistProfileFrom.setAge(150);
        artistProfileFrom.setPatronymic("testovich");
        artistProfileFrom.setSubname("testov");
        artistProfileFrom.setAccountId(1);

        artistProfile = new ArtistProfile();
        artistProfile.setName("test3");
        artistProfile.setAge(100);
        artistProfile.setPatronymic("testovich3");
        artistProfile.setSubname("testov3");
        artistProfile.setAccountId(2);

        artistProfileTo = new ArtistProfile();
        artistProfileTo.setName("test2");
        artistProfileTo.setAge(200);
        artistProfileTo.setPatronymic("testovich2");
        artistProfileTo.setSubname("testov2");
        artistProfileTo.setAccountId(2);

        artistService.createEntity(artistProfileFrom);
        artistService.createEntity(artistProfileTo);
        artistService.createEntity(artistProfile);


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional
    public void search() throws Exception {

        List<ArtistProfile> search = artistSearchService.search(artistProfileFrom, artistProfileTo);
        assertEquals(2, search.size());

    }

    @Test
    @Transactional
    public void searchByProperty() {
        List<ArtistProfile> search = artistSearchService.search(artistProfile, null);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(1, search.size());


    }

}