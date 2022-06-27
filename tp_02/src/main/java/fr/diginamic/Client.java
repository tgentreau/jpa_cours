package fr.diginamic;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "id_client")
    private List<Emprunt> emprunts;

    @Column(name = "NOM", length = 50)
    private String nom;

    @Column(name = "PRENOM", length = 50)
    private String prenom;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", emprunts=").append(emprunts);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
