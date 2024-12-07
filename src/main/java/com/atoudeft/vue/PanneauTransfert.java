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
 * Panneau de transfert
 *
 * @author Alejandro Rojas
 * @version 1.0
 * @since 2024-12-06
 */
public class PanneauTransfert extends JPanel {
    private JTextField txtTransfert;
    private JTextField txtNumDestinataire;
    private JTextField txtNumSource;
    private JPanel panneau = new JPanel();
    private JButton btnTransfert;

    /**
     * Constructeur du panneau de transfert
     */
    public PanneauTransfert() {

        this.panneau.setLayout(new GridLayout(3, 2, 5, 5));
        this.txtTransfert = new JTextField(15);
        this.txtNumDestinataire = new JTextField(15);
        this.txtNumSource = new JTextField(15);

        JLabel lblTransfert = new JLabel("Transfert: ");
        lblTransfert.setHorizontalAlignment(4);
        JLabel lblNumDepart = new JLabel("Numero de compte source: ");
        lblNumDepart.setHorizontalAlignment(4);
        JLabel lblNumDesti = new JLabel("Numero de compte destinataire: ");
        lblNumDesti.setHorizontalAlignment(4);

        this.btnTransfert = new JButton("Faire un transfer!");
        this.panneau.add(lblTransfert);
        this.panneau.add(this.txtTransfert);
        this.panneau.add(lblNumDepart);
        this.panneau.add(this.txtNumSource);
        this.panneau.add(lblNumDesti);
        this.panneau.add(this.txtNumDestinataire);

        JPanel panneauBouton = new JPanel();
        panneauBouton.setLayout(new FlowLayout(1));
        panneauBouton.add(this.btnTransfert);
        this.add(this.panneau, "Center");
        this.add(panneauBouton, "South");
    }

    /**
     * Retourne le transfert tout en regardant les cas ou l'utilisateur ne rentre pas un transfert valide
     *
     * @return le transfert en format double
     */
    public double getTransfer() {
        try {
            return Double.parseDouble(this.txtTransfert.getText());
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide", "Erreur", 0);
            return 0.0;
        }
    }

    /**
     * Retourne le num destinataire tout en regardant les cas ou l'utilisateur ne rentre pas un num destinataire
     *
     * @return le numero destinataire
     */
    public String getNumDestinataire() {
        try {
            return this.txtNumDestinataire.getText();
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de compte destinataire valide", "Erreur", 0);
            return null;
        }
    }

    /**
     * Retourne le num destinateur tout en regardant les cas ou l'utilisateur ne rentre pas un numero valide
     *
     * @return le numero destinateur
     */
    public String getNumSource() {
        try {
            return this.txtNumSource.getText();
        } catch (NumberFormatException var2) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de compte destinateur valide", "Erreur", 0);
            return null;
        }
    }

    public void setEcouteur(ActionListener ecouteur) { this.btnTransfert.addActionListener(ecouteur); }
}