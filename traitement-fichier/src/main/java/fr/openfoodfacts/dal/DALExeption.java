package fr.openfoodfacts.dal;

public class DALExeption extends Exception{
    public DALExeption() {
        super();
    }

    public DALExeption(String message) {
        super(message);
    }

    public DALExeption(String message, Throwable exception) {
        super(message, exception);
    }

    //Méthodes
    @Override
    public String getMessage() {
        StringBuffer sb = new StringBuffer("Couche DAL - ");
        sb.append(super.getMessage());

        return sb.toString() ;
    }
}
