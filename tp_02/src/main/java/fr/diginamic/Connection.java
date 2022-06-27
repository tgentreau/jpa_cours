package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();
        Emprunt emprunt = em.find(Emprunt.class, 1);
        Client client = em.find(Client.class, 1);
        System.out.println(emprunt.toString());
        System.out.println(client.toString());

    }
}
