package com.javaquarium.beans.data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by quentin on 20/02/2017.
 */

@Entity
@Table(name="t_user_roles")
public class UtilisateurRoleDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<UtilisateurDO> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UtilisateurDO> getUsers() {
        return users;
    }

    public void setUsers(Set<UtilisateurDO> users) {
        this.users = users;
    }
}
