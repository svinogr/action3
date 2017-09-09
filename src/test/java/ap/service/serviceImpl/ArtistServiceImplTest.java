package ap.service.serviceImpl;

import ap.config.WebConfig;
import ap.entity.ArtistProfile;
import ap.service.AccountService;
import ap.service.ArtistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class ArtistServiceImplTest {

    @Autowired
    ArtistService artistService;
    private ArtistProfile artistProfile;

    @Before
    public void setUp() throws Exception {
        artistProfile = new ArtistProfile();
        artistProfile.setName("test");
        artistProfile.setAge(30);
        artistProfile.setPatronymic("testovich");
        artistProfile.setSubname("testov");
    }

    @Test
    @Transactional
    public void createEntity() throws Exception {
        artistService.createEntity(artistProfile);
        assertNotEquals(0, artistProfile.getId());
    }

}