package com.atoudeft.vue;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanneauRetrait extends JPanel {
    private JTextField txtRetrait = new JTextField(15);
    private JPanel panneau = new JPanel();
    private JButton btnRetrait;

    public PanneauRetrait() {
        JLabel lblDepot = new JLabel("Retrait: ");
        lblDepot.setHorizontalAlignment(4);
        this.btnRetrait = new JButton("Faire un retrait!");
        this.panneau.add(lblDepot);
        this.panneau.add(this.txtRetrait);
        this.panneau.add(new JLabel());
        this.panneau.add(this.btnRetrait);
        this.add(this.panneau);
    }

    public double getRetrait() {
        try {
            return Double.parseDouble(this.txtRetrait.getText());
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide", "Erreur", 0);
            return 0.0;
        }
    }

    public void setEcouteur(ActionListener ecouteur) {
        this.btnRetrait.addActionListener(ecouteur);
    }
}