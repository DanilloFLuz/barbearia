/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CadCliente;
import java.util.ArrayList;

public class ClienteDAO {
    
    private final Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Insere um cliente dentro do banco de dados
     * @param cliente exige que seja passado um objeto do tipo cliente
     * @throws java.sql.SQLException
     */
    public void insertCliente(CadCliente cliente) throws SQLException{
        String sql = "INSERT INTO cliente (nome_cliente,sexo_cliente,data_nascimento_cliente,telefone_cliente,email_cliente,rg_cliente,endereco_cliente,cep_cliente)"
                + "VALUES (? , ?, ?, ? , ?, ?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getSexo());
        statement.setString(3, String.valueOf(cliente.getDataNascimento()));
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getEmail());
        statement.setString(6, cliente.getRg());
        statement.setString(7, cliente.getEndereco());
        statement.setString(8, cliente.getCep());
        statement.execute();
        conexao.close();
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param cliente 
     * @throws java.sql.SQLException 
     */
    public void update(CadCliente cliente) throws SQLException{
        String sql = "UPDATE cliente SET "
                + "nome_cliente = ?,"
                + "sexo_cliente = ?,"
                + "data_nascimento_cliente = ?,"
                + "telefone_cliente = ?,"
                + "email_cliente = ?,"
                + "rg_cliente = ?,"
                + "endereco_cliente = ?,"
                + "cep_cliente = ?"
                + "WHERE id_cliente = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getSexo());
        statement.setString(3, String.valueOf(cliente.getDataNascimento()));
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getEmail());
        statement.setString(6, cliente.getRg());
        statement.setString(7, cliente.getEndereco());
        statement.setString(8, cliente.getCep());
        statement.setInt(9, cliente.getId());
        statement.execute();
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do cliente passado
     * @param cliente 
     * @throws java.sql.SQLException 
     */
    public void delete(CadCliente cliente) throws SQLException{
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, cliente.getId());
        statement.execute();
    }
    public void insertOrUpdate(CadCliente cliente) throws SQLException{
        if(cliente.getId() > 0){
            update(cliente);
        }else{
            insertCliente(cliente);
        }
    }
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     * @throws java.sql.SQLException
     */
    public ArrayList<CadCliente> selectAll() throws SQLException{
        String sql = "SELECT * FROM cliente";
        PreparedStatement statement = conexao.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<CadCliente> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<CadCliente> clientes = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int id_cliente = resultSet.getInt("id_cliente");
            String nome_cliente = resultSet.getString("nome_cliente");
            String sexo_cliente = resultSet.getString("sexo_cliente");
            String data_nascimento_cliente = resultSet.getString("data_nascimento_cliente");
            String telefone_cliente = resultSet.getString("telefone_cliente");
            String email_cliente = resultSet.getString("email_cliente");
            String rg_cliente = resultSet.getString("rg_cliente");
            String endereco_cliente = resultSet.getString("endereco_cliente");
            String cep_cliente = resultSet.getString("cep_cliente");
            CadCliente clienteRetorno = new CadCliente(id_cliente,
                    nome_cliente,
                    sexo_cliente,
                    data_nascimento_cliente,
                    telefone_cliente,
                    email_cliente, 
                    rg_cliente,
                    endereco_cliente, 
                    cep_cliente);
            clientes.add(clienteRetorno);
        }
        return clientes;
    }
    public CadCliente selectPorId(CadCliente cliente) throws SQLException{
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, cliente.getId());
        
        return  pesquisa(statement).get(0);
    }    
}