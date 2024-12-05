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

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    public EcouteurOperationsCompte(Client client) {
        this.client = client;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            switch (((JButton)source).getActionCommand()) {
                case "EPARGNE":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component)null, "L'operation a echoue");
                    } else {
                        this.client.envoyer("EPARGNE");
                    }
                    break;
                case "DEPOT":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component)null, "Le depot a echoue");
                    } else {
                        //System.out.println(nomAction);
                        final PanneauDepot panneauDepot = new PanneauDepot();
                        panneauDepot.setEcouteur(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double montant = panneauDepot.getDepot();
                                if (montant > 0.0) {
                                    EcouteurOperationsCompte.this.client.envoyer("DEPOT " + montant);
                                }

                            }
                        });
                        JOptionPane.showMessageDialog((Component)null, panneauDepot, "Faire un dépot", 1);
                    }
                    break;
                case "RETRAIT":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component)null, "Le retrait a echoue");
                    } else {
                        //System.out.println(nomAction);
                        final PanneauRetrait panneauRetrait = new PanneauRetrait();
                        panneauRetrait.setEcouteur(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double montant = panneauRetrait.getRetrait();
                                if (montant > 0.0) {
                                    EcouteurOperationsCompte.this.client.envoyer("RETRAIT " + montant);
                                }

                            }
                        });
                        JOptionPane.showMessageDialog((Component)null, panneauRetrait, "Faire un retrait", 1);
                    }
                    break;
                case "TRANSFER":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component)null, "Le transfert a echoue");
                    } else {
                        //System.out.println(nomAction);
                        final PanneauTransfert panneauTransfert = new PanneauTransfert();
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
                        JOptionPane.showMessageDialog((Component)null, panneauTransfert, "Faire un transfer", 1);
                    }
                    break;
                case "FACTURE":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component)null, "La facture a echoue");
                    } else {
                        //System.out.println(nomAction);
                        final PanneauFacture panneauFacture = new PanneauFacture();
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
                        JOptionPane.showMessageDialog((Component)null, panneauFacture, "Payer une facture", 1);
                    }
                    break;
                case "HIST":
                    if (!this.client.isConnecte()) {
                        JOptionPane.showMessageDialog((Component)null, "Demande historique échouée");
                    } else {
                        this.client.envoyer("HIST");
                    }
            }
        }

    }
}
