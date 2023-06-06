package Investor;

public class PevneFinance {

    private double hodnota;

    // Nastaví počáteční množství vlastněných peněz
    PevneFinance(double hodnota) {
        this.hodnota = hodnota;
    }

    // Změní množství vlastněných peněz
    public void setHodnota(double hodnota) {
        this.hodnota = hodnota;
    }

    // Vrátí množství vlastněných peněz
    public double getHodnota() {
        return hodnota;
    }
}
