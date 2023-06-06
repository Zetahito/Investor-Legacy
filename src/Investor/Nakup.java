package Investor;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nakup implements ActionListener {

    // Prvky Swingu
    JFrame okno = new JFrame("Nákup");
    JButton tlacitkoNakupu = new JButton("Koupit");
    JLabel textVyber = new JLabel();
    JLabel textMnozstvi = new JLabel();

    SpinnerNumberModel ciselnyModelSpinneru = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner mnozstvi = new JSpinner(ciselnyModelSpinneru);

    String[] moznostiVyberu = { " ", "Apple", "Tesla", "Amazon", "Netflix", "Google", "SpaceX", "Samsung", "Valve", "PMDP" };
    JComboBox<String> vyberAkcii = new JComboBox<>(moznostiVyberu);

    // Font
    Font fontNakupu = new Font("Consolas", Font.BOLD, 30);

    // Nastaví grafickou část
    Nakup() {

        textVyber.setBounds(25, 15, 300, 50);
        textVyber.setFont(fontNakupu);
        textVyber.setText("Vyberte akcii: ");

        vyberAkcii.setBounds(300, 20, 200, 40);
        vyberAkcii.setFont(fontNakupu);

        textMnozstvi.setBounds(25, 100, 350, 50);
        textMnozstvi.setFont(fontNakupu);
        textMnozstvi.setText("Zadejte množství: ");

        mnozstvi.setBounds(350, 100, 150, 35);
        mnozstvi.setFont(fontNakupu);

        tlacitkoNakupu.setBounds(25, 175, 475, 40);
        tlacitkoNakupu.setFont(fontNakupu);
        tlacitkoNakupu.setFocusable(false);
        tlacitkoNakupu.addActionListener(this);

        okno.add(vyberAkcii);
        okno.add(tlacitkoNakupu);
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

        if (event.getSource() == tlacitkoNakupu) {
            HlavniOkno.nakupAkcie((int)mnozstvi.getValue(), vyberAkcii.getSelectedIndex());
            okno.dispose();
        }
    }
}
