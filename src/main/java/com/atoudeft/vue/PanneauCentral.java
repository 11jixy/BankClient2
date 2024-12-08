package com.atoudeft.vue;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Voici le panneau central qui permet d'afficher ou de retirer les differents panneaux (depot, retrait, transfert, facture)
 * dans le panneau principal
 * Question 4: Operations bancaires
 *
 * @author Alejandro Rojas
 * @version 2.0
 * @since 2024-12-07
 */
public class PanneauCentral extends JPanel {
    private PanneauDepot panneauDepot;
    private PanneauRetrait panneauRetrait;
    private PanneauFacture panneauFacture;
    private PanneauTransfert panneauTransfert;

    /**
     * Constructeur du panneau central
     */
    public PanneauCentral() {
        this.setLayout(new BorderLayout());

        panneauDepot = new PanneauDepot();
        panneauRetrait = new PanneauRetrait();
        panneauFacture = new PanneauFacture();
        panneauTransfert = new PanneauTransfert();
    }

    /**
     * Affiche le panneau de depot
     *
     * @param ecouteurValid Ecouteur associe au bouton du depot
     */
    public void afficherDepot(ActionListener ecouteurValid) {
        removeAll();
        panneauDepot.setEcouteur(ecouteurValid);
        add(panneauDepot, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Affiche le panneau de retrait
     *
     * @param ecouteurValid Ecouteur associe au bouton de retrait
     */
    public void afficherRetrait(ActionListener ecouteurValid) {
        removeAll();
        panneauRetrait.setEcouteur(ecouteurValid);
        add(panneauRetrait, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Affiche le panneau de facture
     *
     * @param ecouteurValid Ecouteur associe au bouton de facture
     */
    public void afficherFacture(ActionListener ecouteurValid) {
        removeAll();
        panneauFacture.setEcouteur(ecouteurValid);
        add(panneauFacture, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Affiche le panneau de transfert
     *
     * @param ecouteurValid Ecouteur associe au bouton du transfert
     */
    public void afficherTransfert(ActionListener ecouteurValid) {
        removeAll();
        panneauTransfert.setEcouteur(ecouteurValid);
        add(panneauTransfert, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Affiche un vide
     */
    public void afficherVide() {
        removeAll();
        revalidate();
        repaint();
    }

    //Getters des panneaux
    public double getMontantDepot() { return panneauDepot.getDepot(); }
    public double getMontantRetrait() { return panneauRetrait.getRetrait(); }
    public double getMontantFacture() { return panneauFacture.getMontant(); }
    public String getNumFacture() { return panneauFacture.getNumFacture(); }
    public String getDescriptionFacture() { return panneauFacture.getDescription(); }
    public double getMontantTransfert() { return panneauTransfert.getTransfer(); }
    public String getNumDestinataireTransfert() { return panneauTransfert.getNumDestinataire();}
}
