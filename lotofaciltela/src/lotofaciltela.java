import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class lotofaciltela extends JFrame {
    private JPanel painel = new JPanel();
    private JButton aposta0100 = new JButton("Aposta 0 - 100");
    private JButton apostaAZ = new JButton("apostaAZ");
    private JButton numpar = new JButton("Digite um numero");
    private JButton sair = new JButton("sair");

    public lotofaciltela(){
        setTitle("CASA APOSTA");
        setSize(300, 350);
        setLocationRelativeTo(null);
        confingComps();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        ImageIcon banner = new ImageIcon("imagens/banner.png");
        JLabel labelImagem = new JLabel(banner);
        getContentPane().add(labelImagem, BorderLayout.BEFORE_FIRST_LINE);
        setVisible(true);
    }
    private void confingComps(){

        painel.setBackground(new Color(87, 86, 86));
        aposta0100.setPreferredSize(new Dimension(140, 30));
        apostaAZ.setPreferredSize(new Dimension(140, 30));
        numpar.setPreferredSize(new Dimension(140, 30));
        sair.setPreferredSize(new Dimension(140, 30));

        aposta0100.setToolTipText("APOSTA 0 - 100");
        apostaAZ.setToolTipText("APOSTA A - Z");
        numpar.setToolTipText("DIGITE UM NÚMERO");
        sair.setToolTipText("SAIR");

        painel.add(aposta0100);
        painel.add(apostaAZ);
        painel.add(numpar);
        painel.add(sair);

        getContentPane().add(painel);


        sair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sair();
            }
        });
        numpar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numpar();
            }
        });
        apostaAZ.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aspostaAZ();
            }
        });
        aposta0100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta0100();
            }
        });

    }

    private void sair() {
        if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Sair do Programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }

    }

    private void numpar() {
        ImageIcon ico = new ImageIcon("imagens/aposta.jpg");
        Object numerodousuario = JOptionPane.showInputDialog(
                null, "DIGITE UM NÚMERO PARA SER APOSTADO", "APOSTA NÚMERO PAR",
                JOptionPane.INFORMATION_MESSAGE, ico, null, "");
        JOptionPane.showMessageDialog(null, "Número a ser apostado: " + numerodousuario);

        int numero = Integer.parseInt(numerodousuario.toString());

        if (numero % 2 == 0){
            JOptionPane.showMessageDialog(null, "PARÁBENS VOCÊ GANHOU 500R$");
        }else {
            JOptionPane.showMessageDialog(null, "VOCÊ PERDEU");
        }
    }

    private void aspostaAZ() {
        ImageIcon icon = new ImageIcon("imagens/apostaaz.png");
        JTextField inserirTexto = new JTextField(1);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Digite uma letra de A até Z: "));
        panel.add(inserirTexto);
        int letraApostada = JOptionPane.showConfirmDialog(null, panel, "Aposta A - Z",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        if (letraApostada == JOptionPane.OK_OPTION) {
            try {
                String texto = inserirTexto.getText();

                if (texto.length() == 1 && Character.isLetter(texto.charAt(0))) {
                    char letra = Character.toUpperCase(texto.charAt(0));
                    if (letra >= 'A' && letra <= 'Z') {
                        JOptionPane.showMessageDialog(null, "Sua letra é: " + letra);
                        Random random = new Random();
                        char letraAleatoria = (char) (random.nextInt(26) + 'A');
                        JOptionPane.showMessageDialog(null, "letra sorteada: " + letraAleatoria);
                        if (letra == letraAleatoria) {
                            JOptionPane.showMessageDialog(null, "o apostador ganhou 500 R$");

                        } else if (letra != letraAleatoria) {
                            JOptionPane.showMessageDialog(null, "Não foi dessa vez, OTÁRIO!!!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aposta inválida.");

                }


            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a aposta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
    }
    }
    private void aposta0100(){
            ImageIcon ic = new ImageIcon("imagens/apostinha.PNG");
            Object numeroApostado = JOptionPane.showInputDialog(null,"Digite o seu número de 0 a 100",
                    "Aposta 1",JOptionPane.INFORMATION_MESSAGE,
                    ic, null,"");

            JOptionPane.showMessageDialog(null,"Número Apostado: " + numeroApostado);
            int numero = Integer.parseInt(numeroApostado.toString());
            if(numero < 0 || numero >100 ) {
                JOptionPane.showMessageDialog(null,"Valor Inválido");
            } else {
                double numeroAleatorio = Math.random() * 101;
                int sorteado = (int)numeroAleatorio;
                JOptionPane.showMessageDialog(null,"Número sorteado: " + sorteado);
                if( numeroAleatorio == sorteado){
                    JOptionPane.showMessageDialog(null,"O apostador ganhou 1000R$");
                }else if( numeroAleatorio != sorteado){
                    JOptionPane.showMessageDialog(null,"Perdeu seu Trouxa!");
                }
            }
    }
    public static void main(String[] args) {
        new lotofaciltela();
    }
}

