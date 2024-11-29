package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauTransfert extends JPanel {
    private JTextField txtTransfert, txtNumDestinataire;
    private JPanel panneau;
    private JButton btnTransfert;

    public PanneauTransfert() {
        panneau = new JPanel();
        panneau.setLayout(new GridLayout(2, 1, 5, 5));

        txtTransfert = new JTextField(15);
        txtNumDestinataire = new JTextField(15);

        JLabel lblTransfert = new JLabel("Transfert: ");
        lblTransfert.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel lblNumDesti = new JLabel("Numero de compte destinataire: ");
        lblNumDesti.setHorizontalAlignment(SwingConstants.RIGHT);

        panneau.add(lblTransfert);
        panneau.add(txtTransfert);
        panneau.add(lblNumDesti);
        panneau.add(txtNumDestinataire);

        add(panneau, BorderLayout.CENTER);

    }
}
