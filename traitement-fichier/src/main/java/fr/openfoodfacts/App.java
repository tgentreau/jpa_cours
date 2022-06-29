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
import java.util.List;
import java.util.stream.Stream;

public class App {

    static ProduitManager service;
    public static void main(String[] args) throws URISyntaxException, IOException {
        //instance classes
        Produit produit1 = new Produit();
        Categorie categorie = new Categorie();
        Ingredient ingredient = new Ingredient();
        Allergene allergene = new Allergene();
        Marque marque = new Marque();

        //Récupération data csv
        List<String[]> produit = new ArrayList<>();
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                produit.add(line.split("\\|"));
            });

        }
        //Traitement data
        for (String[] s : produit) {
            if(s.length == 30) {
                System.out.println(Arrays.toString(s));
                categorie.setLibelle(s[0]);
                produit1.setCategorie(categorie);
                marque.setLibelle(s[1]);
                produit1.setMarque(marque);
                produit1.setNom(s[2]);
                produit1.setScoreNutritionnel(s[3].toCharArray()[0]);
                //ingrédients
                produit1.setEnergie(Double.valueOf(s[5]));
                produit1.setGraisse(Double.valueOf(s[6]));
                produit1.setSucres(Double.valueOf(s[7]));
                produit1.setFibre(Double.valueOf(s[8]));
                produit1.setProteines(Double.valueOf(s[9]));
                produit1.setSel(Double.valueOf(s[10]));
                produit1.setVitA(Double.valueOf(s[11]));
                produit1.setVitD(Double.valueOf(s[12]));
                produit1.setVitE(Double.valueOf(s[13]));
                produit1.setVitK(Double.valueOf(s[14]));
                produit1.setVitC(Double.valueOf(s[15]));
                produit1.setVitB1(Double.valueOf(s[16]));
                produit1.setVitB2(Double.valueOf(s[17]));
                produit1.setVitPP(Double.valueOf(s[18]));
                produit1.setVitB6(Double.valueOf(s[19]));
                produit1.setVitB9(Double.valueOf(s[20]));
                produit1.setVitB12(Double.valueOf(s[21]));
                produit1.setCalcium(Double.valueOf(s[22]));
                produit1.setMagnesium(Double.valueOf(s[23]));
                produit1.setIron(Double.valueOf(s[24]));
                produit1.setFer(Double.valueOf(s[25]));
                produit1.setBetaCarotene(Double.valueOf(s[26]));
                produit1.setPresenceHuileDePalme(Boolean.parseBoolean(s[27]));
                //alergenes
                //additifs
            }
        }

    }

//    public void sortValues(List<T> list, String s) {
//
//    }
}
