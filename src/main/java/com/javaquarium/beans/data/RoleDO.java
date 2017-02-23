package com.javaquarium.beans.data;

import javax.persistence.*;

/**
 * Created by quentin on 21/02/2017.
 */
@Entity
@Table(name = "role")
public class RoleDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}