/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubodinamico;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author GabeL
 */
public class VistaCuboDinamico extends JFrame {

    JTextField Tx[];
    JTable tablas[];
    JButton buscar[], cargar[], cambio[];
    JPanel panelppal[];
    JScrollPane paneltabla[];
    Container cont;
    JLabel[] Lcara;
    CardLayout card;

    private int x, y, z;

    VistaCuboDinamico(int a, int b, int c) {
        this.x = a;
        this.y = b;
        this.z = c;
        setSize(900, 800);
        card = new CardLayout(10, 10);
        setLayout(card);
        setTitle("Cubo Dinamico");
        cont = getContentPane();
        //**************************************************************
        String titulos[] = new String[b], contenido[][] = new String[a][b];

        for (int i = 0; i < b; i++) {
            titulos[i] = "" + i;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                contenido[i][j] = "";
            }
        }
        //**************************************************************
        Lcara = new JLabel[c];
        for (int i = 0; i < c; i++) {
            Lcara[i] = new JLabel("Profundidad: " + i);
        }
        //**************************************************************
        Tx = new JTextField[c];
        for (int i = 0; i < c; i++) {
            Tx[i] = new JTextField();
        }
        //**************************************************************
        tablas = new JTable[c];
        for (int i = 0; i < c; i++) {
            tablas[i] = new JTable(contenido, titulos);
        }
        //**************************************************************
        paneltabla = new JScrollPane[c];
        for (int i = 0; i < c; i++) {
            paneltabla[i] = new JScrollPane(tablas[i]);
        }
        //**************************************************************
        buscar = new JButton[c];
        cargar = new JButton[c];
        cambio=new JButton[c];
        for (int i = 0; i < c; i++) {
            buscar[i] = new JButton("Buscar");
            cargar[i] = new JButton("Cargar");
            cambio[i] = new JButton("Siguiente");
            
        }
        //**************************************************************
        panelppal = new JPanel[c];
        for (int i = 0; i < c; i++) {
            panelppal[i] = new JPanel();
            panelppal[i].setLayout(null);
            Tx[i].setBounds(10, 10, 50, 40);
            buscar[i].setBounds(70, 10, 80, 40);
            cargar[i].setBounds(160, 10, 100, 40);
            
            Lcara[i].setBounds(270, 10, 150, 40);
            cambio[i].setBounds(450, 10, 100, 40);
            paneltabla[i].setBounds(10, 70, 780, 700);
            panelppal[i].add(Tx[i]);
            panelppal[i].add(buscar[i]);
            panelppal[i].add(cargar[i]);
            panelppal[i].add(Lcara[i]);
            panelppal[i].add(cambio[i]);
            panelppal[i].add(paneltabla[i]);
            

        }
         //**************************************************************       
        for (int i = 0; i < c; i++) {
        cont.add("",panelppal[i]);
        }
        
    }

}
