package ap.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artist")
public class ArtistProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "profession")
    private String profession = Profession.ACTOR.name();

    @Column(name = "name")
    private String name;

    @Column(name = "subname")
    private String subname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "age")
    private int age;
    // список ролей в фильмах
    @Column(name = "account_id")
    private int accountId;

    @Transient
    private List<Photo> photoList;

    public ArtistProfile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @Override
    public String toString() {
        return "ArtistProfile{" +
                "id=" + id +
                ", profession='" + profession + '\'' +
                ", name='" + name + '\'' +
                ", subname='" + subname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", accountId=" + accountId +
                ", photoList=" + photoList +
                '}';
    }
}
