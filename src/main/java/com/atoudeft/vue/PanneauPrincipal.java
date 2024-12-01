package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class PanneauPrincipal  extends JPanel {
    private Client client;
    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;
    private PanneauOperationsCompte panneauOperationsCompte;

    private PanneauDepot panneauDepot;
    private PanneauRetrait panneauRetrait;
    private PanneauFacture panneauFacture;
    private PanneauTransfert panneauTransfert;

    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JDesktopPane bureau;


    public PanneauPrincipal(Client client) {
        this.client = client;
        EcouteurOperationsCompte opComte = new EcouteurOperationsCompte(client);

        panneauConnexion = new PanneauConnexion();
        panneauConnexion.setEcouteur(new EcouteurConnexion(client,panneauConnexion));

        panneauDepot = new PanneauDepot();
        panneauFacture = new PanneauFacture();
        panneauRetrait = new PanneauRetrait();
        panneauTransfert = new PanneauTransfert();

        panneauOperationsCompte = new PanneauOperationsCompte();
        panneauOperationsCompte.setEcouteur(opComte);

        panneauCompteClient = new JPanel();
        panneauCompteClient.setLayout(new BorderLayout());
        panneauCompteClient.setBackground(Color.WHITE);
        panneauOperationsCompte.setBackground(Color.WHITE);

        numerosComptes = new DefaultListModel<>();

        jlNumerosComptes = new JList<>(numerosComptes);
        jlNumerosComptes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        jlNumerosComptes.setPreferredSize(new Dimension(250,500));


        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(jlNumerosComptes, BorderLayout.WEST);
        //Enregistrement de l'écouteur de souris:
        jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client, panneauOperationsCompte));

        this.setLayout(new BorderLayout());

        this.add(panneauConnexion, BorderLayout.NORTH);
        this.add(panneauCompteClient, BorderLayout.CENTER);
        panneauCompteClient.setVisible(false);
        panneauTransfert.setVisible(false);
        panneauFacture.setVisible(false);
        panneauDepot.setVisible(false);
        panneauRetrait.setVisible(false);
    }

    //Jiayi Xu
    public PanneauOperationsCompte getPanneauOperationsCompte() {
        return this.panneauOperationsCompte;
    }

    /**
     * Vide les éléments d'interface du panneauPrincipal.
     */
    public void vider() {
        this.numerosComptes.clear();
        this.bureau.removeAll();
    }
    public void cacherPanneauConnexion() {
        panneauConnexion.effacer();
        panneauConnexion.setVisible(false);
    }
    public void montrerPanneauConnexion() {
        panneauConnexion.setVisible(true);
    }
    public void cacherPanneauCompteClient() {
        panneauCompteClient.setVisible(false);
        this.numerosComptes.clear();
    }
    public void montrerPanneauCompteClient() {
        panneauCompteClient.setVisible(true);
    }
    /**
     * Affiche un numéro de compte dans le JList des comptes.
     *
     * @param str chaine contenant le numéros de compte
     */
    public void ajouterCompte(String str) {
        numerosComptes.addElement(str);
    }

    //Alejandro
    public void montrerPanneaux(String panneau) {
        panneauTransfert.setVisible(false);
        panneauFacture.setVisible(false);
        panneauDepot.setVisible(false);
        panneauRetrait.setVisible(false);

        switch (panneau) {
            case "DEPOT":
                panneauDepot.setVisible(true);
                break;
            case "RETRAIT":
                panneauRetrait.setVisible(true);
                break;
            case "TRANSFER":
                panneauTransfert.setVisible(true);
                break;
            case "FACTURE":
                panneauFacture.setVisible(true);
                break;
        }
    }
}