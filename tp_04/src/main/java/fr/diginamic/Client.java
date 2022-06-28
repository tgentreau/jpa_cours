package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    @ManyToMany(mappedBy = "lesClients")
    private Set<Compte> lesComptes;

    public Client() {
    }

    public Long getId() {
        return id;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public Set<Compte> getLesComptes() {
        return lesComptes;
    }

    public void setLesComptes(Set<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(getId());
        sb.append(", nom='").append(getNom()).append('\'');
        sb.append(", prenom='").append(getPrenom()).append('\'');
        sb.append(", dateNaissance=").append(getDateNaissance());
        sb.append(", adresse=").append(getAdresse());
        sb.append(", banque=").append(getBanque());
        sb.append('}');
        return sb.toString();
    }
}
