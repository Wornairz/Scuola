/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadratirandom;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author danil
 */
public class QuadratiRandom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension schermo= Toolkit.getDefaultToolkit().getScreenSize();
        JFrame finestra = new JFrame();
        finestra.setSize(schermo);
        GridBagLayout layout=new GridBagLayout();
        finestra.setLayout(layout);
        GridBagConstraints p=new GridBagConstraints();
        
        FoglioDisegno panel=new FoglioDisegno();
        p.gridx=0;
        p.gridy=0;
        p.weightx=1;
        p.weighty=1;
        p.fill= GridBagConstraints.BOTH;
        layout.setConstraints(panel, p);
        finestra.add(panel);
        
        JButton b= new JButton("+");
        b.setPreferredSize(new Dimension(100,50));
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.creaQuadrato();
                }
        });
        
        p.gridx=0;
        p.gridy=0;
        p.weightx=0;
        p.weighty=0;
        p.fill= GridBagConstraints.NONE;
        p.anchor= GridBagConstraints.NORTHWEST;
        layout.setConstraints(b, p);
        finestra.add(b);
        
        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

