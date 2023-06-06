package Investor;

public class Algoritmus {

    // Vygeneruje novou cenu akcie
    public void novaCena(Akcie akcie) {

        boolean tendence = akcie.getTendenceCeny();
        double sanceNaZmenu = akcie.getSanceNaZmenu();

        double cisloSance = Math.floor((Math.random() * 100) + 1); // Vygenerování čísla šance - pokud je menší než sanceNaZmenu, změní se tendence vývoje ceny
        double mutatio = ((Math.random() * 10) + 1); // Vygenerován přírůstek / úbytek ceny akcie
        
        // Růstová tendence
        if (tendence) {
            
            if (cisloSance > sanceNaZmenu) {
                akcie.setAktualniCena(akcie.getAktualniCena() + mutatio);
            }

            // Změna tendence na poklesovou
            else {
                akcie.setTendenceCeny(false);
                akcie.setSanceNaZmenu(Math.floor((Math.random() * 50) + 1)); // Určení nové šance na změnu tendence vývoje ceny
                akcie.setPrirustekSanceNaZmenu(Math.floor((Math.random() * 10) + 1)); // Určení nového přírůstku šance na pád akcie
            }
        }
        
        // Poklesová tendence
        else {

            if (cisloSance > sanceNaZmenu) {
                akcie.setAktualniCena(akcie.getAktualniCena() - mutatio);
            }

            // Změna tendence na růstovou
            else {
                akcie.setTendenceCeny(true);
                akcie.setSanceNaZmenu(Math.floor((Math.random() * 50) + 1)); // Určení nové šance na změnu tendence vývoje ceny
                akcie.setPrirustekSanceNaZmenu(Math.floor((Math.random() * 10) + 1)); // Určení nového přírůstku šance na pád akcie
            }
            
        }

        // Zajištění kladného čísla
        if (akcie.getAktualniCena() < 0) {
            akcie.setAktualniCena(Math.abs(akcie.getAktualniCena()));
        }

        akcie.setSanceNaZmenu(akcie.getSanceNaZmenu() + akcie.getPrirustekSanceNaZmenu()); // Šance na změnu se zvýší o stanovenou hodnotu
        
        akcie.setNabizeneMnozstvi((int)Math.floor((Math.random() * 20) + 1)); // Nastavení nabízeného množství
    }
}
