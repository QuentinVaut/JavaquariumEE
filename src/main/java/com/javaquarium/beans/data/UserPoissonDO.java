package com.javaquarium.beans.data;

import javax.persistence.*;

/**
 * Created by quentin on 21/02/2017.
 */

@Entity
@Table(name = "t_aquarium")
public class UserPoissonDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
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
