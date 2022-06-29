package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Connection {
    public static void main(String[] args) {
        //Factory et manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //init classes
        Client client = new Client();
        Adresse adresse = new Adresse();
        Banque banque = new Banque();
        LivretA livretA = new LivretA();
        Virement virement = new Virement();
        Client client2 = new Client();
        AssuranceVie assuranceVie = new AssuranceVie();

        //Arrays
        List<Client> clients = new ArrayList<>();
        List<Operation> operations = new ArrayList<>();
        Set<Client> clients2 = new HashSet<>();
        Set<Compte> comptes = new HashSet<>();
        clients2.add(client);
        clients2.add(client2);
        clients.add(client);
        comptes.add(livretA);
        comptes.add(assuranceVie);
        operations.add(virement);

        //set values
        banque.setNom("la banque");
        banque.setClients(clients);
        adresse.setNumero(9);
        adresse.setRue("rue de ici");
        adresse.setCodePostal("40100");
        adresse.setVille("Dax");
        client.setPrenom("Thomas");
        client.setNom("Gentreau");
        client.setAdresse(adresse);
        client.setDateNaissance(LocalDate.now());
        client.setBanque(banque);
        client.setLesComptes(comptes);
        client2.setPrenom("lolo");
        client2.setNom("lulu");
        client2.setAdresse(adresse);
        client2.setDateNaissance(LocalDate.now());
        client2.setBanque(banque);
        client2.setLesComptes(comptes);
        livretA.setNumero("efzfzfef44414");
        livretA.setTaux(2.5);
        livretA.setSolde(4.500);
        livretA.setLesClients(clients2);
        livretA.setOperations(operations);
        virement.setBeneficiaire("lui");
        virement.setCompte(livretA);
        virement.setDate(LocalDate.now());
        virement.setMotif("aucun");
        virement.setMontant(50.00);
        assuranceVie.setNumero("ferfg464575");
        assuranceVie.setSolde(3.000);
        assuranceVie.setTaux(0.5);
        assuranceVie.setDateFin(LocalDate.now().plusDays(582));
        assuranceVie.setLesClients(clients2);

        //persits
        em.persist(client);
        em.persist(client2);
        em.persist(banque);
        em.persist(livretA);
        em.persist(assuranceVie);
        em.getTransaction().commit();

//        Client client1 = em.find(Client.class, 1L);
        Compte compte = em.find(Compte.class, 1L);
//        Banque banque1 = em.find(Banque.class, 1L);
//        LivretA livretA1 = (LivretA) em.find(Compte.class, 1L);
//        Virement virement1 = (Virement) em.find(Operation.class, 1L);
//        System.out.println(client1.toString());
        System.out.println(compte.toString());
//        System.out.println(banque1.toString());
//        System.out.println(livretA1.toString());
//        System.out.println(virement1.toString());
    }
}
