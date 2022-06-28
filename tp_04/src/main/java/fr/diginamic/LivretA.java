package fr.diginamic;

import javax.persistence.*;

@Entity
@Table(name = "LivretA")
public class LivretA extends Compte{
    @Column(name = "taux")
    private Double taux;

    public LivretA() {
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("LivretA{");
        sb.append("taux=").append(getTaux());
        sb.append('}');
        return sb.toString();
    }
}
