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
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private UserDO user;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private PoissonDO poissonDO;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user
     */
    public UserDO getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(UserDO user) {
        this.user = user;
    }

    /**
     * @return poissonDO
     */
    public PoissonDO getPoissonDO() {
        return poissonDO;
    }

    /**
     * @param poissonDO
     */
    public void setPoissonDO(PoissonDO poissonDO) {
        this.poissonDO = poissonDO;
    }
}
