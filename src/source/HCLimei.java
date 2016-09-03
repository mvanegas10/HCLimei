package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Meili on 9/2/16.
 */
public class HCLimei {

    private JPanel panel1;
    private JButton consultaControlButton;
    private JLabel primeraVezLabel;
    private JLabel controlLabel;
    private JComboBox criterioBusquedaComboBox;
    private JLabel buscarTextoLabel;
    private JLabel criterioLabel;
    private JButton crearPacienteButton;
    private JTabbedPane manejadorTabs;
    private JButton buscarPacienteButton;
    private JPanel busquedaPanel;
    private JPanel inicioPanel;
    private JPanel detallePacientePanel;
    private JLabel primerNombreLabel;
    private JLabel primerApellidoLabel;
    private JLabel fechaNacimientoLabel;
    private JLabel tipoIdentificacionLabel;
    private JLabel segundoNombreLabel;
    private JTextField segundoNombreText;
    private JTextField primerNombreText;
    private JTextField primerApellidoText;
    private JLabel segundoApellidoLabel;
    private JTextField segundoApellidoText;
    private JTextField fechaNacimientoText;
    private JLabel edadLabel;
    private JTextField edadText;
    private JTextField tipoIdentificacionText;
    private JLabel identificacionLabel;
    private JTextField identificacionText;
    private JTextField generoText;
    private JLabel generoLabel;
    private JLabel profesionLabel;
    private JTextField profesionText;
    private JLabel municipioNacimientoLabel;
    private JLabel departamentoNacimientoLabel;
    private JTextField departamentoText;
    private JTextField direccionText;
    private JLabel direccionLabel;
    private JTextField telefonoText;
    private JLabel telefonoLabel;
    private JLabel celularLabel;
    private JTextField celularText;
    private JLabel mailLabel;
    private JTextField mailText;
    private JTextField municipioText;
    private JLabel acompañanteLabel;
    private JTextField acompañanteText;
    private JTextField parentescoText;
    private JLabel parentescoLabel;
    private JTextField telefonoAcompañanteText;
    private JLabel telefonoAcompañanteLabel;
    private JLabel captacionLabel;
    private JTextField rhText;
    private JLabel rhLabel;
    private JTextField captacionText;
    private JTextField textoABuscarText;
    private JPanel consultaPanel;
    private JTextArea motivoConsultaText;
    private JTextArea enferemedadActualText;
    private JLabel motivoConsultaLabel;
    private JLabel enfermedadActualLabel;
    private JLabel antecedentesPersonalesLabel;
    private JTextArea antecedentesPersonalesText;
    private JLabel antecedentesFamiliaresLabel;
    private JTextArea antecedentesFamiliaresText;
    private JLabel motivoYAntecedentesLabel;
    private JLabel generarRIPSLabel;
    private JLabel buscarPacienteLabel;
    private JButton buscarPacienteInicioButton;
    private JButton generarRIPSButton;
    private JScrollPane scrollerLista;
    private JList listaResultadosList;
    private JButton verPacienteButton;
    private JButton iniciarConsultaButton;
    private JPanel vistaPacientePanel;
    private JPanel tituloPacientePanel;
    //    private JScrollPane scrollerLista;
//    private JList listaResultadosList;

    private Main main;

    public JPanel getPanel1() {
        return panel1;
    }

    public void verDetallePaciente(Paciente paciente) {
        manejadorTabs.setSelectedComponent(detallePacientePanel);
        tipoIdentificacionText.setText(paciente.getTipoDocumento());
        identificacionText.setText(paciente.getNumeroDocumento());
        primerNombreText.setText(paciente.getPrimerNombre());
        segundoNombreText.setText(paciente.getSegundoNombre());
        primerApellidoText.setText(paciente.getPrimerApellido());
        segundoApellidoText.setText(paciente.getSegundoApellido());
        fechaNacimientoText.setText(paciente.getFechaNacimiento());
        generoText.setText(paciente.getSexo());
        direccionText.setText(paciente.getDireccion());
        telefonoText.setText(paciente.getTelefono());
        celularText.setText(paciente.getCelular());
        mailText.setText(paciente.getMail());
        acompañanteText.setText(paciente.getAcompaniante());
        telefonoAcompañanteText.setText(paciente.getTelAcompaniante());
    }

    public HCLimei(Main main) {
        this.main = main;
        consultaControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorTabs.setSelectedComponent(busquedaPanel);
            }
        });
        buscarPacienteInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorTabs.setSelectedComponent(busquedaPanel);
            }
        });
        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] pacientes = main.buscarPaciente(textoABuscarText.getText(),String.valueOf(
                        criterioBusquedaComboBox.getSelectedItem()));

                DefaultListModel respuesta = new DefaultListModel();
                for (Object paciente : pacientes) {
                    respuesta.addElement(paciente);
                }
                listaResultadosList.setModel(respuesta);
            }
        });
        verPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paciente = String.valueOf(listaResultadosList.getSelectedValue());
                String separador = "\t\t\t\t\t\t\t\t";
                String[] datos = paciente.split(separador);
                verDetallePaciente(main.verPaciente(datos[0]));
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] criterios = {"Nombre","Identificación"};
        DefaultListModel modelo = new DefaultListModel();
        criterioBusquedaComboBox = new JComboBox(criterios);
        listaResultadosList = new JList(modelo);
        listaResultadosList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaResultadosList.setLayoutOrientation(JList.VERTICAL);
        listaResultadosList.setVisibleRowCount(-1);
        scrollerLista = new JScrollPane(listaResultadosList);
    }
}
