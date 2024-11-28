package com.atoudeft.vue;

import javax.swing.*;

public class PanneauRetrait extends JPanel {
    private JTextField txtRetrait;
    private JPanel panneau;

    public PanneauRetrait() {
        panneau = new JPanel();

        txtRetrait = new JTextField(15);
        JLabel lblDepot = new JLabel("Retrait: ");
        lblDepot.setHorizontalAlignment(SwingConstants.RIGHT);

        panneau.add(lblDepot);
        panneau.add(txtRetrait);

        add(panneau);

    }
    public double getDepot() { return Double.parseDouble(txtRetrait.getText()); }
}
