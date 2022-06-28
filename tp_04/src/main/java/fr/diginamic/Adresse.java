package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    @Column(name = "numero", length = 50)
    private int numero;
    @Column(name = "rue", length = 50)
    private String rue;
    @Column(name = "codePostal", length = 8)
    private String codePostal;
    @Column(name = "ville", length = 50)
    private String ville;

    public Adresse() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("numero=").append(getNumero());
        sb.append(", rue='").append(getRue()).append('\'');
        sb.append(", codePostal=").append(getCodePostal());
        sb.append(", ville='").append(getVille()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
