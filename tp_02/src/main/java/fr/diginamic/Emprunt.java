package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name = "DATE_DEBUT")
    private LocalDate date_debut;

    @Column(name = "DELAI",length = 10)
    private int delai;

    @Column(name = "DATE_FIN")
    private LocalDate date_fin;

    @ManyToMany(mappedBy = "lesEmprunts")
    private Set<Livre> lesLivres;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client id_client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public Set<Livre> getLesLivres() {
        return lesLivres;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(getId());
        sb.append(", date_debut=").append(getDate_debut());
        sb.append(", delai=").append(getDelai());
        sb.append(", date_fin=").append(getDate_fin());
        sb.append(", lesLivres=").append(getLesLivres());
        sb.append('}');
        return sb.toString();
    }
}
