/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.DAO.Banco;
import Model.DAO.ClienteDAO;
import controller.Helper.ClienteHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CadCliente;
import view.Cliente;

/**
 *
 * @author danil
 */
public class ClienteController {
    private final Cliente view;
    private final ClienteHelper helper;
    
    public ClienteController(Cliente view){
        this.view = view;
        this.helper = new ClienteHelper(view);
    }
    public void salvarCliente(){
        String nome = view.getTextNome().getText();
        String sexo = view.getComboBoxSexo().getSelectedItem().toString();
        String dataNascimento = view.getTextDataNascimento().getText();
        String telefone = view.getTextTelefone().getText();
        String email = view.getTextEmail().getText();
        String rg = view.getTextRG().getText();
        String endereco = view.getTextEndereco().getText();
        String cep = view.getTextCEP().getText();
        
        CadCliente cadCliente = new CadCliente(nome, sexo, dataNascimento, telefone, email, rg, endereco, cep);
        try {
            Connection conexao = new Banco().getConnection();
            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            clienteDAO.insertCliente(cadCliente);
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizaTabela() throws SQLException{
        Connection conexao = new Banco().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        ArrayList<CadCliente> clientes = clienteDAO.selectAll();
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableCliente().getModel();
        tableModel.setNumRows(0);
        //Percorrer a lista preenchendo o tableModel
        for (CadCliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getSexo(),
                cliente.getDataNascimento(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getRg(),
                cliente.getEndereco(),
                cliente.getCep()
            });
        }
    }
}
