/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.CadCliente;
import view.Cliente;

/**
 *
 * @author danil
 */
public class ClienteHelper implements IHelper {
    private final Cliente view;
    
    public ClienteHelper(Cliente view){
        this.view = view;
    }
    public void preencherTabela(ArrayList<CadCliente> clientes) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableCliente().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o tableModel
        for (CadCliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getSexo(),
                cliente.getDataFormatada(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getRg(),
                cliente.getEndereco(),
                cliente.getCep()
            });
        }
    }
    
    @Override
    public CadCliente obterModelo() {
        String idString = view.getTextID().getText();
        int id = Integer.parseInt(idString);
        String cliente = view.getTextNome().getText();
        String sexo = (String) view.getComboBoxSexo().getSelectedItem();
        String data = view.getTextDataNascimento().getText();
        String telefone = view.getTextTelefone().getText();
        String email = view.getTextEmail().getText();
        String rg = view.getTextRG().getText();
        String endereco = view.getTextEndereco().getText();
        String cep = view.getTextCEP().getText();
        
        CadCliente clientes = new CadCliente(id, cliente, sexo, data, telefone, email, rg, endereco, cep);
        return clientes;
    }

    @Override
    public void limparTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
