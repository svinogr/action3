package ap.entity;


import javax.persistence.*;

@Entity
@Table( name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_account", nullable = false)
    private String userName;

    @Column(name = "role_name", nullable = false)
    private  String roleName;

    public Roles() {
    }

}
