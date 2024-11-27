package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauOperationsCompte;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;
    private PanneauOperationsCompte panOpCompte;

    public EcouteurListeComptes(Client client, PanneauOperationsCompte panOpCompte) {
        this.client = client;
        this.panOpCompte = panOpCompte;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
       Object source = evt.getSource();
        JList liste = (JList) source;
        String action;
        if (evt.getClickCount() == 2) {
            if (source instanceof JList) {
                action = (String) ((JList) source).getSelectedValue();

                if (action != null) {
                    client.envoyer("SELECT " + action);
                    System.out.println("Select envoye avec " + action);
                }
            }
        }
        //à compléter
    }
}
