package com.example.classicaldb.composer;

import com.example.classicaldb.catalogue.Catalogue;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name= "compozitori")
public class Composer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 50)
    private String nume;

    @Column(nullable = false,length = 100)
    private String prenume;

    @Column(nullable = false,length = 45)
    private String stil;

    @Column(nullable = false,length = 45)
    private String tara_origine;

    @Column(nullable = false)
    private Date data_nasterii;

    @Column
    private Date data_mortii;

    @OneToMany(targetEntity = Catalogue.class, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Catalogue> catalogueList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    public String getTara_origine() {
        return tara_origine;
    }

    public void setTara_origine(String tara_origine) {
        this.tara_origine = tara_origine;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public Date getData_mortii() {
        return data_mortii;
    }

    public void setData_mortii(Date data_mortii) {
        this.data_mortii = data_mortii;
    }

    public List<Catalogue> getCatalogueList() {
        return catalogueList;
    }

    public void setCatalogueList(List<Catalogue> catalogueList) {
        this.catalogueList = catalogueList;
    }

}
