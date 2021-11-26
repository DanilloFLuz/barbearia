package controller;

import Model.DAO.Banco;
import Model.DAO.UsuarioDAO;
import controller.Helper.LoginHelper;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Login;
import view.MenuPrincipal;

/**
 *
 * @author danil
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    public  void entrarNoSistema() throws SQLException{
        //Usuario usuario = helper.obterModelo();
        String usuario = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        
        Usuario autentica = new Usuario(usuario, senha);
        
        Connection conexao = new Banco().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDAO.existeUsuario(autentica);  
        if(existe){
            MenuPrincipal telaMenu = new MenuPrincipal();
            telaMenu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
        }
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fizTarefa");
    }
    
}
