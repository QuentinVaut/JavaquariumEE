package com.javaquarium.beans.data;

import javax.persistence.*;

/**
 * Created by quentin on 20/02/2017.
 */
@Entity
@Table(name="t_aquarium")
public class AquariumDO {

    private Integer id;

    private PoissonDO poisson;

    private Integer count;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the poisson
     */
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "poisson")
    public PoissonDO getPoisson() {
        return poisson;
    }

    /**
     * @param poisson
     *            the poisson to set
     */
    public void setPoisson(PoissonDO poisson) {
        this.poisson = poisson;
    }

    /**
     * @return the count
     */
    @Column(name = "c_count")
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }



}
