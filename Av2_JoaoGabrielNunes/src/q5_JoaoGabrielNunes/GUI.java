package q5_JoaoGabrielNunes;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI extends JFrame implements ActionListener {
    private JButton[] botoes;
    private int numeroAleatorio;
    private int tentativas;
    private JTextField tentativaAtualTextField;

    public GUI() {
    	// titulo e tamanho dos icones e definição;
        setTitle("Adivinhe o Número");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));
        //parte em que faz os botões de 1 a 20;
        botoes = new JButton[20];
        for (int i = 0; i < 20; i++) {
            botoes[i] = new JButton(Integer.toString(i + 1));
            botoes[i].addActionListener(this);
            add(botoes[i]);
        }
        // gera um numero aleatório de 1 a 20;
        numeroAleatorio = new Random().nextInt(20) + 1;
        //recebe o número de tentativas;
        tentativas = 0;
        
        // loop para ir incrementando as tentativas;
        tentativaAtualTextField = new JTextField("Tentativa atual: " + (tentativas + 1));
        tentativaAtualTextField.setEditable(false);
        add(tentativaAtualTextField);
    }
    // metodo para receber os resultados e verificar se o número escolhido ta certo;
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int numeroEscolhido = Integer.parseInt(button.getText());
        tentativas++;

        if (numeroEscolhido == numeroAleatorio) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você acertou o número " + numeroAleatorio + " em " + tentativas + " tentativa(s)!");
            System.exit(0);
        } else {
            if (tentativas < 5) {
                tentativaAtualTextField.setText("Tentativa atual: " + (tentativas + 1));
                JOptionPane.showMessageDialog(this, "Tentativa " + tentativas + ": Você escolheu o número " + numeroEscolhido + ". Tente novamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Suas 5 tentativas acabaram. O número era " + numeroAleatorio + ".");
                System.exit(0);
            }
        }
    }
    //instanciando todas as variaveis da classe para começar o jogo;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }
}
