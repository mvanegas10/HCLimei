package source;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Meili on 12/29/16.
 */
public class BusquedaPanel {
    private JPanel busquedaPanel;
    private JComboBox criterioBusquedaComboBox;
    private JLabel criterioLabel;
    private JLabel buscarTextoLabel;
    private JButton buscarPacienteButton;
    private JTextField textoABuscarText;
    private JScrollPane scrollerBusqueda;
    private JTable tablaBusqueda;
    private JPanel principalPanel;
    private DefaultTableModel tableModelBusqueda;
    private HCLimeiFrame hclimei;

    public BusquedaPanel(HCLimeiFrame hclimei) {
        this.hclimei = hclimei;
        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelBusqueda = new DefaultTableModel();
                tablaBusqueda.setModel(tableModelBusqueda);
                ArrayList<Paciente> pacientes = hclimei.getMain().buscarPaciente(textoABuscarText.getText(),String.valueOf(
                        criterioBusquedaComboBox.getSelectedItem()));

                String[] colName = {"Id","Documento","Nombre"};

                tableModelBusqueda.setColumnIdentifiers(colName);
                for (Paciente paciente : pacientes) {
                    String data[] = new String[3];
                    data[0] = paciente.getIdPaciente();
                    data[1] = paciente.getNumeroDocumento();
                    data[2] = paciente.getPrimerNombre() + " " + paciente.getSegundoNombre() + " " + paciente.getPrimerApellido() + " " + paciente.getSegundoApellido();
                    tableModelBusqueda.addRow(data);
                }
                tablaBusqueda.setModel(tableModelBusqueda);
                tablaBusqueda.getColumnModel().getColumn(0).setPreferredWidth(100);
                tablaBusqueda.getColumnModel().getColumn(1).setPreferredWidth(200);
                tablaBusqueda.getColumnModel().getColumn(2).setPreferredWidth(500);

                MouseListener tableMouseListener = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String selected = (String) tableModelBusqueda.getValueAt(tablaBusqueda.getSelectedRow(),0);
                        System.out.println(selected);
                        hclimei.verPaciente(selected);
                    }
                };

                tablaBusqueda.addMouseListener(tableMouseListener);
            }
        });
    }

    public JPanel getBusquedaPanel() {
        return busquedaPanel;
    }

    public JComboBox getCriterioBusquedaComboBox() {
        return criterioBusquedaComboBox;
    }

    public JLabel getCriterioLabel() {
        return criterioLabel;
    }

    public JLabel getBuscarTextoLabel() {
        return buscarTextoLabel;
    }

    public JButton getBuscarPacienteButton() {
        return buscarPacienteButton;
    }

    public JTextField getTextoABuscarText() {
        return textoABuscarText;
    }

    public JScrollPane getScrollerBusqueda() {
        return scrollerBusqueda;
    }

    public JTable getTablaBusqueda() {
        return tablaBusqueda;
    }

    public JPanel getPrincipalPanel() {
        return principalPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] criterios = {"Nombre","Identificación"};
        criterioBusquedaComboBox = new JComboBox(criterios);
    }
}
