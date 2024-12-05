package com.atoudeft.vue;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alejandro Rojas
 */
public class PanneauFacture extends JPanel {
    private JTextField txtMontant;
    private JTextField txtNumFacture;
    private JTextField txtDescription;
    private JPanel panneau = new JPanel();
    private JButton btnFacture;

    public PanneauFacture() {
        this.panneau.setLayout(new GridLayout(3, 1, 5, 5));
        this.txtMontant = new JTextField(10);
        this.txtNumFacture = new JTextField(10);
        this.txtDescription = new JTextField(20);
        JLabel lblMontant = new JLabel("Montant: ");
        lblMontant.setHorizontalAlignment(4);
        JLabel lblNumFacture = new JLabel("Numero de facture: ");
        lblNumFacture.setHorizontalAlignment(4);
        JLabel lblDescription = new JLabel("Description: ");
        lblDescription.setHorizontalAlignment(4);
        this.btnFacture = new JButton("Payer la facture!");
        this.panneau.add(lblMontant);
        this.panneau.add(this.txtMontant);
        this.panneau.add(lblNumFacture);
        this.panneau.add(this.txtNumFacture);
        this.panneau.add(lblDescription);
        this.panneau.add(this.txtDescription);
        JPanel panneauBouton = new JPanel();
        panneauBouton.setLayout(new FlowLayout(1));
        panneauBouton.add(this.btnFacture);
        this.add(this.panneau, "Center");
        this.add(panneauBouton, "South");
    }

    public double getMontant() {
        try {
            return Double.parseDouble(this.txtMontant.getText());
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide", "Erreur", 0);
            return 0.0;
        }
    }

    public String getNumFacture() {
        try {
            return this.txtNumFacture.getText();
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numero de facture valide", "Erreur", 0);
            return null;
        }
    }

    public String getDescription() {
        try {
            return this.txtDescription.getText();
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer une description valide", "Erreur", 0);
            return null;
        }
    }

    public void setEcouteur(ActionListener ecouteur) {
        this.btnFacture.addActionListener(ecouteur);
    }
}