package fr.openfoodfacts.bll;

import fr.openfoodfacts.dal.DALExeption;
import fr.openfoodfacts.dal.DAOFactory;
import fr.openfoodfacts.entities.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProduitManager {
    private static volatile ProduitManager instance = null;
    EntityManager em = null;

    private ProduitManager() {
        EntityManagerFactory emf = DAOFactory.getFactory();
        em = emf.createEntityManager();
    }

    public static final ProduitManager getInstance() {
        if(ProduitManager.instance == null) {
            synchronized (ProduitManager.class) {
                if(ProduitManager.instance == null) {
                    ProduitManager.instance = new ProduitManager();
                }
            }
        }
        return ProduitManager.instance;
    }

    public void addProduit(Produit produit) throws BLLExeption {
        if(produit.getId() != 0) {
            throw new BLLExeption("Produit déjà existant");
        }
        em.persist(produit);
    }
}
