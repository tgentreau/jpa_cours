package fr.diginamic;

import javax.persistence.*;

@Entity
@Table(name = "Virement")
public class Virement extends Operation{
    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement() {
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Virement{");
        sb.append(", beneficiaire='").append(getBeneficiaire()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
