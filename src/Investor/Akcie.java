package Investor;

public class Akcie {

    private boolean tendenceCeny;
    private double sanceNaZmenu;
    private double prirustekSanceNaZmenu;
    private int cislo;
    private String jmeno;
    private double aktualniCena;
    private int vlastneneMnozstvi;
    private int nabizeneMnozstvi;
    private double mutatio;

    // Nastaví jméno a číslo akcie + její počáteční cenu, šanci na změnu, přírůstek a tendenci
    Akcie(String jmeno, int cislo) {

        this.jmeno = jmeno;
        this.cislo = cislo;
        this.aktualniCena = (Math.random() * 20) + 1; // Počáteční cena
        this.sanceNaZmenu = Math.floor((Math.random() * 50) + 1); // Počáteční šance na změnu
        this.prirustekSanceNaZmenu = Math.floor((Math.random() * 10) + 1); // Počáteční přírůstek šance na změnu
        this.tendenceCeny = (Math.floor((Math.random() * 2) + 1) == 1); // Počáteční tendence
    }

    // Nastaví tendenci vývoje ceny
    public void setTendenceCeny(boolean tendenceCeny) {
        this.tendenceCeny = tendenceCeny;
    }

    // Vrátí tendenci vývoje ceny
    public boolean getTendenceCeny() {
        return tendenceCeny;
    }

    // Nastaví šanci na změnu tendence
    public void setSanceNaZmenu(double sanceNaZmenu) {
        this.sanceNaZmenu = sanceNaZmenu;
    }

    // Vrátí šanci na změnu tendence
    public double getSanceNaZmenu() {
        return sanceNaZmenu;
    }

    // Nastaví přírůstek šance na změnu tendence
    public void setPrirustekSanceNaZmenu(double prirustekSanceNaZmenu) {
        this.prirustekSanceNaZmenu = prirustekSanceNaZmenu;
    }

    // Vrátí přírůstek šance na změnu tendence
    public double getPrirustekSanceNaZmenu() {
        return prirustekSanceNaZmenu;
    }

    // Nastaví číslo akcie
    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    // Vrátí číslo akcie
    public int getCislo() {
        return cislo;
    }

    // Nastaví jméno akcie
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    // Vrátí jméno akcie
    public String getJmeno() {
        return jmeno;
    }

    // Nastaví aktuální cenu akcie
    public void setAktualniCena(double aktualniCena) {
        this.aktualniCena = aktualniCena;
    }

    // Vrátí aktuální cenu akcie
    public double getAktualniCena() {
        return aktualniCena;
    }

    // Nastaví množství vlastněných akcií
    public void setVlastneneMnozstvi(int vlasneneMnozstvi) {
        this.vlastneneMnozstvi = vlasneneMnozstvi;
    }

    // Vrátí množství vlastněných akcií
    public int getVlasneneMnozstvi() {
        return vlastneneMnozstvi;
    }

    // Nastaví množství nabízených akcií
    public void setNabizeneMnozstvi(int nabizeneMnozstvi) {
        this.nabizeneMnozstvi = nabizeneMnozstvi;
    }

    // Vrátí množství nabízených akcií
    public int getNabizeneMnozstvi() {
        return nabizeneMnozstvi;
    }

    // Nastaví číslo, které se od aktuální ceny akcie odečte/přičte
    public void setMutatio(double mutatio) {
        this.mutatio = mutatio;
    }

    // Vrátí číslo, které se od aktuální ceny akcie odečte/přičte
    public double getMutatio() {
        return mutatio;
    }
}
