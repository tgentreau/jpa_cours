package fr.openfoodfacts.bll;

import fr.openfoodfacts.dal.DALExeption;
import fr.openfoodfacts.dal.DAOFactory;
import fr.openfoodfacts.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProduitManager {
    private static volatile ProduitManager instance = null;
    EntityManager em = null;

    public ProduitManager() {
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

    public Allergene getAllergene(String libelle) {
        TypedQuery<Allergene> query = em.createQuery("select e from Allergene e where e.libelle = :libelle", Allergene.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Additif getAdditif(String libelle) {
        TypedQuery<Additif> query = em.createQuery("select e from Additif e where e.libelle = :libelle", Additif.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public void addProduit(Produit produit) throws BLLExeption {
        em.getTransaction().begin();
        Marque marque = getMarque(produit.getMarque().getLibelle());
        Categorie categorie = getCategorie(produit.getCategorie().getLibelle());

        try {
            //Gestion des doublons
            if(marque != null) {
                produit.setMarque(marque);
                marque.getProduits().add(produit);
            }
            if(categorie != null) {
                produit.setCategorie(categorie);
                categorie.getProduits().add(produit);
            }

            produit.setIngredients(produit.getIngredients().stream()
                    .map(e -> {
                        Ingredient ingredient = getIngredient(e.getLibelle());
                        if(ingredient != null) {
                            ingredient.getProduits().add(produit);
                            return ingredient;
                        }
                        return e;
                    }) .collect(Collectors.toSet()));

            produit.setAllergenes(produit.getAllergenes().stream()
                    .map(e -> {
                        Allergene allergene = getAllergene(e.getLibelle());
                        if(allergene != null) {
                            allergene.getProduits().add(produit);
                            return allergene;
                        }
                        return e;
                    }) .collect(Collectors.toSet()));

            produit.setAdditifs(produit.getAdditifs().stream()
                    .map(e -> {
                        Additif additif = getAdditif(e.getLibelle());
                        if(additif != null) {
                            additif.getProduits().add(produit);
                            return additif;
                        }
                        return e;
                    }).collect(Collectors.toSet()));

            em.persist(produit);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

    }
}
