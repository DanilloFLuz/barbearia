/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Servico.Correio;
import controller.Helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
import model.CadCliente;
import model.Servico;
import view.Agenda;

/**
 *
 * @author danil
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;
    
    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        helper.preencherTabela(agendamentos);
    }
    public void atualizaCliente(){
        /*ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<CadCliente> clientes = clienteDAO.selectAll();
        helper.preencherClientes(clientes);*/
    }
    public void atualizaServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        helper.preencherServicos(servicos);
    }
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    public void agendar(){
        //Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        //Salva no banco de dados
        new AgendamentoDAO().insert(agendamento);
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);
        //Inserir na tela
        atualizaTabela();
        helper.limparTela();
    }
}
