/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Agendamento;
import model.CadCliente;
import model.Servico;
import model.Usuario;
import java.util.ArrayList;

public class Banco {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/barbearia","postgres","postgres");
        return conexao;
    }
    
    
    public static ArrayList<Usuario> usuario;
    public static ArrayList<CadCliente> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agendamento> agendamento;
    
    
    public static void inicia(){
    
        //Instancia os Objetos
        usuario = new ArrayList<Usuario>();
        cliente = new ArrayList<CadCliente>();
        servico = new ArrayList<Servico>();
        agendamento = new ArrayList<Agendamento>();
        
        //criando elementos
        
        Usuario usuario1 = new Usuario(1, "barbeiro", "M", "09/05/1996", "30212121", "barbeiro@barbershop.com", "521454123", "barbeiro", "administrador");
        Usuario usuario2 = new Usuario(2, "estagiario", "M", "09/05/1996", "30212122", "estagiario@barbershop.com", "451244123", "estagiario", "funcionario");
         
        CadCliente cliente1 = new CadCliente(1, "Alan Figueiredo", "M", "30/01/1995", "30212126", "danillo_fel98@hotmail.com", "5142487", "Rua jaboti 35 Canudos NH",  "93300012");
        CadCliente cliente2 = new CadCliente(2, "Judite Oliveira", "F", "30/08/1994", "30212127", "juditeoliveirapet@gmail.com", "5142487745", "Rua campo bom 78 Centro NH",  "93300045");
        CadCliente cliente3 = new CadCliente(3, "Paulo Ricado", "M", "24/04/1997", "30212128", "pauloricardopet@gmail.com", "78451458", "Rua Tres Irmaos 30 Vila Nova - NH",  "933007496");
        CadCliente cliente4 = new CadCliente(4, "Neymar Santos", "M", "20/08/1995", "30212130", "neymarsantospet@gmail.com", "2745487", "Rua Lombardi 40 Canudos NH",  "93300748");
        CadCliente cliente5 = new CadCliente(5, "Debruine Pipoqueiro", "M", "13/09/1992", "30212131", "debruinepet@gmail.com", "4742487", "Rua pedro quaresma 784 Canudos Belgica",  "933000847");
        CadCliente cliente6 = new CadCliente(6, "Matuidi Pareira", "M", "17/08/1994", "302122324", "matuidipet@gmail.com", "78512457", "Rua champions 10 Kephas Franca",  "933000782");
        CadCliente cliente7 = new CadCliente(7, "Marta de Souza", "F", "25/03/1993", "302121292", "martasouzapet@gmail.com", "4658237314", "Rua tesla 215 Canudos NH",  "93352012");
        CadCliente cliente8 = new CadCliente(8, "Aline Ferrari", "F", "04/03/1990", "302121451", "alineferraripet@gmail.com", "8475123687", "Rua hyrule 32 Canudos NH",  "9334714747");
        CadCliente cliente9 = new CadCliente(9, "Samuel Coltinho", "M", "09/02/1998", "302121189", "samuelcoltinhopet@gmail.com", "74595142487", "Rua floresta 12 Canudos NH",  "9330046364");
        CadCliente cliente10 = new CadCliente(10, "Felipe Luis", "M", "12/06/1999", "3021212478", "felipeluispet@gmail.com", "845713647", "Rua marechal 1023 Canudos NH",  "933000874");
        
        Servico servico1 = new Servico(1, "Corte Simples", 18);
        Servico servico2 = new Servico(2, "Corte Degrade", 30);
        Servico servico3 = new Servico(3, "Barba Simples", 15);
        Servico servico4 = new Servico(4, "Barba Desenhada", 25);
        Servico servico5 = new Servico(5, "Sombrancelhas", 10);
        Servico servico6 = new Servico(6, "Penteados", 3);

        Agendamento agendamento1 = new Agendamento(1, cliente1, servico2, 30, "14/07/2018 09:30");
        Agendamento agendamento2 = new Agendamento(2, cliente3, servico4, 40, "14/07/2018 10:00");
        Agendamento agendamento3 = new Agendamento(3, cliente4, servico1, 18, "14/07/2018 10:30");
        
        //Adiciona Elementos na lista
        usuario.add(usuario1);
        usuario.add(usuario2);
        
        cliente.add(cliente1);
        cliente.add(cliente2);
        cliente.add(cliente3);
        cliente.add(cliente4);
        cliente.add(cliente5);
        cliente.add(cliente6);
        cliente.add(cliente7);
        cliente.add(cliente8);
        cliente.add(cliente9);
        cliente.add(cliente10);
        
        servico.add(servico1);
        servico.add(servico2);
        servico.add(servico3);
        servico.add(servico4);
        servico.add(servico5);
        servico.add(servico6);
        
        agendamento.add(agendamento1);
        agendamento.add(agendamento2);
        agendamento.add(agendamento3);
    }
}