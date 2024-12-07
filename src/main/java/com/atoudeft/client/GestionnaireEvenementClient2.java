package com.atoudeft.client;

import com.atoudeft.commun.evenement.Evenement;
import com.atoudeft.commun.evenement.GestionnaireEvenement;
import com.atoudeft.commun.net.Connexion;
import com.atoudeft.vue.PanneauPrincipal;
import com.programmes.MainFrame;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Cette classe représente un gestionnaire d'événement d'un client. Lorsqu'un client reçoit un texte d'un serveur,
 * il crée un événement à partir du texte reçu et alerte ce gestionnaire qui réagit en gérant l'événement.
 *
 * @author Jiayi Xu
 * @author Alejandro Rojas
 * @version 1.0
 * @since 2024-12-06
 */
public class GestionnaireEvenementClient2 implements GestionnaireEvenement {
    private Client client;
    private PanneauPrincipal panneauPrincipal;

    /**
     * Construit un gestionnaire d'événements pour un client.
     *
     * @param client Le client pour lequel ce gestionnaire gère des événements
     * @param panneauPrincipal Le panneau principal de l'interface utilisateur
     */
    public GestionnaireEvenementClient2(Client client, PanneauPrincipal panneauPrincipal) {
        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
        this.client.setGestionnaireEvenement(this);
    }

    /**
     * Traite les evenements reçus par le client
     * (END, HIST, OK, NOUVEAU, CONNECT, EPARGNE, SELECT, DEPOT, RETRAIT, FACTURE, TRANSFER)
     *
     * @param evenement L'evenement recu par le client
     */
    public void traiter(Evenement evenement) {
        Object source = evenement.getSource();
        if (source instanceof Connexion) {
            String arg;
            String str;
            String[] t;
            String solde;
            switch (evenement.getType()) {
                case "END":
                    this.client.deconnecter();
                    break;
                //Alejandro Rojas
                case "HIST":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Historique refusé");
                    } else {
                        JTextArea txt = new JTextArea(arg);
                        txt.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(txt);
                        scrollPane.setPreferredSize(new Dimension(400, 300));
                        JOptionPane.showMessageDialog(this.panneauPrincipal, scrollPane, "Historique des opérations", 1);
                    }
                    break;
                case "OK":
                    this.panneauPrincipal.setVisible(true);
                    MainFrame fenetre = (MainFrame)this.panneauPrincipal.getTopLevelAncestor();
                    fenetre.setTitle("BankEts - Client");
                    break;
                case "NOUVEAU":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Nouveau refusé");
                    } else {
                        this.panneauPrincipal.cacherPanneauConnexion();
                        this.panneauPrincipal.montrerPanneauCompteClient();
                        str = arg.substring(arg.indexOf("OK") + 2).trim();
                        this.panneauPrincipal.ajouterCompte(str);
                    }
                    break;
                case "CONNECT":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Connexion refusée");
                        break;
                    } else {
                        this.panneauPrincipal.cacherPanneauConnexion();
                        this.panneauPrincipal.montrerPanneauCompteClient();
                        str = arg.substring(arg.indexOf("OK") + 2).trim();
                        t = str.split(":");
                        String[] var16 = t;
                        int var12 = t.length;

                        for(int var13 = 0; var13 < var12; ++var13) {
                            String s = var16[var13];
                            this.panneauPrincipal.ajouterCompte(s.substring(0, s.indexOf("]") + 1));
                        }

                        return;
                    }
                //Jiayi Xu
                case "EPARGNE":
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(this.panneauPrincipal, "EPARGNE " + arg);
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Vous possèdez déjà un compte épargne.");
                    } else {
                        str = arg.substring(arg.indexOf("OK") + 2).trim();
                        this.panneauPrincipal.ajouterCompte(str);
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Compte epargne créé avec succès");
                    }
                    break;
                //Jiayi Xu
                case "SELECT":
                    arg = evenement.getArgument();
                    System.out.println("Réponse du serveur reçue: " + arg);
                    JOptionPane.showMessageDialog(this.panneauPrincipal, "SELECT " + arg);
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Selection refusée");
                    } else if (arg.trim().startsWith("OK")) {
                        t = arg.split(" ");
                        solde = t[2];
                        this.panneauPrincipal.getPanneauOperationsCompte().setSolde(solde);
                    }
                    break;
                //Alejandro Rojas
                case "DEPOT":
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(this.panneauPrincipal, "DEPOT " + arg);
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Depot refusé");
                    } else if (arg.trim().startsWith("OK")) {
                        t = arg.split(" ");
                        solde = t[1];
                        this.panneauPrincipal.getPanneauOperationsCompte().setSolde(solde);
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Depot effectué avec succès. \nNouveau solde: " + solde);
                    }
                    break;
                //Alejandro Rojas
                case "RETRAIT":
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(this.panneauPrincipal, "RETRAIT " + arg);
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Retrait refusé");
                    } else if (arg.trim().startsWith("OK")) {
                        t = arg.split(" ");
                        solde = t[1];
                        this.panneauPrincipal.getPanneauOperationsCompte().setSolde(solde);
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Retrait effectué avec succès. \nNouveau solde: " + solde);
                    }
                    break;
                //Alejandro Rojas
                case "FACTURE":
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(this.panneauPrincipal, "FACTURE" + arg);
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Facture refusée");
                    } else if (arg.trim().startsWith("OK")) {
                        t = arg.split(" ");
                        solde = t[1];
                        this.panneauPrincipal.getPanneauOperationsCompte().setSolde(solde);
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Facture payée avec succès. \nNouveau solde: " + solde);
                    }
                    break;
                //Alejandro Rojas
                case "TRANSFER":
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(this.panneauPrincipal, "TRANSFER " + arg);
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Transfer refusé");
                    } else if (arg.trim().startsWith("OK")) {
                        t = arg.split(" ");
                        solde = t[1];
                        this.panneauPrincipal.getPanneauOperationsCompte().setSolde(solde);
                        JOptionPane.showMessageDialog(this.panneauPrincipal, "Transfer effectué avec succès. \nNouveau solde: " + solde);
                    }
                    break;
                default:
                    System.out.println("RECU : " + evenement.getType() + " " + evenement.getArgument());
            }
        }
    }
}
