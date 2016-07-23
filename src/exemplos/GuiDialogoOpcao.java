
package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiDialogoOpcao extends JPanel {
    
    private JLabel lbRespostas;
    private JButton btAbrir;
    
    
    
    
    
    
    
    public GuiDialogoOpcao(){
        
        inicializarComponentes();
        definirEventos();  
        
        
        
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        
        lbRespostas = new JLabel("");
        btAbrir = new JButton("Abrir");
        
        
        lbRespostas.setBounds(25,60,200,25);
        btAbrir.setBounds(25,30,100,25);
        
        
        add(lbRespostas);
        add(btAbrir);
             

    }

    private void definirEventos() {
        btAbrir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] escolha = {"Masculino","Feminino"};
                int resposta = JOptionPane.showOptionDialog(
                        null,
                        "Escolha o Sexo",
                        "Sexo",
                        0,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("Sexo.gif"), escolha, escolha[0]);
                        
                        lbRespostas.setText("Sexo escolhido: " + escolha [resposta]);
                
                
                
                
            }
        });
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
