package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur des operations de compte
 *
 * @author Alejandro Rojas
 * @version 1.0
 * @since 2024-12-06
 */
public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private PanneauPrincipal panneauPrincipal;

    /**
     * Constructeur de l'ecouteur des operations de compte
     *
     * @param client           Le client pour lequel les operations sont gerees
     * @param panneauPrincipal Le panneau principal, permettant d'interagir avec celui-ci
     */
    public EcouteurOperationsCompte(Client client, PanneauPrincipal panneauPrincipal) {
        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
    }

    /**
     * Gere les actions declenchees sur les boutons des operations de compte
     * (CONNECTER, DECONNECTER, CONFIGURER, QUITTER)
     *
     * @param e Evenement declenche par l'utilisateur lorsqu'il interagit avec les operations de compte
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            switch (((JButton) source).getActionCommand()) {
                //Jiayi Xu
                //2.2 gerer le clic sur le bouton
                case "EPARGNE":
                    this.client.envoyer("EPARGNE");
                    break;
                case "DEPOT":
                    panneauPrincipal.getPanneauCentral().afficherDepot(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            double montant = panneauPrincipal.getPanneauCentral().getMontantDepot();
                            if (montant > 0.0) {
                                client.envoyer("DEPOT " + montant);
                                System.out.println("DEPOT " + montant);
                            }
                            panneauPrincipal.getPanneauCentral().afficherVide();
                        }
                    });
                    break;
                case "RETRAIT":
                    panneauPrincipal.getPanneauCentral().afficherRetrait(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            double montant = panneauPrincipal.getPanneauCentral().getMontantRetrait();
                            if (montant > 0.0) {
                                client.envoyer("RETRAIT " + montant);
                            }
                            panneauPrincipal.getPanneauCentral().afficherVide();
                        }
                    });
                    break;
                case "TRANSFER":
                    panneauPrincipal.getPanneauCentral().afficherTransfert(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            double montant = panneauPrincipal.getPanneauCentral().getMontantTransfert();
                            String numDestinataire = panneauPrincipal.getPanneauCentral().getNumDestinataireTransfert();
                            if (montant > 0.0 && numDestinataire != null && !numDestinataire.isEmpty()) {
                                client.envoyer("TRANSFER " + montant + " " + numDestinataire);
                            }
                            panneauPrincipal.getPanneauCentral().afficherVide();
                        }
                    });
                    break;
                case "FACTURE":
                    panneauPrincipal.getPanneauCentral().afficherFacture(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            double montant = panneauPrincipal.getPanneauCentral().getMontantFacture();
                            String numFacture = panneauPrincipal.getPanneauCentral().getNumFacture();
                            String description = panneauPrincipal.getPanneauCentral().getDescriptionFacture();
                            if (montant > 0.0 && numFacture != null && !numFacture.isEmpty()
                                    && description != null && !description.isEmpty()) {
                                client.envoyer("FACTURE " + montant + " " + numFacture + " " + description);
                            }
                            panneauPrincipal.getPanneauCentral().afficherVide();
                        }
                    });
                    break;
                //5.1
                case "HIST":
                    this.client.envoyer("HIST");
            }
        }
    }
}