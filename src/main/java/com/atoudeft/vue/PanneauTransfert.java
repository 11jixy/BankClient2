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
public class PanneauTransfert extends JPanel {
    private JTextField txtTransfert;
    private JTextField txtNumDestinataire;
    private JTextField txtNumDestinateur;
    private JPanel panneau = new JPanel();
    private JButton btnTransfert;

    public PanneauTransfert() {
        this.panneau.setLayout(new GridLayout(3, 2, 5, 5));
        this.txtTransfert = new JTextField(15);
        this.txtNumDestinataire = new JTextField(15);
        this.txtNumDestinateur = new JTextField(15);
        JLabel lblTransfert = new JLabel("Transfert: ");
        lblTransfert.setHorizontalAlignment(4);
        JLabel lblNumDepart = new JLabel("Numero de compte destinateur: ");
        lblNumDepart.setHorizontalAlignment(4);
        JLabel lblNumDesti = new JLabel("Numero de compte destinataire: ");
        lblNumDesti.setHorizontalAlignment(4);
        this.btnTransfert = new JButton("Faire un transfer!");
        this.panneau.add(lblTransfert);
        this.panneau.add(this.txtTransfert);
        this.panneau.add(lblNumDepart);
        this.panneau.add(this.txtNumDestinateur);
        this.panneau.add(lblNumDesti);
        this.panneau.add(this.txtNumDestinataire);
        JPanel panneauBouton = new JPanel();
        panneauBouton.setLayout(new FlowLayout(1));
        panneauBouton.add(this.btnTransfert);
        this.add(this.panneau, "Center");
        this.add(panneauBouton, "South");
    }

    public double getTransfer() {
        try {
            return Double.parseDouble(this.txtTransfert.getText());
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide", "Erreur", 0);
            return 0.0;
        }
    }

    public String getNumDestinataire() {
        try {
            return this.txtNumDestinataire.getText();
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de compte destinataire valide", "Erreur", 0);
            return null;
        }
    }

    public String getNumDestinateur() {
        try {
            return this.txtNumDestinateur.getText();
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de compte destinateur valide", "Erreur", 0);
            return null;
        }
    }

    public void setEcouteur(ActionListener ecouteur) {
        this.btnTransfert.addActionListener(ecouteur);
    }
}