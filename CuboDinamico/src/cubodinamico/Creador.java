/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubodinamico;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author GabeL
 */
public class Creador extends JFrame implements ActionListener {

    JLabel lx, ly, lz;
    JTextField tx, ty, tz;
    JButton b;

    Creador() {
        setSize(300, 300);
        setLayout(null);
        setTitle("Cubo de Datos Dinamico");
        lx = new JLabel("Ancho:");
        ly = new JLabel("Alto:");
        lz = new JLabel("Profundo:");
        tx = new JTextField();
        ty = new JTextField();
        tz = new JTextField();
        b = new JButton("Crear");
        lx.setBounds(10, 10, 70, 40);
        tx.setBounds(90, 10, 40, 40);
        ly.setBounds(10, 60, 70, 40);
        ty.setBounds(90, 60, 40, 40);
        lz.setBounds(10, 110, 70, 40);
        tz.setBounds(90, 110, 40, 40);
        b.setBounds(120, 160, 100, 50);
        this.add(lx);
        this.add(ly);
        this.add(lz);
        this.add(tx);
        this.add(ty);
        this.add(tz);
        this.add(b);
        b.addActionListener(this);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x, y, z;
        x = Integer.parseInt(tx.getText());
        y = Integer.parseInt(ty.getText());
        z = Integer.parseInt(tz.getText());

        VistaCuboDinamico v1 = new VistaCuboDinamico(x, y, z);
        ModeloCuboDinamico m1 = new ModeloCuboDinamico();
        ControlCuboDinamico c1 = new ControlCuboDinamico(v1,m1,x,y,z);
    }

}
