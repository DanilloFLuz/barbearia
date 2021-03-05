package controller.Helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import view.Agenda;

/**
 *
 * @author danil
 */
public class AgendaHelper {
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamento().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o tableModel
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }
    }
    
    
}
