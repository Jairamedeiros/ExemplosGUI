
package exemplos;


import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

public class GuiBarraRolagem extends JPanel{
    private JScrollBar scrolbBar1;
    private JLabel lbCentimetros, lbPolegadas;
    
    
    
    public GuiBarraRolagem(){
        inicializarComponentes();
        definirEventos();       
              
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        scrolbBar1 = new JScrollBar(JScrollBar.HORIZONTAL,0,5,0,105);
        lbPolegadas = new JLabel("0 Polegadas",JLabel.CENTER);
        lbCentimetros = new JLabel("0.00 Centímetros",JLabel.CENTER);
        scrolbBar1.setBounds(25,20,180,25);
        lbPolegadas.setBounds(35,50,150,25);
        lbCentimetros.setBounds(35,80,150,25);
        
        add(scrolbBar1);
        add(lbCentimetros);
        add(lbPolegadas);
      
        
    }

    private void definirEventos() {
        scrolbBar1.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
               lbPolegadas.setText(scrolbBar1.getValue() + "Polegadas");
               NumberFormat nf = NumberFormat.getInstance();
               nf.setMinimumFractionDigits(2);
               nf.setMaximumFractionDigits(2);
               
               double cm = scrolbBar1.getValue()* 2.54;
               lbCentimetros.setText(nf.format(cm)+ "Centímetros");
                
                
                
            }
        });
            
        
    }
        
}
    
    
    
    
    
    
    
    

