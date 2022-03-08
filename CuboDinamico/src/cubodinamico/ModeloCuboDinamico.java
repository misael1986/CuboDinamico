/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubodinamico;

import javax.swing.*;

/**
 *
 * @author GabeL
 */
public class ModeloCuboDinamico {

    public int[][] Cargar(JTable t) {

        int tabla[][], x, y;
        x = t.getRowCount();
        y = t.getColumnCount();
        tabla=new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(t.getValueAt(i, j).toString().equals("")){
                tabla[i][j]=0;
                }
                else {
                    tabla[i][j] = Integer.parseInt(t.getValueAt(i, j).toString());
                }
            }
        }
        return tabla;
    }

    //**************************************************************
    public int[] Buscar(int t[][], JTextField p) {
        
        System.out.println("entro a buscar");
        int num[] = new int[2], x, y;
        int p2 = Integer.parseInt(p.getText());
        x = t.length;
        y = t[0].length;      
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(t[i][j]+"\t");
                if (p2 == t[i][j]) {
                    System.out.println("Encontrado en: "+ i+" , "+j);
                    num[0] = i;
                    num[1] = j;
                    i=x;
                    j=y;
                }
            }
            System.out.println("");
        }
        return num;
    }
    
    public void ImprimeCubo(int [][][] x){
        System.out.println("CUBO EN IMPRESION");
        for(int k=0;k<x[0][0].length;k++){
            System.out.println("------profundidad "+x[0][0].length+"------");
            for(int i=0;i<x.length;i++){
                for(int j=0;j<x[0].length;j++){
                    System.out.print(x[i][j][k]+"\t");
                }
                System.out.println("");
            }
               
        }
    }

}
