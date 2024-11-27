package com.atoudeft.vue;

import javax.swing.*;

public class PanneauRetrait extends JPanel {
    private JTextField txtRetrait;
    private JPanel panneau;

    public PanneauRetrait(double montant) {
        panneau = new JPanel();

        txtRetrait = new JTextField(String.valueOf(montant), 15);
        JLabel lblDepot = new JLabel("Retrait: ");
        lblDepot.setHorizontalAlignment(SwingConstants.RIGHT);

        panneau.add(lblDepot);
        panneau.add(txtRetrait);

        add(panneau);

    }
    public double getDepot() { return Double.parseDouble(txtRetrait.getText()); }
}
