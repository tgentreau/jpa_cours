package fr.diginamic;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "LIVRE")
public class Livre {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String auteur;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns=@JoinColumn(name="ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"))
    private Set<Emprunt> lesEmprunts;

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livre{");
        sb.append("id=").append(getId());
        sb.append(", titre='").append(getTitre()).append('\'');
        sb.append(", auteur='").append(getAuteur()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
