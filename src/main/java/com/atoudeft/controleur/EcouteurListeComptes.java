package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauOperationsCompte;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Ecouteur de la liste des comptes pour gerer les clics sur les comptes dans l'interface
 *
 * @author Jiayi Xu
 * @version 1.0
 * @since 2024-12-6
 */
public class EcouteurListeComptes extends MouseAdapter {
    private Client client;
    private PanneauOperationsCompte panOpCompte;

    /**
     * Constructeur de l'ecouteur de la liste des comptes
     *
     * @param client      Le client pour lequel les operations sont gerees
     * @param panOpCompte Le panneauOperationsCompte, permettant d'interagir avec celui-ci
     */
    public EcouteurListeComptes(Client client, PanneauOperationsCompte panOpCompte) {
        this.client = client;
        this.panOpCompte = panOpCompte;
    }

    /**
     * Gere l'evenement de clic sur la liste des comptes
     *
     * @param evt L'evemenent de la souris
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
       Object source = evt.getSource();
        JList liste = (JList) source;
        String action;
        //si double-clique
        if (evt.getClickCount() == 2) {
            if (source instanceof JList) {
                action = (String) ((JList) source).getSelectedValue();
                if (action != null) {
                    if (action.contains("EPARGNE")) {
                        client.envoyer("SELECT epargne");
                    } else if (action.contains("CHEQUE")) {
                        client.envoyer("SELECT cheque");
                    }
                }
            }
        }
    }
}