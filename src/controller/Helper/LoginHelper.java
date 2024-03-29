/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Helper;

import model.Usuario;
import view.Login;

/**
 *
 * @author danil
 */
public class LoginHelper implements IHelper{
    private final Login view;
    
    public LoginHelper(Login view){
        this.view = view;
        
    }
    
    public Usuario obterModelo(){
        String nome = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        Usuario modelo = new Usuario(0, nome, senha);
        
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }
}
