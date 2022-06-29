package fr.openfoodfacts;

import fr.openfoodfacts.bll.ProduitManager;
import fr.openfoodfacts.entities.Produit;

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
        List<String> produit = new ArrayList<>();
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                produit.add(Arrays.toString(line.split("\\|")));
            });
            System.out.println(produit.get(1));
        }

    }
}
