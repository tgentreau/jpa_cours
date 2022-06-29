package fr.openfoodfacts.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Allergene")
public class Allergene {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private long id;
    private String libelle;

    public Allergene() {
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Allergene{");
        sb.append("id=").append(getId());
        sb.append(", libelle='").append(getLibelle()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
