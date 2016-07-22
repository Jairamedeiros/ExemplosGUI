
package exemplos;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUIDialogoMensagem extends JPanel {
    
    private JComboBox cbCaixas;
    
    
    
    

    public GUIDialogoMensagem() {
        inicializarComponentes();
        definirEventos();
       
    }
    
    private void inicializarComponentes(){
        setLayout(null);
        
        String[] cbCaixasItens = {"Pergunta","Informação","Alerta","Erro"};
        cbCaixas = new JComboBox(cbCaixasItens);
        
        cbCaixas.setBounds(25,40,150,25);
        
        add(cbCaixas);
              
        
        
        
    }

    private void definirEventos(){
        cbCaixas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch(cbCaixas.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(
                                null, "Estou aprendendo Java","Pergunta", 
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                        
                    case 1:
                        JOptionPane.showMessageDialog(
                        null,
                         "Gravação OK", "Informação",
                         JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                    case 2:
                        JOptionPane.showMessageDialog(
                        null,
                         "Cuidado!", "Alerta",
                         JOptionPane.WARNING_MESSAGE);
                        break;        
                        
                    case 3:
                        JOptionPane.showMessageDialog(
                        null,
                         "Ocorreu algum erro!", "Erro",
                         JOptionPane.ERROR_MESSAGE);
                        break;     
                }
            }
        });
    
    }
}   
    
            
    

