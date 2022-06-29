package fr.openfoodfacts.bll;

import fr.openfoodfacts.dal.DALExeption;
import fr.openfoodfacts.dal.DAOFactory;
import fr.openfoodfacts.entities.Categorie;
import fr.openfoodfacts.entities.Ingredient;
import fr.openfoodfacts.entities.Marque;
import fr.openfoodfacts.entities.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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

    public Marque getMarque(String libelle) {
        TypedQuery<Marque> query = em.createQuery("select e from Marque e where e.libelle = :libelle", Marque.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Categorie getCategorie(String libelle) {
        TypedQuery<Categorie> query = em.createQuery("select e from Categorie e where e.libelle = :libelle", Categorie.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Ingredient getIngredient(String libelle) {
        TypedQuery<Ingredient> query = em.createQuery("select e from Ingredient e where e.libelle = :libelle", Ingredient.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public void addProduit(Produit produit)  {
        Marque marque = getMarque(produit.getMarque().getLibelle());
        Categorie categorie = getCategorie(produit.getCategorie().getLibelle());

        if(marque != null) {
            produit.setMarque(marque);
        }
        if(categorie != null) {
            produit.setCategorie(categorie);
        }
        em.persist(produit);
    }
}
