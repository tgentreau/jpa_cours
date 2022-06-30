package fr.openfoodfacts;

import fr.openfoodfacts.bll.BLLExeption;
import fr.openfoodfacts.bll.ProduitManager;
import fr.openfoodfacts.entities.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class App {

    private static final String regex = "\\|";
    private static final String regexVirgule = ",";

    static ProduitManager service = new ProduitManager();
    public static void main(String[] args) throws URISyntaxException, IOException, BLLExeption {
        //instance classes
        Produit produit = new Produit();
        Categorie categorie = new Categorie();
        Marque marque = new Marque();

        //Lists
        Set<String[]> produits = new HashSet<>();

        //Récupération data csv
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.skip(1).forEach(line -> {
                produits.add(line.split(regex));
            });

        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

        int counter = 0;
        //Traitement data
        for (String[] s : produits) {
            Set<Ingredient> ingredients = new HashSet<>();
            Set<Allergene> alergenes = new HashSet<>();
            Set<Additif> additifs = new HashSet<>();
//            "\\."
            if(s.length == 30) {
                String[] liIngredients = s[4].split(regexVirgule);
                for (String liIngredient : liIngredients[0].split(";")) {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setLibelle(liIngredient.trim());
                    ingredients.add(ingredient);
                }

                String[] liAdditifs = s[29].split(regexVirgule);
                for (String liAdditif : liAdditifs) {
                    Additif additif = new Additif();
                    additif.setLibelle(liAdditif.trim());
                    additifs.add(additif);
                }

                String[] liAllergenes = s[28].split(regexVirgule);
                for (String liAllergene : liAllergenes) {
                    Allergene allergene = new Allergene();
                    allergene.setLibelle(liAllergene.trim());
                    alergenes.add(allergene);
                }

                categorie.setLibelle(s[0]);
                produit.setCategorie(categorie);
                marque.setLibelle(s[1]);
                produit.setMarque(marque);
                produit.setNom(s[2]);
                produit.setScoreNutritionnel(s[3].toCharArray()[0]);
                produit.setIngredients(ingredients);
                produit.setEnergie(s[5]);
                produit.setGraisse(s[6]);
                produit.setSucres(s[7]);
                produit.setFibre(s[8]);
                produit.setProteines(s[9]);
                produit.setSel(s[10]);
                produit.setVitA(s[11]);
                produit.setVitD(s[12]);
                produit.setVitE(s[13]);
                produit.setVitK(s[14]);
                produit.setVitC(s[15]);
                produit.setVitB1(s[16]);
                produit.setVitB2(s[17]);
                produit.setVitPP(s[18]);
                produit.setVitB6(s[19]);
                produit.setVitB9(s[20]);
                produit.setVitB12(s[21]);
                produit.setCalcium(s[22]);
                produit.setMagnesium(s[23]);
                produit.setIron(s[24]);
                produit.setFer(s[25]);
                produit.setBetaCarotene(s[26]);
                produit.setPresenceHuileDePalme(Boolean.parseBoolean(s[27]));
                produit.setAllergenes(alergenes);
                produit.setAdditifs(additifs);

                try {
                    service.addProduit(produit);
                } catch (BLLExeption e) {
                    throw new BLLExeption("Erreur bll: ",e);
                }

            }
            if(counter >= 10) {
                break;
            }
            counter ++;
        }
        //code
    }
}
