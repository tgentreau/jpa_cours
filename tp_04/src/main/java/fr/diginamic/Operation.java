package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "motif")
    private String motif;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_compte")
    private Compte compte;

    public Operation() {
    }

    public Long getId() {
        return id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Operation{");
        sb.append("id=").append(getId());
        sb.append(", montant=").append(getMontant());
        sb.append(", date=").append(getDate());
        sb.append(", motif='").append(getMotif()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
