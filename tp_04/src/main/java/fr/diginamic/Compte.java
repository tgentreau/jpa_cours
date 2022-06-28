package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;

    @Column(name = "numero", length = 50)
    private String numero;

    @Column(name = "solde")
    private Double solde;

    @ManyToMany
    @JoinTable(name="compte_client",
            joinColumns=@JoinColumn(name="id_compte", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name="id_client", referencedColumnName = "Id"))
    private Set<Client> lesClients;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Operation> operations;

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Set<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(Set<Client> lesClients) {
        this.lesClients = lesClients;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compte{");
        sb.append("id=").append(getId());
        sb.append(", numero='").append(getNumero()).append('\'');
        sb.append(", solde=").append(getSolde());
        sb.append(", lesClients=").append(getLesClients());
        sb.append(", operations=").append(getOperations());
        sb.append('}');
        return sb.toString();
    }
}
