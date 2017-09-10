package ap.service.serviceImpl;

import ap.config.WebConfig;
import ap.entity.ArtistProfile;
import ap.entity.Profession;
import ap.service.ArtistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    @Transactional
    public void deleteEntity() throws Exception {
        boolean flag = artistService.delete(artistProfile);
        assertEquals(true, flag);
    }

    @Test
    @Transactional
    public void updateEntity() throws Exception {
        createEntity();
        String oldName = artistProfile.getName();
        int oldAge = artistProfile.getAge();
        String oldPatronymic = artistProfile.getPatronymic();
        String oldSubname = artistProfile.getSubname();
        String oldProfession = artistProfile.getProfession();

        Profession profession = Profession.DIRECTOR;

        artistProfile.setName("newTest");
        artistProfile.setAge(31);
        artistProfile.setSubname("newTestov");
        artistProfile.setPatronymic("newTestovich");
        artistProfile.setProfession(profession.name());
        artistProfile = artistService.update(artistProfile);

        assertNotEquals(oldName, artistProfile.getName());
        System.out.println(oldName + " " + artistProfile.getName());
        assertNotEquals(oldAge, artistProfile.getAge());
        assertNotEquals(oldSubname, artistProfile.getSubname());
        assertNotEquals(oldPatronymic, artistProfile.getPatronymic());
        assertNotEquals(oldProfession, artistProfile.getProfession());
    }

    @Test
    @Transactional
    public void getEntity() throws Exception {
        createEntity();
        ArtistProfile newArtistProfile = artistService.getEntity(artistProfile.getId());
        assertEquals(artistProfile.getId(), newArtistProfile.getId());
    }




}