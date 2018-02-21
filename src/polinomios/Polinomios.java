/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto Kalel
 */
public class Polinomios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testando comit
//segundo teste ssfsfsfdsgdg
        Scanner Leitor = new Scanner(System.in);

        ArrayList<Double> listaDeX = new ArrayList<>();

        int aux_a = 0;
        do {

            int GRAU;

            //passo 1 do programa
            String grau = null;
            grau = JOptionPane.showInputDialog("Qual é o grau?");
            GRAU = Integer.parseInt(grau);
            double[] a = new double[GRAU + 1];

            //passo 2 do programa
            for (Integer i = GRAU; i >= 0; i--) {
                String numero = null;
                numero = JOptionPane.showInputDialog("digite o valor de 'a' " + (i) + " ? ");
                a[i] = Double.parseDouble(numero);
            }

            double Funcao = 0;
            double Funcao_derivada = 0;
            int aux_x = 1;
///////////////////VAriaveis da inteligencias0

///////////////?//////////////////////
            do {
                String X = null;
                X = JOptionPane.showInputDialog("Bora chutar(x)! Insira o valor: ");
                double x = Double.parseDouble(X);
                BigDecimal xd = new BigDecimal(x).setScale(4, RoundingMode.HALF_UP);
                x = xd.doubleValue();

                int count = 1;
                int aux = 1;
                do {
                    Funcao_derivada = 0;
                            Funcao = 0;
                    //DEFINIR A FUNCAO DE X
                    for (int i = GRAU; i >= 0; i--) {
                        double A = a[i];
                        double ex = Math.pow(x, i);
                        if (i == 0) {

                            Funcao = (Funcao) + (A);
                            BigDecimal FuncaoD = new BigDecimal(Funcao).setScale(4, RoundingMode.HALF_UP);
                            Funcao = FuncaoD.doubleValue();
                            System.out.println("entrou aqui");
                            System.out.println("funcao    " + Funcao);
                        } else {
                            Funcao = (Funcao) + (A * ex);
                            BigDecimal FuncaoD = new BigDecimal(Funcao).setScale(4, RoundingMode.HALF_UP);
                            Funcao = FuncaoD.doubleValue();
                            System.out.println("o valor dentro do a é " + a[i]);
                            System.out.println("expoente é " + ex);
                            System.out.println("funcao    " + Funcao);
                        }

                    }
                    //DERIVANDO A FUNCAO4
                    for (int i = GRAU; i > 0; i--) {
                        //System.out.println("o i vale "+i);

                        Funcao_derivada += Math.round((a[i] * (i)) * (Math.pow(x, i - 1)));
                        BigDecimal Funcao_derivadaD = new BigDecimal(Funcao_derivada).setScale(4, RoundingMode.HALF_UP);
                        Funcao_derivada = Funcao_derivadaD.doubleValue();
                        System.out.println("Derivada  " + Funcao_derivada);

                    }
                    double xn = x;
                    double xn_1;
                    double ec;
                    xn_1 = xn - (Funcao / Funcao_derivada);
                    BigDecimal xn_1d = new BigDecimal(xn_1).setScale(4, RoundingMode.HALF_UP);
                    BigDecimal xnd = new BigDecimal(xn_1).setScale(4, RoundingMode.HALF_UP);
                    xn_1 = xn_1d.doubleValue();
                    System.out.println("o xn+1   " + xn_1);
                    ec = (xn - xn_1);
                    System.out.println("erro    " + ec);
                    count++;
                    System.out.println("-------------------------------------------------------------------------");
                    if (ec <= Math.pow(10, -4)) {
                        JOptionPane.showMessageDialog(null, "A raiz e: " + xnd.doubleValue() + "\nQuantidades de loops:" + count);
                        String restartx = JOptionPane.showInputDialog("Bora chutar(x) denovo?! \n1=SIM \n0= NAO: ");
                        int Restartx = Integer.parseInt(restartx);
                        if (Restartx == 1) {
                            aux = 0;
                            count = 1;
                            xn = 0;
                            xn_1 = 0;
                            ec = 0;
                            Funcao_derivada = 0;
                            Funcao = 0;
                        } else if (Restartx == 0) {
                            aux = 0;
                            aux_x = 0;
                            String RI = JOptionPane.showInputDialog(null, "Deseja reininciar o programa? \n1=SIM \n0= NAO");
                            int ri = Integer.parseInt(RI);
                            if (ri == 1) {
                                aux_a = 0;
                            } else if (ri == 0) {
                                JOptionPane.showMessageDialog(null, "Obrigado.  Desenvolvido por Augusto Kalel Stocco Silva");

                                aux = 0;
                                aux_x = 0;
                                aux_a = 1;
                            }
                        }

                    } else {
                        x = xn_1;
                        System.out.println("o valor de x agora é" + x);
                    }
                } while (aux == 1);
            } while (aux_x == 1);
        } while (aux_a == 0);
    }
}
