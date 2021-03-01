package controller;

import Model.DAO.UsuarioDAO;
import controller.Helper.LoginHelper;
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
    public  void entrarNoSistema(){
        Usuario usuario = helper.obterModelo();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        if(usuarioAutenticado != null){
            //Entra no menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibeMensagem("Usuario ou senha invalidos");
        }
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fizTarefa");
    }
    
}
