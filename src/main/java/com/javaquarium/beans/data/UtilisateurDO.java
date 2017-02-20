package com.javaquarium.beans.data;

import javax.persistence.*;

/**
 * Created by quentin on 20/02/2017.
 */
@Entity
@Table(name="t_utilisateur")
public class UtilisateurDO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="c_id")
    private int id;
    @Column(name="c_login", nullable=false)
    private String login;
    @Column(name="c_password", nullable=false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
