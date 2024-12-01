package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauFacture extends JPanel {
    private JTextField txtMontant, txtNumFacture, txtDescription;
    private JPanel panneau;
    private JButton btnFacture;


    public PanneauFacture() {
        panneau = new JPanel();
        panneau.setLayout(new GridLayout(3, 1, 5, 5));

        txtMontant = new JTextField(10);
        txtNumFacture = new JTextField(10);
        txtDescription = new JTextField(20);

        JLabel lblMontant = new JLabel("Montant: ");
        lblMontant.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel lblNumFacture = new JLabel("Numero de facture: ");
        lblNumFacture.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel lblDescription = new JLabel("Description: ");
        lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);

        panneau.add(lblMontant);
        panneau.add(txtMontant);
        panneau.add(lblNumFacture);
        panneau.add(txtNumFacture);
        panneau.add(lblDescription);
        panneau.add(txtDescription);

        add(panneau, BorderLayout.CENTER);
    }
    public double getMontant(){ return Double.parseDouble(txtMontant.getText()); }
    public String getNumFacture() { return txtNumFacture.getText(); }
    public String getDescription() { return txtDescription.getText(); }
}
