package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauDepot;
import com.atoudeft.vue.PanneauFacture;
import com.atoudeft.vue.PanneauRetrait;
import com.atoudeft.vue.PanneauTransfert;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Ecouteur des operations de compte
 *
 * @author Alejandro Rojas
 * @version 1.0
 * @since 2024-12-06
 */
public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    /**
     * Constructeur de l'ecouteur des operations de compte
     *
     * @param client  Le client pour lequel les operations sont gerees
     */
    public EcouteurOperationsCompte(Client client) {
        this.client = client;
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
                case "EPARGNE":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component) null, "L'operation a echoue");
                    } else {
                        this.client.envoyer("EPARGNE");
                    }
                    break;
                case "DEPOT":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component) null, "Le depot a echoue");
                    } else {
                        PanneauDepot panneauDepot = new PanneauDepot();
                        panneauDepot.setEcouteur(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double montant = panneauDepot.getDepot();
                                if (montant > 0.0) {
                                    EcouteurOperationsCompte.this.client.envoyer("DEPOT " + montant);
                                }

                            }
                        });
                        JOptionPane.showMessageDialog((Component) null, panneauDepot, "Faire un dépot", 1);
                    }
                    break;
                case "RETRAIT":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component) null, "Le retrait a echoue");
                    } else {
                        PanneauRetrait panneauRetrait = new PanneauRetrait();
                        panneauRetrait.setEcouteur(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double montant = panneauRetrait.getRetrait();
                                if (montant > 0.0) {
                                    EcouteurOperationsCompte.this.client.envoyer("RETRAIT " + montant);
                                }

                            }
                        });
                        JOptionPane.showMessageDialog((Component) null, panneauRetrait, "Faire un retrait", 1);
                    }
                    break;
                case "TRANSFER":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component) null, "Le transfert a echoue");
                    } else {
                        PanneauTransfert panneauTransfert = new PanneauTransfert();
                        panneauTransfert.setEcouteur(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double montant = panneauTransfert.getTransfer();
                                String numDestinateur = panneauTransfert.getNumDestinateur();
                                String numDestinataire = panneauTransfert.getNumDestinataire();
                                if (montant > 0.0 && numDestinataire != null) {
                                    EcouteurOperationsCompte.this.client.envoyer("TRANSFER " + montant + " " + numDestinateur + " " + numDestinataire);
                                }

                            }
                        });
                        JOptionPane.showMessageDialog((Component) null, panneauTransfert, "Faire un transfer", 1);
                    }
                    break;
                case "FACTURE":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component) null, "La facture a echoue");
                    } else {
                        PanneauFacture panneauFacture = new PanneauFacture();
                        panneauFacture.setEcouteur(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double montant = panneauFacture.getMontant();
                                String numFacture = panneauFacture.getNumFacture();
                                String description = panneauFacture.getDescription();
                                if (montant > 0.0 && numFacture != null && description != null) {
                                    EcouteurOperationsCompte.this.client.envoyer("FACTURE " + montant + " " + numFacture + " " + description);
                                }
                            }
                        });
                        JOptionPane.showMessageDialog((Component) null, panneauFacture, "Payer une facture", 1);
                    }
                    break;
                case "HIST":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component) null, "Demande historique échouée");
                    } else {
                        this.client.envoyer("HIST");
                    }
            }
        }
    }
}