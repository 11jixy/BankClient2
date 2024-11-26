package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    public EcouteurOperationsCompte(Client client) {
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String nomAction;
        if (source instanceof JButton) {
            nomAction = ((JButton) source).getActionCommand();
            switch (nomAction) {
                case "EPARGNE":
                    if (!client.isConnecte()) {
                        JOptionPane.showMessageDialog(null, "L'operation a echoue");
                    } else {
                        client.envoyer("EPARGNE");
                    }
                    break;
            }
        }
        //à compléter :

    }
}
