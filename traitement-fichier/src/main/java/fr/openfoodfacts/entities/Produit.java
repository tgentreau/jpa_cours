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

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marque")
    private Marque marque;
    private Character scoreNutritionnel;
    private String energie;
    private String graisse;
    private String sucres;
    private String fibre;
    private String proteines;
    private String sel;
    private String vitA;
    private String vitD;
    private String vitE;
    private String vitK;
    private String vitC;
    private String vitB;
    private String vitB1;
    private String vitB2;
    private String vitPP;
    private String vitB6;
    private String vitB9;
    private String vitB12;
    private String calcium;
    private String magnesium;
    private String iron;
    private String fer;
    private String betaCarotene;
    private boolean presenceHuileDePalme;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Ingredient> ingredients;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Allergene> allergenes;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Additif> additifs;

    public Produit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getGraisse() {
        return graisse;
    }

    public void setGraisse(String graisse) {
        this.graisse = graisse;
    }

    public String getSucres() {
        return sucres;
    }

    public void setSucres(String sucres) {
        this.sucres = sucres;
    }

    public String getFibre() {
        return fibre;
    }

    public void setFibre(String fibre) {
        this.fibre = fibre;
    }

    public String getProteines() {
        return proteines;
    }

    public void setProteines(String proteines) {
        this.proteines = proteines;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public String getVitA() {
        return vitA;
    }

    public void setVitA(String vitA) {
        this.vitA = vitA;
    }

    public String getVitD() {
        return vitD;
    }

    public void setVitD(String vitD) {
        this.vitD = vitD;
    }

    public String getVitE() {
        return vitE;
    }

    public void setVitE(String vitE) {
        this.vitE = vitE;
    }

    public String getVitK() {
        return vitK;
    }

    public void setVitK(String vitK) {
        this.vitK = vitK;
    }

    public String getVitC() {
        return vitC;
    }

    public void setVitC(String vitC) {
        this.vitC = vitC;
    }

    public String getVitB() {
        return vitB;
    }

    public void setVitB(String vitB) {
        this.vitB = vitB;
    }

    public String getVitB1() {
        return vitB1;
    }

    public void setVitB1(String vitB1) {
        this.vitB1 = vitB1;
    }

    public String getVitB2() {
        return vitB2;
    }

    public void setVitB2(String vitB2) {
        this.vitB2 = vitB2;
    }

    public String getVitPP() {
        return vitPP;
    }

    public void setVitPP(String vitPP) {
        this.vitPP = vitPP;
    }

    public String getVitB6() {
        return vitB6;
    }

    public void setVitB6(String vitB6) {
        this.vitB6 = vitB6;
    }

    public String getVitB9() {
        return vitB9;
    }

    public void setVitB9(String vitB9) {
        this.vitB9 = vitB9;
    }

    public String getVitB12() {
        return vitB12;
    }

    public void setVitB12(String vitB12) {
        this.vitB12 = vitB12;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(String magnesium) {
        this.magnesium = magnesium;
    }

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron;
    }

    public String getFer() {
        return fer;
    }

    public void setFer(String fer) {
        this.fer = fer;
    }

    public String getBetaCarotene() {
        return betaCarotene;
    }

    public void setBetaCarotene(String betaCarotene) {
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

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
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
