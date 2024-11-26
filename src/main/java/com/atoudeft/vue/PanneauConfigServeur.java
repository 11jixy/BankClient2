package com.atoudeft.vue;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;
    private JPanel panneau;

    //Jiayi Xu
    public PanneauConfigServeur(String adr, int port) {
        panneau = new JPanel();
        panneau.setLayout(new GridLayout(2, 1, 5, 5));

        txtAdrServeur = new JTextField(adr, 15);
        txtNumPort = new JTextField(String.valueOf(port), 5);

        JLabel lblAdrServeur = new JLabel("Adresse IP: ");
        lblAdrServeur.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel lblNumPort = new JLabel("Port: ");
        lblNumPort.setHorizontalAlignment(SwingConstants.RIGHT);

        panneau.add(lblAdrServeur);
        panneau.add(txtAdrServeur);
        panneau.add(lblNumPort);
        panneau.add(txtNumPort);

        add(panneau, BorderLayout.CENTER);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
