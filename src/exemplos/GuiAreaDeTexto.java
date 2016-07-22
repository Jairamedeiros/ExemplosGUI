
package exemplos;


import java.awt.event.*;
import javax.swing.*;



public class GuiAreaDeTexto extends JPanel{
    private JTextField tfCampo;
    private JTextArea taTexto;
    private JScrollPane scrollPane;
    private JButton btLimpar;
    
    private static String novaLinha = "\n";
    
    
    

    public GuiAreaDeTexto() {
        inicializarComponentes();
        definirEventos();
       
    }
    
    private void inicializarComponentes(){
        setLayout(null);
        
        tfCampo = new JTextField(5);
        taTexto = new JTextArea(5,20);
        btLimpar = new JButton("Limpar");
        scrollPane = new JScrollPane(taTexto);
        
      
        taTexto.setEditable(false);
        
        tfCampo.setBounds(25,15,150,25);
        btLimpar.setBounds(25,170,100,25);
        scrollPane.setBounds(25,45,300,120);
        
        
        add(tfCampo);
        add(btLimpar);
        add(scrollPane);   
              
    }
    
    
     private void definirEventos(){
         tfCampo.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                taTexto.append(tfCampo.getText() + novaLinha);
                taTexto.setCaretPosition(taTexto.getDocument().getLength());
                tfCampo.setText("");
                tfCampo.requestFocus();
                 
             }
         });
        
         btLimpar.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 tfCampo.setText("");
                 taTexto.setText("");
                 tfCampo.requestFocus();
                               
                               
                 
                
             }
         });
         
         
         
         
         
         
         
    
  }
}