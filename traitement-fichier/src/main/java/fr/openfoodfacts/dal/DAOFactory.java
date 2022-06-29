package fr.openfoodfacts.dal;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
    public static EntityManagerFactory getFactory() {
        return Persistence.createEntityManagerFactory("pu_essai");
    }
}
