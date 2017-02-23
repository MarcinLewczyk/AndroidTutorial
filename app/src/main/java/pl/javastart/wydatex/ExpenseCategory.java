package pl.javastart.wydatex;

public enum ExpenseCategory {

    FOOD("Jedzenie"), ENTERTAINMENT("Rozrywka"), HYGIENE("Higiena"), OTHER("Inne");
    private String name;

    private ExpenseCategory(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
