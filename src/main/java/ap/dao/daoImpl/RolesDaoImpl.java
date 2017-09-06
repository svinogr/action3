package ap.dao.daoImpl;

import ap.dao.RolesDao;
import ap.entity.Roles;
import org.springframework.stereotype.Component;

@Component
public class RolesDaoImpl extends BasicDaoImpl<Roles> implements RolesDao {
    public RolesDaoImpl() {
        super(Roles.class);
    }
}
