package com.javaquarium.beans.data;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by quentin on 20/02/2017.
 */
@Entity
@Component
@Table(name="t_utilisateur")
public class UtilisateurDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UtilisateurRoleDO> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UtilisateurRoleDO> getRoles() {
        return roles;
    }

    public void setRoles(Set<UtilisateurRoleDO> roles) {
        this.roles = roles;
    }
}