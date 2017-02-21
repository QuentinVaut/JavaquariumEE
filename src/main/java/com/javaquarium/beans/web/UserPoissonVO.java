package com.javaquarium.beans.web;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by quentin on 21/02/2017.
 */


public class UserPoissonVO {
    private Integer id;
    private User user;
    private PoissonDO poissonDO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PoissonDO getPoissonDO() {
        return poissonDO;
    }

    public void setPoissonDO(PoissonDO poissonDO) {
        this.poissonDO = poissonDO;
    }
}
