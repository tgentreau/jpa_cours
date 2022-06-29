package fr.openfoodfacts.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private long id;

    private String nom;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Categorie categorie;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Marque marque;
    private Character scoreNutritionnel;
    private Double energie;
    private Double graisse;
    private Double sucres;
    private Double fibre;
    private Double proteines;
    private Double sel;
    private Double vitA;
    private Double vitD;
    private Double vitE;
    private Double vitK;
    private Double vitC;
    private Double vitB;
    private Double vitB1;
    private Double vitB2;
    private Double vitPP;
    private Double vitB6;
    private Double vitB9;
    private Double vitB12;
    private Double calcium;
    private Double magnesium;
    private Double iron;
    private Double fer;
    private Double betaCarotene;
    private boolean presenceHuileDePalme;
    @ManyToMany
    private List<Ingredient> ingredients;
    @ManyToMany
    private List<Allergene> allergenes;
    private static List<String> additifs;

    public Produit() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Character getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(Character scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public Double getEnergie() {
        return energie;
    }

    public void setEnergie(Double energie) {
        this.energie = energie;
    }

    public Double getGraisse() {
        return graisse;
    }

    public void setGraisse(Double graisse) {
        this.graisse = graisse;
    }

    public Double getSucres() {
        return sucres;
    }

    public void setSucres(Double sucres) {
        this.sucres = sucres;
    }

    public Double getFibre() {
        return fibre;
    }

    public void setFibre(Double fibre) {
        this.fibre = fibre;
    }

    public Double getProteines() {
        return proteines;
    }

    public void setProteines(Double proteines) {
        this.proteines = proteines;
    }

    public Double getSel() {
        return sel;
    }

    public void setSel(Double sel) {
        this.sel = sel;
    }

    public Double getVitA() {
        return vitA;
    }

    public void setVitA(Double vitA) {
        this.vitA = vitA;
    }

    public Double getVitD() {
        return vitD;
    }

    public void setVitD(Double vitD) {
        this.vitD = vitD;
    }

    public Double getVitE() {
        return vitE;
    }

    public void setVitE(Double vitE) {
        this.vitE = vitE;
    }

    public Double getVitK() {
        return vitK;
    }

    public void setVitK(Double vitK) {
        this.vitK = vitK;
    }

    public Double getVitC() {
        return vitC;
    }

    public void setVitC(Double vitC) {
        this.vitC = vitC;
    }

    public Double getVitB() {
        return vitB;
    }

    public void setVitB(Double vitB) {
        this.vitB = vitB;
    }

    public Double getVitB1() {
        return vitB1;
    }

    public void setVitB1(Double vitB1) {
        this.vitB1 = vitB1;
    }

    public Double getVitB2() {
        return vitB2;
    }

    public void setVitB2(Double vitB2) {
        this.vitB2 = vitB2;
    }

    public Double getVitPP() {
        return vitPP;
    }

    public void setVitPP(Double vitPP) {
        this.vitPP = vitPP;
    }

    public Double getVitB6() {
        return vitB6;
    }

    public void setVitB6(Double vitB6) {
        this.vitB6 = vitB6;
    }

    public Double getVitB9() {
        return vitB9;
    }

    public void setVitB9(Double vitB9) {
        this.vitB9 = vitB9;
    }

    public Double getVitB12() {
        return vitB12;
    }

    public void setVitB12(Double vitB12) {
        this.vitB12 = vitB12;
    }

    public Double getCalcium() {
        return calcium;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getFer() {
        return fer;
    }

    public void setFer(Double fer) {
        this.fer = fer;
    }

    public Double getBetaCarotene() {
        return betaCarotene;
    }

    public void setBetaCarotene(Double betaCarotene) {
        this.betaCarotene = betaCarotene;
    }

    public boolean isPresenceHuileDePalme() {
        return presenceHuileDePalme;
    }

    public void setPresenceHuileDePalme(boolean presenceHuileDePalme) {
        this.presenceHuileDePalme = presenceHuileDePalme;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public List<String> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<String> additifs) {
        this.additifs = additifs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", scoreNutritionnel=").append(scoreNutritionnel);
        sb.append(", energie=").append(energie);
        sb.append(", graisse=").append(graisse);
        sb.append(", sucres=").append(sucres);
        sb.append(", fibre=").append(fibre);
        sb.append(", proteines=").append(proteines);
        sb.append(", sel=").append(sel);
        sb.append(", vitA=").append(vitA);
        sb.append(", vitD=").append(vitD);
        sb.append(", vitE=").append(vitE);
        sb.append(", vitK=").append(vitK);
        sb.append(", vitC=").append(vitC);
        sb.append(", vitB=").append(vitB);
        sb.append(", vitB1=").append(vitB1);
        sb.append(", vitB2=").append(vitB2);
        sb.append(", vitPP=").append(vitPP);
        sb.append(", vitB6=").append(vitB6);
        sb.append(", vitB9=").append(vitB9);
        sb.append(", vitB12=").append(vitB12);
        sb.append(", calcium=").append(calcium);
        sb.append(", magnesium=").append(magnesium);
        sb.append(", iron=").append(iron);
        sb.append(", fer=").append(fer);
        sb.append(", betaCarotene=").append(betaCarotene);
        sb.append(", presenceHuileDePalme=").append(presenceHuileDePalme);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", allergenes=").append(allergenes);
        sb.append('}');
        return sb.toString();
    }
}
