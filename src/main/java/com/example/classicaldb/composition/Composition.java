package com.example.classicaldb.composition;

import com.example.classicaldb.catalogue.Catalogue;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "compozitii")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 150)
    private String titlu;

    @Column(nullable = false)
    private Integer an_aparitie;

    @Column(nullable = false)
    private String gen;

    @Column(nullable = true,length = 15)
    private String gama;

    @Column(nullable = true)
    private Integer nr_instrumente;

    @OneToMany(targetEntity = Catalogue.class, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Catalogue> catalogueList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Integer getAn_aparitie() {
        return an_aparitie;
    }

    public void setAn_aparitie(Integer an_aparitie) {
        this.an_aparitie = an_aparitie;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public Integer getNr_instrumente() {
        return nr_instrumente;
    }

    public void setNr_instrumente(Integer nr_instrumente) {
        this.nr_instrumente = nr_instrumente;
    }

    public List<Catalogue> getCatalogueList() {
        return catalogueList;
    }

    public void setCatalogueList(List<Catalogue> catalogueList) {
        this.catalogueList = catalogueList;
    }
}
