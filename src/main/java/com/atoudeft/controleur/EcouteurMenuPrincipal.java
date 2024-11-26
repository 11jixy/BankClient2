package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauConfigServeur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class EcouteurMenuPrincipal implements ActionListener {
    private Client client;
    private JFrame fenetre;

    public EcouteurMenuPrincipal(Client client, JFrame fenetre) {
        this.client = client;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String action;
        String alias;
        int res;

        if (source instanceof JMenuItem) {
            action = ((JMenuItem)source).getActionCommand();
            switch (action) {
                case "CONNECTER":
                    if (!client.isConnecte()) {
                        if (!client.connecter()) {
                            JOptionPane.showMessageDialog(fenetre, "Le serveur ne répond pas");
                            break;
                        }
                    }
                    break;
                case "DECONNECTER":
                    if (!client.isConnecte())
                        break;
                    res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                            "Confirmation Déconnecter",
                            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                    if (res == JOptionPane.OK_OPTION){
                        client.deconnecter();
                    }
                    break;
                    //Jiayi Xu
                case "CONFIGURER":
                    //TODO : compléter (question 1.3)
                    boolean estValide = false;
                    String adresse = client.getAdrServeur();
                    int port = client.getPortServeur();

                    while (!estValide) {
                        PanneauConfigServeur panneauConfigServeur = new PanneauConfigServeur(adresse, port);

                        res = JOptionPane.showConfirmDialog(fenetre, panneauConfigServeur, "Configuration serveur",
                                JOptionPane.OK_OPTION);
                        if (res == JOptionPane.OK_OPTION) {
                            try {

                                String adresseEntree = panneauConfigServeur.getAdresseServeur();
                                int portEntre = Integer.parseInt(panneauConfigServeur.getPortServeur());

                                client.setAdrServeur(adresseEntree);
                                client.setPortServeur(portEntre);

                                estValide = true;
                            } catch (NumberFormatException num) {
                                JOptionPane.showMessageDialog(fenetre, "Le numero de port etre un entier valide!",
                                        "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            estValide = true;
                        }

                    }

                    break;
                case "QUITTER":
                    if (client.isConnecte()) {
                        res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                                "Confirmation Quitter",
                                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                        if (res == JOptionPane.OK_OPTION){
                            client.deconnecter();
                            System.exit(0);
                        }
                    }
                    else
                        System.exit(0);
                    break;
            }
        }
    }
}