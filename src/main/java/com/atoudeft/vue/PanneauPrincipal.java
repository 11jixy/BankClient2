package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JPanel;


public class PanneauPrincipal extends JPanel {
    private Client client;
    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;
    private PanneauOperationsCompte panneauOperationsCompte;
    private PanneauCentral panneauCentral;
    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JDesktopPane bureau;

    public PanneauPrincipal(Client client) {
        this.client = client;

        this.panneauCentral = new PanneauCentral();

        //2.1
        EcouteurOperationsCompte opComte = new EcouteurOperationsCompte(client, this);

        this.panneauConnexion = new PanneauConnexion();
        this.panneauConnexion.setEcouteur(new EcouteurConnexion(client, this.panneauConnexion));

        this.panneauOperationsCompte = new PanneauOperationsCompte();
        //2.1
        this.panneauOperationsCompte.setEcouteur(opComte);

        this.panneauCompteClient = new JPanel();
        this.panneauCompteClient.setLayout(new BorderLayout());
        this.panneauCompteClient.setBackground(Color.WHITE);
        this.panneauOperationsCompte.setBackground(Color.WHITE);

        this.numerosComptes = new DefaultListModel();
        this.jlNumerosComptes = new JList(this.numerosComptes);
        this.jlNumerosComptes.setSelectionMode(0);
        this.jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        this.jlNumerosComptes.setPreferredSize(new Dimension(250, 500));

        this.panneauCompteClient.add(this.panneauOperationsCompte, "North");
        this.panneauCompteClient.add(this.jlNumerosComptes, "West");
        this.panneauCompteClient.add(this.panneauCentral, BorderLayout.CENTER);

        this.jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client, this.panneauOperationsCompte));
        this.setLayout(new BorderLayout());
        this.add(this.panneauConnexion, "North");
        this.add(this.panneauCompteClient, "Center");

        this.panneauCompteClient.setVisible(false);
    }

    public void vider() {
        this.numerosComptes.clear();
        this.bureau.removeAll();
    }

    public void cacherPanneauConnexion() {
        this.panneauConnexion.effacer();
        this.panneauConnexion.setVisible(false);
    }

    public void montrerPanneauConnexion() {
        this.panneauConnexion.setVisible(true);
    }

    public void cacherPanneauCompteClient() {
        this.panneauCompteClient.setVisible(false);
        this.numerosComptes.clear();
    }

    public void montrerPanneauCompteClient() {
        this.panneauCompteClient.setVisible(true);
    }

    public void ajouterCompte(String str) {
        this.numerosComptes.addElement(str);
    }

    public PanneauOperationsCompte getPanneauOperationsCompte() { return this.panneauOperationsCompte; }
    public PanneauCentral getPanneauCentral() { return this.panneauCentral; }

}