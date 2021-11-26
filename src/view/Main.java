/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Agendamento;
import model.CadCliente;
import model.Servico;
import model.Usuario;

/**
 *
 * @author danil
 */
public class Main {
    public static void main(String[] args){
        String nome = "Thiago";
        System.out.println(nome);
        
        Servico servico = new Servico(1, "Barba", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
    
        CadCliente cliente = new CadCliente(1, "tiago", "rua teste", "09000999");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1, "barbeiro", "12345");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "09/05/2021 09:33");
        System.out.println(agendamento.getCliente().getNome());
    }
    
}
