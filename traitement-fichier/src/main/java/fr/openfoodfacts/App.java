package fr.openfoodfacts;

import fr.openfoodfacts.bll.ProduitManager;
import fr.openfoodfacts.entities.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class App {

    private static final String regex = "\\|";

    static ProduitManager service = new ProduitManager();
    public static void main(String[] args) throws URISyntaxException, IOException {
        //instance classes
        Produit produit1 = new Produit();
        Categorie categorie = new Categorie();
        Allergene allergene = new Allergene();
        Marque marque = new Marque();

        //Lists
        List<Ingredient> ingredients = new ArrayList<>();
        List<Allergene> alergenes = new ArrayList<>();
        List<Additif> additifs = new ArrayList<>();
        List<String[]> produit = new ArrayList<>();

        //Récupération data csv
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                produit.add(line.split(regex));
            });

        }

        //Traitement data
        for (String[] s : produit) {
//            "\\."
            if(s.length == 30 && !s[0].equals(produit.get(0)[0])) {
                String[] liIngredients = s[4].split(",");
                for (String liIngredient : liIngredients[0].split(";")) {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setLibelle(liIngredient);
                    ingredients.add(ingredient);
                }
                String[] liAdditifs = s[29].split(",");
                for (String liAdditif : liAdditifs) {
                    System.out.println(liAdditif);
                    Additif additif = new Additif();
                    additif.setLibelle(liAdditif);
                    additifs.add(additif);
                }
                categorie.setLibelle(s[0]);
                produit1.setCategorie(categorie);
                marque.setLibelle(s[1]);
                produit1.setMarque(marque);
                produit1.setNom(s[2]);
                produit1.setScoreNutritionnel(s[3].toCharArray()[0]);
                produit1.setIngredients(ingredients);
                produit1.setEnergie(s[5]);
                produit1.setGraisse(s[6]);
                produit1.setSucres(s[7]);
                produit1.setFibre(s[8]);
                produit1.setProteines(s[9]);
                produit1.setSel(s[10]);
                produit1.setVitA(s[11]);
                produit1.setVitD(s[12]);
                produit1.setVitE(s[13]);
                produit1.setVitK(s[14]);
                produit1.setVitC(s[15]);
                produit1.setVitB1(s[16]);
                produit1.setVitB2(s[17]);
                produit1.setVitPP(s[18]);
                produit1.setVitB6(s[19]);
                produit1.setVitB9(s[20]);
                produit1.setVitB12(s[21]);
                produit1.setCalcium(s[22]);
                produit1.setMagnesium(s[23]);
                produit1.setIron(s[24]);
                produit1.setFer(s[25]);
                produit1.setBetaCarotene(s[26]);
                produit1.setPresenceHuileDePalme(Boolean.parseBoolean(s[27]));
                produit1.setAllergenes(alergenes);
                produit1.setAdditifs(additifs);

                service.addProduit(produit1);
            }
        }
    }
}
