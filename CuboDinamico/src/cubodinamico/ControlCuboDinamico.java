/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubodinamico;

import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

/**
 *
 * @author GabeL
 */
public class ControlCuboDinamico implements ActionListener {

    VistaCuboDinamico v;
    ModeloCuboDinamico m;
    int filas, columnas, dimensiones, A[][][];

    ControlCuboDinamico(VistaCuboDinamico vis, ModeloCuboDinamico mod, int ancho, int alto, int prof) {
        this.v = vis;
        this.m = mod;
        dimensiones = prof;
        filas = ancho;
        columnas = alto;
        //**************************************************************
        A = new int[filas][columnas][dimensiones];
        //**************************************************************
        for (int i = 0; i < dimensiones; i++) {
            v.cambio[i].addActionListener(this);
        }
        //**************************************************************
        for (int i = 0; i < dimensiones; i++) {
            v.cargar[i].addActionListener(this);
        }
        //**************************************************************
        for (int i = 0; i < dimensiones; i++) {
            v.buscar[i].addActionListener(this);
        }
        //**************************************************************
        v.setVisible(true);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);//VALOR = 3
        //System.out.println(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < dimensiones; i++) {
            if (e.getSource() == v.cambio[i]) {
                v.card.next(v.cont);
                m.ImprimeCubo(A);
            }
        }
        //**************************************************************
        for (int i = 0; i < dimensiones; i++) {
            if (e.getSource() == v.buscar[i]) {
                int B[][] = new int[A.length][A[0].length];
                for (int a = 0; a < A.length; a++) {
                    for (int b = 0; b < A[0].length; b++) {
                        B[a][b] = A[a][b][i];
                    }

                }
                int val[] = m.Buscar(B, v.Tx[i]);
                JOptionPane.showMessageDialog(null, "Valor encontrado en [" + val[0] + "][" + val[1] + "][" + i + "]");
            }
        }
        //**************************************************************
        for (int i = 0; i < dimensiones; i++) {
            if (e.getSource() == v.cargar[i]) {
                int B[][] = m.Cargar(v.tablas[i]);
                for (int a = 0; a < A.length; a++) {
                    for (int b = 0; b < A[0].length; b++) {
                        A[a][b][i]=B[a][b];
                    }
                }
            }
        }

    }

}
