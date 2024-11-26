package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;
    private JPanel panneauServeur;

    //Jiayi Xu
    public PanneauConfigServeur(String adr, int port) {
        panneauServeur = new JPanel();

        txtAdrServeur = new JTextField(adr, 15);
        txtNumPort = new JTextField(String.valueOf(port), 5);

        JLabel lblAdrServeur = new JLabel("Adresse IP: ");
        JLabel lblNumPort = new JLabel("Port: ");

        panneauServeur.add(lblAdrServeur);
        panneauServeur.add(txtAdrServeur);
        panneauServeur.add(lblNumPort);
        panneauServeur.add(txtNumPort);

        this.setLayout(new BorderLayout());
        add(panneauServeur, BorderLayout.CENTER);

    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
