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
        JPanel panServeur = new JPanel(new BorderLayout());
        JPanel panPort = new JPanel(new BorderLayout());

        txtAdrServeur = new JTextField(adr, 15);
        txtNumPort = new JTextField(String.valueOf(port), 5);

        JLabel lblAdrServeur = new JLabel("Adresse IP: ");
        JLabel lblNumPort = new JLabel("Port: ");

        panServeur.add(lblAdrServeur, BorderLayout.WEST);
        panServeur.add(txtAdrServeur, BorderLayout.CENTER);

        panPort.add(lblNumPort, BorderLayout.WEST);
        panPort.add(txtNumPort, BorderLayout.CENTER);

        panneau.add(panServeur);
        panneau.add(panPort);

        add(panneau, BorderLayout.CENTER);

    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
