/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author danil
 */
public class CadCliente extends Pessoa{
    private String endereco;
    private String cep;
    private String data;
    
    public CadCliente(int id, String nome, String sexo, String dataNascimento, String telefone, String email, String rg, String endereco, String cep) {
        super(id, nome, sexo, dataNascimento, telefone, email, rg);
        this.id = id;
        this.endereco = endereco;
        this.cep = cep;
    }

    public CadCliente(int id, String nome, String endereco, String cep) {
        super(id, nome);
        this.endereco = endereco;
        this.cep = cep;
    }

    public CadCliente(String nome, String sexo, String dataNascimento, String telefone, String email, String rg, String endereco, String cep) {
        super(nome, sexo, dataNascimento, telefone, email, rg);
        this.endereco = endereco;
        this.cep = cep;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    @Override
    public String toString(){
        return getNome();
    }
    
}
