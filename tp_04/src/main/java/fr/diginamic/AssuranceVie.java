package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AssuranceVie")
public class AssuranceVie extends Compte{
    @Column(name = "taux")
    private Double taux;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    public AssuranceVie() {
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("AssuranceVie{");
        sb.append(", taux=").append(getTaux());
        sb.append(", dateFin=").append(getDateFin());
        sb.append('}');
        return sb.toString();
    }
}
