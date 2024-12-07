package com.atoudeft.vue;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Panneau du depot
 *
 * @author Alejandro Rojas
 * @version 1.0
 * @since 2024-12-06
 */
public class PanneauDepot extends JPanel {
    private JTextField txtDepot = new JTextField(15);
    private JPanel panneau = new JPanel();
    private JButton btnDepot;

    /**
     * Constructeur du panneau depot
     */
    public PanneauDepot() {
        JLabel lblDepot = new JLabel("Depot: ");
        lblDepot.setHorizontalAlignment(4);
        this.btnDepot = new JButton("Effectuer le dépôt!");
        this.panneau.add(lblDepot);
        this.panneau.add(this.txtDepot);
        this.panneau.add(new JLabel());
        this.panneau.add(this.btnDepot);
        this.add(this.panneau, "Center");
    }

    /**
     * Retourne le depot tout en regardant les cas ou l'utilisateur ne rentre pas un montant valide
     * @return le depot en format double
     */
    public double getDepot() {
        try {
            return Double.parseDouble(this.txtDepot.getText());
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide", "Erreur", 0);
            return 0.0;
        }
    }
    public void setEcouteur(ActionListener ecouteur) { this.btnDepot.addActionListener(ecouteur); }
}