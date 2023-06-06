package Investor;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prodej implements ActionListener {

    // Prvky Swingu
    JFrame okno = new JFrame("Prodej");
    JButton tlacitkoProdeje = new JButton("Prodat");
    JLabel textVyber = new JLabel();
    JLabel textMnozstvi = new JLabel();

    SpinnerNumberModel ciselnyModelSpinneru = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner mnozstvi = new JSpinner(ciselnyModelSpinneru);

    String[] moznostiVyberu = { " ", "Apple", "Tesla", "Amazon", "Netflix", "Google", "SpaceX", "Samsung", "Valve", "PMDP" };
    JComboBox<String> vyberAkcii = new JComboBox<>(moznostiVyberu);

    // Font
    Font fontProdeje = new Font("Consolas", Font.BOLD, 30);

    // Nastaví grafickou část
    Prodej() {

        textVyber.setBounds(25, 15, 300, 50);
        textVyber.setFont(fontProdeje);
        textVyber.setText("Vyberte akcii: ");

        vyberAkcii.setBounds(300, 20, 200, 40);
        vyberAkcii.setFont(fontProdeje);

        textMnozstvi.setBounds(25, 100, 350, 50);
        textMnozstvi.setFont(fontProdeje);
        textMnozstvi.setText("Zadejte množství: ");

        mnozstvi.setBounds(350, 100, 150, 35);
        mnozstvi.setFont(fontProdeje);

        tlacitkoProdeje.setBounds(25, 175, 475, 40);
        tlacitkoProdeje.setFont(fontProdeje);
        tlacitkoProdeje.setFocusable(false);
        tlacitkoProdeje.addActionListener(this);

        okno.add(vyberAkcii);
        okno.add(tlacitkoProdeje);
        okno.add(textVyber);
        okno.add(textMnozstvi);
        okno.add(mnozstvi);

        okno.setSize(540, 280);
        okno.setLayout(null);
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == tlacitkoProdeje) {

            HlavniOkno.prodejAkcie((int)mnozstvi.getValue(), vyberAkcii.getSelectedIndex());
            okno.dispose();
        }
    }
}
