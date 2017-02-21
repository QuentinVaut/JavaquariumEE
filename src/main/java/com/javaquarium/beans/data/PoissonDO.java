package com.javaquarium.beans.data;

import javax.persistence.*;

/**
 * Created by quentin on 16/02/2017.
 */
@Entity
@Table(name = "t_poisson")
public class PoissonDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private int id;
    @Column(name = "c_couleur", nullable = false)
    private String couleur;
    @Column(name = "c_description", nullable = false)
    private String descritpion;
    @Column(name = "c_largeur", nullable = false)
    private float largeur;
    @Column(name = "c_longeur", nullable = false)
    private float longeur;
    @Column(name = "c_nom", nullable = false)
    private String nom;
    @Column(name = "c_prix", nullable = false)
    private int prix;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the descritpion
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * @param descritpion the descritpion to set
     */
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    /**
     * @return the largeur
     */
    public float getLargeur() {
        return largeur;
    }

    /**
     * @param largeur the largeur to set
     */
    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    /**
     * @return the longeur
     */
    public float getLongeur() {
        return longeur;
    }

    /**
     * @param longeur the longeur to set
     */
    public void setLongeur(float longeur) {
        this.longeur = longeur;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }


}
