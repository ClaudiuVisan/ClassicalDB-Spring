package com.example.classicaldb.catalogue;

import com.example.classicaldb.composer.Composer;
import com.example.classicaldb.composition.Composition;

import javax.persistence.*;

@Entity
@Table(name="cataloage")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String simbol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_compozitor")
    private Composer composer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_compozitie")
    private Composition composition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }
}
