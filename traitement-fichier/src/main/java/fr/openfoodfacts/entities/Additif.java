package fr.openfoodfacts.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Additif")
public class Additif {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private long id;

    private String libelle;

    @ManyToMany(mappedBy = "additifs")
    private Set<Produit> produits = new HashSet<>();

    public Additif() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
