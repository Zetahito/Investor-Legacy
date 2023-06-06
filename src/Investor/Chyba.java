package Investor;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chyba implements ActionListener {

    // Prvky Swingu
    JFrame okno = new JFrame("Chyba");
    JLabel chybovaHlaska = new JLabel();
    JButton tlacitkoOk = new JButton("Ok");

    // Font
    Font fontChyboveHlasky = new Font("Consolas", Font.BOLD, 30);

    // Nastaví grafickou část
    Chyba() {

        chybovaHlaska.setBounds(25, 15, 500, 50);
        chybovaHlaska.setFont(fontChyboveHlasky);
        chybovaHlaska.setText("Nevybrali jste žádnou akcii!");
        chybovaHlaska.setForeground(Color.RED);

        tlacitkoOk.setBounds(25, 80, 475, 40);
        tlacitkoOk.setFont(fontChyboveHlasky);
        tlacitkoOk.setFocusable(false);
        tlacitkoOk.addActionListener(this);

        okno.add(chybovaHlaska);
        okno.add(tlacitkoOk);

        okno.setSize(540, 180);
        okno.setLayout(null);
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        if (event.getSource() == tlacitkoOk) {
            okno.dispose();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    
}
