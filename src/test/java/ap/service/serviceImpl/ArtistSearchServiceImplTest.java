package ap.service.serviceImpl;

import ap.config.WebConfig;
import ap.entity.ArtistProfile;
import ap.entity.Profession;
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

    private ArtistProfile artistProfileFrom;
    private ArtistProfile artistProfileTo;
    private ArtistProfile artistProfile;
    private Profession professionActor = Profession.ACTOR;
    private Profession professionDirector = Profession.DIRECTOR;
    private Profession professionTest = Profession.TEST;

    @Before
    public void setUp() throws Exception {

        artistProfileFrom = new ArtistProfile();
        artistProfileFrom.setName("test");
        artistProfileFrom.setAge(150);
        artistProfileFrom.setPatronymic("testovich");
        artistProfileFrom.setSubname("testov");
        artistProfileFrom.setAccountId(1);
        artistProfileFrom.setProfession(professionActor.name());

        artistProfile = new ArtistProfile();
        artistProfile.setName("test3");
        artistProfile.setAge(100);
        artistProfile.setPatronymic("testovich3");
        artistProfile.setSubname("testov3");
        artistProfile.setAccountId(2);
        artistProfile.setProfession(professionTest.name());

        artistProfileTo = new ArtistProfile();
        artistProfileTo.setName("test2");
        artistProfileTo.setAge(200);
        artistProfileTo.setPatronymic("testovich2");
        artistProfileTo.setSubname("testov2");
        artistProfileTo.setAccountId(2);
        artistProfileTo.setProfession(professionDirector.name());

        artistService.createEntity(artistProfileFrom);
        artistService.createEntity(artistProfileTo);
        artistService.createEntity(artistProfile);
        System.err.println(artistProfileFrom);
        System.err.println(artistProfileTo);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional
    public void search() throws Exception {

        List<ArtistProfile> search = artistSearchService.search(artistProfileFrom, artistProfileTo, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(1, search.size());

    }

    @Test
    @Transactional
    public void searchBetween() throws Exception {
        ArtistProfile artistProfileOne = new ArtistProfile();
        artistProfileOne.setAge(150);

        ArtistProfile artistProfileTwo = new ArtistProfile();
        artistProfileTwo.setAge(300);

        List<ArtistProfile> search = artistSearchService.search(artistProfileOne, artistProfileTwo, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(2, search.size());

    }

    @Test
    @Transactional
    public void searchByProperty() {
        artistProfile = new ArtistProfile();
        artistProfile.setName("test2");
        List<ArtistProfile> search = artistSearchService.search(artistProfile, null, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(search.get(0).getName(), artistProfile.getName());

    }

    @Test
    @Transactional
    public void searchByPropertyTwo() {
        artistProfile = new ArtistProfile();
        //artistProfile.setName("test3");
        artistProfile.setAge(100);
        List<ArtistProfile> search = artistSearchService.search(artistProfile, null, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(search.get(0).getAge(), artistProfile.getAge());

    }

    @Test
    @Transactional
    public void searchByPropertyThree() {
        artistProfile = new ArtistProfile();
        artistProfile.setPatronymic("testovich3");
        List<ArtistProfile> search = artistSearchService.search(artistProfile, null, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(search.get(0).getPatronymic(), artistProfile.getPatronymic());

    }

    @Test
    @Transactional
    public void searchByPropertyFour() {
        artistProfile = new ArtistProfile();
        artistProfile.setSubname("testov");
        List<ArtistProfile> search = artistSearchService.search(artistProfile, null, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(search.get(0).getSubname(), artistProfile.getSubname());

    }

    @Test
    @Transactional
    public void searchByPropertyFive() {
        artistProfile = new ArtistProfile();
        artistProfile.setProfession(professionTest.name());
        List<ArtistProfile> search = artistSearchService.search(artistProfile, null, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(search.get(0).getProfession(), artistProfile.getProfession());
        assertNotEquals(search.get(0).getProfession(), professionDirector);
    }

    @Test
    @Transactional
    public void searchByPropertyAndBetween() {
        artistProfile = new ArtistProfile();
        artistProfile.setName("test");
        artistProfile.setAge(150);

        List<ArtistProfile> search = artistSearchService.search(artistProfile, artistProfileTo, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());

        }
        assertEquals(1, search.size());

    }

    @Test
    @Transactional
    public void searchByPropertyAndBetweenTwo() {
        artistProfile = new ArtistProfile();
        artistProfile.setName(null);
        artistProfile.setAge(0);

        List<ArtistProfile> search = artistSearchService.search(artistProfile, null, 0);
        for (ArtistProfile a : search
                ) {
            System.out.println(a.toString());
        }
        assertEquals(3, search.size());

    }

    @Test
    @Transactional
    public void getCountSearch() {
        artistProfileFrom = new ArtistProfile();
        artistProfileFrom.setAccountId(2);
        int countSearch = artistSearchService.getCountSearch(artistProfileFrom, null);
        System.out.println(countSearch);
        assertEquals(2, countSearch);
    }
}