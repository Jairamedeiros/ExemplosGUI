
package exemplos;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GuiGrade extends JPanel{
    private JPanel pnPrincipal, pnTable;
    private JButton btRemover, btAdicionar;
    private JScrollPane scrollTable;
    private JTable Table;
    private JLabel lbNumero, lbTotal, lbProduto;
    private JLabel lbPrecoUnitario, lbQuantidade;
    private JTextField tfNumero, tfTotal, tfProduto;
    private JTextField tfPrecoUnitario, tfQuantidade;
    
    
    
    DecimalFormat df = new DecimalFormat("#,###.00");
    
    
    public GuiGrade(){
       inicializarComponentes();
       definirEventos();    
    
    
    }

    private void inicializarComponentes() {
        
        setLayout(null);
        
        lbProduto = new JLabel ("Produto");
        lbQuantidade = new JLabel("Quantidade");
        lbPrecoUnitario = new JLabel("Preço Unitário");
        lbNumero = new JLabel("Número do pedido");
        lbTotal = new JLabel("Total do pedido: ");
        tfProduto = new JTextField();
        tfPrecoUnitario = new JTextField();
        tfQuantidade = new JTextField();
        tfNumero = new JTextField();
        tfTotal = new JTextField();
        btAdicionar = new JButton("Adicionar");
        btRemover = new JButton("Remover");
        
        
        tfTotal.setEnabled(false);
        tfTotal.setHorizontalAlignment(JTextField.RIGHT);
        
        lbProduto.setBounds(15,40,100,25);
        lbQuantidade.setBounds(225,40,100,25);
        lbPrecoUnitario.setBounds(310,40,100,25);
        lbNumero.setBounds(15,10,120,25);
        lbTotal.setBounds(278,360,100,25);
        tfProduto.setBounds(15,65,200,25);
        tfQuantidade.setBounds(225,65,50,25);
        tfPrecoUnitario.setBounds(310,65,80,25);
        tfNumero.setBounds(130,10,50,25);
        tfTotal.setBounds(375,360,100,25);
        btAdicionar.setBounds(15,100,100,22);
        btRemover.setBounds(125,100,100,22);
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0,0,500,400);
        
        
        pnPrincipal.add(lbNumero);
        pnPrincipal.add(lbTotal);
        pnPrincipal.add(lbProduto);
        pnPrincipal.add(lbQuantidade);
        pnPrincipal.add(lbPrecoUnitario);
        pnPrincipal.add(tfNumero);
        pnPrincipal.add(tfTotal);
        pnPrincipal.add(tfProduto);
        pnPrincipal.add(tfQuantidade);
        pnPrincipal.add(tfPrecoUnitario); 
        pnPrincipal.add(btAdicionar);
        pnPrincipal.add(btRemover);
        
        
        pnTable = new JPanel(new BorderLayout());
        pnTable.setBorder(new TitledBorder("Itens do pedido"));
        
        
        scrollTable = new JScrollPane();
        
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
       
        
        DefaultTableModel model = new DefaultTableModel(
                new String[] {"Produto","Qtd","P. Unit","Total"},0){
                public boolean isCellEditable(int row, int col ){
                    if(col == 3){
                    return false;
                    }
                    return true;
                    
                }
                    
            };   
        
        Table = new JTable(model);
        
        DefaultTableCellRenderer alinharDireita = new DefaultTableCellRenderer();
        alinharDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        Table.getColumnModel().getColumn(0).setPreferredWidth(150);
        Table.getColumnModel().getColumn(1).setPreferredWidth(50);
        Table.getColumnModel().getColumn(2).setPreferredWidth(100);
        Table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        
        Table.getColumnModel().getColumn(0).setResizable(false);
        Table.getColumnModel().getColumn(1).setResizable(false);
        Table.getColumnModel().getColumn(2).setResizable(false);
        Table.getColumnModel().getColumn(3).setResizable(false);
        
        
        Table.getColumnModel().getColumn(0).setCellRenderer(alinharDireita);
        Table.getColumnModel().getColumn(1).setCellRenderer(alinharDireita);
        Table.getColumnModel().getColumn(2).setCellRenderer(alinharDireita);
        Table.getColumnModel().getColumn(3).setCellRenderer(alinharDireita);
        
        
        
        Table.getTableHeader().setReorderingAllowed(false);
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollTable.setViewportView(Table);
        pnTable.add(scrollTable);
        
        
        pnTable.setBounds(10,130,470,230);
        pnPrincipal.add(pnTable);
        
        
        
        add(pnPrincipal);
        
        
        
        }

    private void definirEventos() {
        
        btAdicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfProduto.getText().equals("")||tfQuantidade.getText().equals("")||tfPrecoUnitario.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                    return;
                           
                }
                
                DefaultTableModel model = (DefaultTableModel)Table.getModel();
                model.addRow(new Object[]{
                tfProduto.getText(),
                tfQuantidade.getText(),
                tfPrecoUnitario.getText(),
                ""+df.format(Integer.parseInt(tfQuantidade.getText())*Float.parseFloat(tfPrecoUnitario.getText()))
  
            
        });
        limparCampos();
        CalcularTotal();
       
        }
            
        });
        
    }

        private void limparCampos() {
            tfProduto.setText("");
            tfQuantidade.setText("1");
            tfPrecoUnitario.setText("");
            tfProduto.requestFocus();
                              
                
            }

            private void CalcularTotal() {
                float total = 0f;
                for (int linha = 0; linha < Table.getRowCount(); linha++){
                    String valor = "" + Table.getValueAt(linha, 3);
                    valor = valor.replace(",", ",");
                    valor = valor.replace(",", ",");
                    total += Float.parseFloat(valor);
                    
                    
                }
                
                tfTotal.setText(""+df.format(total));
                
             
            }}



