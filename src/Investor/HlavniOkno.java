package Investor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class HlavniOkno implements ActionListener {

    private static final DecimalFormat formatPenez = new DecimalFormat("0.00"); // Zajistí zobrazování pouze dvou desetinných míst

    // Fonty
    Font fontTlacitek = new Font("Consolas", Font.BOLD, 30);
    Font fontAkcii = new Font("Consolas", Font.PLAIN, 30);
    Font fontNadpisu = new Font("Arial", Font.PLAIN, 50);
    Font fontAplikace = new Font("Arial", Font.BOLD, 70);

    // Prvky Swingu
    JFrame okno;
    static JTextArea nabizeneAkcie, vlastneneAkcie, finance;
    JLabel nadpisAplikace, nadpisNabizenych, nadpisVlasnenych;
    JButton[] tlacitkaCas = new JButton[4];
    JButton tlacitkoStop, tlacitkoPomalu, tlacitkoStredne, tlacitkoRychle;
    JButton[] tlacitkaOperace = new JButton[2];
    JButton tlacitkoKoupit, tlacitkoProdat;
    JButton tlacitkoDalsiDen;
    JPanel tlacitkaCasPanel, tlacitkaOperacePanel;

    static PevneFinance pevneFinance;

    Algoritmus algoritmus;

    static Akcie akcieApple;
    static Akcie akcieTesla;
    static Akcie akcieAmazon;
    static Akcie akcieNetflix;
    static Akcie akcieGoogle;
    static Akcie akcieSpaceX;
    static Akcie akcieSamsung;
    static Akcie akcieValve;
    static Akcie akciePMDP;

    // Nastaví grafickou část + základní nastavení objektů
    HlavniOkno() {

        akcieApple = new Akcie("Apple", 1);
        akcieTesla = new Akcie("Tesla", 2);
        akcieAmazon = new Akcie("Amazon", 3);
        akcieNetflix = new Akcie("Netflix", 4);
        akcieGoogle = new Akcie("Google", 5);
        akcieSpaceX = new Akcie("SpaceX", 6);
        akcieSamsung = new Akcie("Samsung", 7);
        akcieValve = new Akcie("Valve", 8);
        akciePMDP = new Akcie("PMDP", 9);

        pevneFinance = new PevneFinance(3000);

        algoritmus = new Algoritmus();

        // Okno aplikace
        okno = new JFrame("Investor");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(1200, 800);
        okno.setLayout(null);
        okno.setLocationRelativeTo(null);
        
        // Nadpisy
        nadpisAplikace = new JLabel("Investor");
        nadpisAplikace.setBounds(440, 0, 270, 100);
        nadpisAplikace.setFont(fontAplikace);

        nadpisNabizenych = new JLabel("Nabízené akcie");
        nadpisNabizenych.setBounds(125, 90, 350, 50);
        nadpisNabizenych.setFont(fontNadpisu);

        nadpisVlasnenych = new JLabel("Vlastněné akcie");
        nadpisVlasnenych.setBounds(670, 90, 360, 50);
        nadpisVlasnenych.setFont(fontNadpisu);

        // Textové pole vlevo
        nabizeneAkcie = new JTextArea();
        nabizeneAkcie.setBounds(50, 150, 500, 375);
        nabizeneAkcie.setFont(fontTlacitek);
        nabizeneAkcie.setEditable(false);
        nabizeneAkcie.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 25));

        // Textové pole vpravo
        vlastneneAkcie = new JTextArea();
        vlastneneAkcie.setBounds(600, 150, 500, 375); //1050
        vlastneneAkcie.setFont(fontTlacitek);
        vlastneneAkcie.setEditable(false);
        vlastneneAkcie.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 25));

        // Tlačítka času
        tlacitkoStop = new JButton("||");
        tlacitkoPomalu = new JButton(">");
        tlacitkoStredne = new JButton(">>");
        tlacitkoRychle = new JButton(">>>");

        tlacitkaCas[0] = tlacitkoStop;
        tlacitkaCas[1] = tlacitkoPomalu;
        tlacitkaCas[2] = tlacitkoStredne;
        tlacitkaCas[3] = tlacitkoRychle;

        for (int i = 0; i < 4; i++) {
            tlacitkaCas[i].addActionListener(this);
            tlacitkaCas[i].setFont(fontTlacitek);
            tlacitkaCas[i].setFocusable(false);
            //tlacitkaCas[i].setBackground(new java.awt.Color(100, 200, 100));
        }

        // Tlačítka akcí
        tlacitkoKoupit = new JButton("Koupit");
        tlacitkoProdat = new JButton("Prodat");

        tlacitkaOperace[0] = tlacitkoKoupit;
        tlacitkaOperace[1] = tlacitkoProdat;

        for (int i = 0; i < 2; i++) {
            tlacitkaOperace[i].addActionListener(this);
            tlacitkaOperace[i].setFont(fontTlacitek);
            tlacitkaOperace[i].setFocusable(false);
            //tlacitkaOperace[i].setBackground(new java.awt.Color(200, 100, 200));
        }

        // Tlačítko dalšího dne
        tlacitkoDalsiDen = new JButton("Další den");
        tlacitkoDalsiDen.addActionListener(this);
        tlacitkoDalsiDen.setFont(fontTlacitek);
        tlacitkoDalsiDen.setFocusable(false);
        tlacitkoDalsiDen.setBounds(50, 620, 245, 50);

        // Grid 1 - levá strana
        tlacitkaCasPanel = new JPanel();
        tlacitkaCasPanel.setBounds(50, 550, 500, 50);
        tlacitkaCasPanel.setLayout(new GridLayout(1, 4, 10, 10));

        tlacitkaCasPanel.add(tlacitkoStop);
        tlacitkaCasPanel.add(tlacitkoPomalu);
        tlacitkaCasPanel.add(tlacitkoStredne);
        tlacitkaCasPanel.add(tlacitkoRychle);

        // Grid 2 - pravá strana
        tlacitkaOperacePanel = new JPanel();
        tlacitkaOperacePanel.setBounds(600, 550, 500, 50);
        tlacitkaOperacePanel.setLayout(new GridLayout(1, 3, 10, 10));

        tlacitkaOperacePanel.add(tlacitkoKoupit);
        tlacitkaOperacePanel.add(tlacitkoProdat);

        // Textové pole dole
        finance = new JTextArea();
        finance.setBounds(600, 620, 500, 50);
        finance.setFont(fontTlacitek);
        finance.setEditable(false);
        finance.setBorder(BorderFactory.createEmptyBorder(10, 40, 5, 5));
        finance.setText("Celkové peníze: " + formatPenez.format(pevneFinance.getHodnota()) + "Kč");

        // Přidání gridů, textových polí a tlačítka nového dne
        okno.add(nadpisAplikace);
        okno.add(nadpisNabizenych);
        okno.add(nadpisVlasnenych);
        okno.add(tlacitkoDalsiDen);
        okno.add(tlacitkaCasPanel);
        okno.add(tlacitkaOperacePanel);
        okno.add(nabizeneAkcie);
        okno.add(vlastneneAkcie);
        okno.add(finance);
        okno.setVisible(true);

        novaCenaAkcii();
        vypsaniNabizenychAkcii();
    }

    public void novaCenaAkcii() {

        algoritmus.novaCena(akcieApple);
        algoritmus.novaCena(akcieTesla);
        algoritmus.novaCena(akcieAmazon);
        algoritmus.novaCena(akcieNetflix);
        algoritmus.novaCena(akcieGoogle);
        algoritmus.novaCena(akcieSpaceX);
        algoritmus.novaCena(akcieSamsung);
        algoritmus.novaCena(akcieValve);
        algoritmus.novaCena(akciePMDP);
    }

    public static void vypsaniNabizenychAkcii() {

        String obsah = "";
        obsah += akcieApple.getJmeno() + "\t(" + akcieApple.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieApple.getAktualniCena()) + "Kč\n";
        obsah += akcieTesla.getJmeno() + "\t(" + akcieTesla.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieTesla.getAktualniCena()) + "Kč\n";
        obsah += akcieAmazon.getJmeno() + "\t(" + akcieAmazon.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieAmazon.getAktualniCena()) + "Kč\n";
        obsah += akcieNetflix.getJmeno() + "\t(" + akcieNetflix.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieNetflix.getAktualniCena()) + "Kč\n";
        obsah += akcieGoogle.getJmeno() + "\t(" + akcieGoogle.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieGoogle.getAktualniCena()) + "Kč\n";
        obsah += akcieSpaceX.getJmeno() + "\t(" + akcieSpaceX.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieSpaceX.getAktualniCena()) + "Kč\n";
        obsah += akcieSamsung.getJmeno() + "\t(" + akcieSamsung.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieSamsung.getAktualniCena()) + "Kč\n";
        obsah += akcieValve.getJmeno() + "\t(" + akcieValve.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akcieValve.getAktualniCena()) + "Kč\n";
        obsah += akciePMDP.getJmeno() + "\t(" + akciePMDP.getNabizeneMnozstvi() + "ks)\t" + formatPenez.format(akciePMDP.getAktualniCena()) + "Kč\n";
        nabizeneAkcie.setText(obsah);
    }

    public static void nakupAkcie(int mnozstvi, int cisloAkcie) {

        switch (cisloAkcie) {

            case 1:
                akcieApple.setNabizeneMnozstvi(akcieApple.getNabizeneMnozstvi() - mnozstvi);
                akcieApple.setVlastneneMnozstvi(akcieApple.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieApple.getAktualniCena() * mnozstvi));
                break;

            case 2:
                akcieTesla.setNabizeneMnozstvi(akcieTesla.getNabizeneMnozstvi() - mnozstvi);
                akcieTesla.setVlastneneMnozstvi(akcieTesla.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieTesla.getAktualniCena() * mnozstvi));
                break;

            case 3:
                akcieAmazon.setNabizeneMnozstvi(akcieAmazon.getNabizeneMnozstvi() - mnozstvi);
                akcieAmazon.setVlastneneMnozstvi(akcieAmazon.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieAmazon.getAktualniCena() * mnozstvi));
                break;

            case 4:
                akcieNetflix.setNabizeneMnozstvi(akcieNetflix.getNabizeneMnozstvi() - mnozstvi);
                akcieNetflix.setVlastneneMnozstvi(akcieNetflix.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieNetflix.getAktualniCena() * mnozstvi));
                break;

            case 5:
                akcieGoogle.setNabizeneMnozstvi(akcieGoogle.getNabizeneMnozstvi() - mnozstvi);
                akcieGoogle.setVlastneneMnozstvi(akcieGoogle.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieGoogle.getAktualniCena() * mnozstvi));
                break;

            case 6:
                akcieSpaceX.setNabizeneMnozstvi(akcieSpaceX.getNabizeneMnozstvi() - mnozstvi);
                akcieSpaceX.setVlastneneMnozstvi(akcieSpaceX.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieSpaceX.getAktualniCena() * mnozstvi));
                break;

            case 7:
                akcieSamsung.setNabizeneMnozstvi(akcieSamsung.getNabizeneMnozstvi() - mnozstvi);
                akcieSamsung.setVlastneneMnozstvi(akcieSamsung.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieSamsung.getAktualniCena() * mnozstvi));
                break;

            case 8:
                akcieValve.setNabizeneMnozstvi(akcieValve.getNabizeneMnozstvi() - mnozstvi);
                akcieValve.setVlastneneMnozstvi(akcieValve.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akcieValve.getAktualniCena() * mnozstvi));
                break;

            case 9:
                akciePMDP.setNabizeneMnozstvi(akciePMDP.getNabizeneMnozstvi() - mnozstvi);
                akciePMDP.setVlastneneMnozstvi(akciePMDP.getVlasneneMnozstvi() + mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() - (akciePMDP.getAktualniCena() * mnozstvi));
                break;
        
            default:
                new Chyba();
                break;
        }

        finance.setText("Celkové peníze: " + formatPenez.format(pevneFinance.getHodnota()) + "Kč");
        vypsaniNabizenychAkcii();
        vypsaniVlasnenychAkcii();
    }

    public static void prodejAkcie(int mnozstvi, int cisloAkcie) {

        switch (cisloAkcie) {

            case 1:
                akcieApple.setNabizeneMnozstvi(akcieApple.getNabizeneMnozstvi() + mnozstvi);
                akcieApple.setVlastneneMnozstvi(akcieApple.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieApple.getAktualniCena() * mnozstvi));
                break;

            case 2:
                akcieTesla.setNabizeneMnozstvi(akcieTesla.getNabizeneMnozstvi() + mnozstvi);
                akcieTesla.setVlastneneMnozstvi(akcieTesla.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieTesla.getAktualniCena() * mnozstvi));
                break;

            case 3:
                akcieAmazon.setNabizeneMnozstvi(akcieAmazon.getNabizeneMnozstvi() + mnozstvi);
                akcieAmazon.setVlastneneMnozstvi(akcieAmazon.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieAmazon.getAktualniCena() * mnozstvi));
                break;

            case 4:
                akcieNetflix.setNabizeneMnozstvi(akcieNetflix.getNabizeneMnozstvi() + mnozstvi);
                akcieNetflix.setVlastneneMnozstvi(akcieNetflix.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieNetflix.getAktualniCena() * mnozstvi));
                break;

            case 5:
                akcieGoogle.setNabizeneMnozstvi(akcieGoogle.getNabizeneMnozstvi() + mnozstvi);
                akcieGoogle.setVlastneneMnozstvi(akcieGoogle.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieGoogle.getAktualniCena() * mnozstvi));
                break;

            case 6:
                akcieSpaceX.setNabizeneMnozstvi(akcieSpaceX.getNabizeneMnozstvi() + mnozstvi);
                akcieSpaceX.setVlastneneMnozstvi(akcieSpaceX.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieSpaceX.getAktualniCena() * mnozstvi));
                break;

            case 7:
                akcieSamsung.setNabizeneMnozstvi(akcieSamsung.getNabizeneMnozstvi() + mnozstvi);
                akcieSamsung.setVlastneneMnozstvi(akcieSamsung.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieSamsung.getAktualniCena() * mnozstvi));
                break;

            case 8:
                akcieValve.setNabizeneMnozstvi(akcieValve.getNabizeneMnozstvi() + mnozstvi);
                akcieValve.setVlastneneMnozstvi(akcieValve.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akcieValve.getAktualniCena() * mnozstvi));
                break;

            case 9:
                akciePMDP.setNabizeneMnozstvi(akciePMDP.getNabizeneMnozstvi() + mnozstvi);
                akciePMDP.setVlastneneMnozstvi(akciePMDP.getVlasneneMnozstvi() - mnozstvi);
                pevneFinance.setHodnota(pevneFinance.getHodnota() + (akciePMDP.getAktualniCena() * mnozstvi));
                break;

            default:
                new Chyba();
                break;
        }
        
        finance.setText("Celkové peníze: " + formatPenez.format(pevneFinance.getHodnota()) + "Kč");
        vypsaniNabizenychAkcii();
        vypsaniVlasnenychAkcii();
    }

    public static void vypsaniVlasnenychAkcii() {
        
        String obsah = "";
        obsah += vypsaniJedneVlasneneAkcie(akcieApple);
        obsah += vypsaniJedneVlasneneAkcie(akcieTesla);
        obsah += vypsaniJedneVlasneneAkcie(akcieAmazon);
        obsah += vypsaniJedneVlasneneAkcie(akcieNetflix);
        obsah += vypsaniJedneVlasneneAkcie(akcieGoogle);
        obsah += vypsaniJedneVlasneneAkcie(akcieSpaceX);
        obsah += vypsaniJedneVlasneneAkcie(akcieSamsung);
        obsah += vypsaniJedneVlasneneAkcie(akcieValve);
        obsah += vypsaniJedneVlasneneAkcie(akciePMDP);
        vlastneneAkcie.setText(obsah);
    }

    public static String vypsaniJedneVlasneneAkcie(Akcie akcie) {

        if (akcie.getVlasneneMnozstvi() != 0) {
            return akcie.getJmeno() + "\t(" + akcie.getVlasneneMnozstvi() + "ks)\t" + formatPenez.format(akcie.getAktualniCena() * akcie.getVlasneneMnozstvi()) + "Kč\n";
        }

        else {
            return "";
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == tlacitkoStop) {
            //TODO
        }

        if (event.getSource() == tlacitkoPomalu) {
            //TODO
        }

        if (event.getSource() == tlacitkoStredne) {
            //TODO
        }

        if (event.getSource() == tlacitkoRychle) {
            //TODO
        }

        if (event.getSource() == tlacitkoKoupit) {
            new Nakup();
        }

        if (event.getSource() == tlacitkoProdat) {
            new Prodej();
        }

        if (event.getSource() == tlacitkoDalsiDen) {
            novaCenaAkcii();
            vypsaniNabizenychAkcii();
            vypsaniVlasnenychAkcii();
        }
    }
}
