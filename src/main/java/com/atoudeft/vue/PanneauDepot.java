package com.atoudeft.vue;

import javax.swing.*;

/**
 *
 * @author Alejandro Rojas
 *
 */
public class PanneauDepot extends JPanel {
    private JTextField txtDepot;
    private JPanel panneau;

    public PanneauDepot(double montant) {
        panneau = new JPanel();

        txtDepot = new JTextField(String.valueOf(montant), 15);
        JLabel lblDepot = new JLabel("Depot: ");
        lblDepot.setHorizontalAlignment(SwingConstants.RIGHT);

        panneau.add(lblDepot);
        panneau.add(txtDepot);

        add(panneau);

    }
    public double getDepot() { return Double.parseDouble(txtDepot.getText()); }
}