package source;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
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
    private JTextField procedenteDeText;
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
    private JPanel motivoYAntecedentesPanel;
    private JTextArea motivoConsultaText;
    private JTextArea enferemedadActualText;
    private JLabel motivoConsultaLabel;
    private JLabel enfermedadActualLabel;
    private JLabel antecedentesPersonalesLabel;
    private JTextArea antecedentesPersonalesText;
    private JLabel antecedentesFamiliaresLabel;
    private JTextArea antecedentesFamiliaresText;
    private JLabel generarRIPSLabel;
    private JLabel buscarPacienteLabel;
    private JButton buscarPacienteInicioButton;
    private JButton generarRIPSButton;
    private JButton verPacienteButton;
    private JPanel vistaPacientePanel;
    private JLabel tituloPacienteLabel;
    private JButton iniciarConsultaDetalleButton;
    private JButton editarInformacionButton;
    private JTabbedPane consultaPanel;
    private JPanel datosPacientePanel;
    private JButton continuarMotivoButton;
    private JLabel primerNombreLabel1;
    private JLabel primerApellidoLabel1;
    private JLabel fechaNacimientoLabel1;
    private JLabel segundoNombreLabel1;
    private JTextField ingresoSegundoNombreText;
    private JTextField ingresoPrimerApellidoText;
    private JLabel segundoApellidoLabel1;
    private JTextField ingresoSegundoApellidoText;
    private JTextField ingresoTipoIdentificacionText;
    private JLabel identificacionLabel1;
    private JTextField ingresoIdentificacionText;
    private JLabel generoLabel1;
    private JTextField ingresoFechaNacimientoText;
    private JTextField ingresoGeneroText;
    private JLabel profesionLabel1;
    private JTextField ingresoProfesionText;
    private JLabel departamentoLabel1;
    private JTextField ingresoPrimerNombreText;
    private JLabel municipioLabel1;
    private JLabel tipoIdentificacionLabel1;
    private JTextField ingresoDepartamentoText;
    private JTextField ingresoDireccionText;
    private JLabel direccionLabel1;
    private JTextField ingresoTelefonoText;
    private JLabel telefonoLabel1;
    private JLabel celularLabel1;
    private JTextField ingresoCelularText;
    private JLabel mailLabel1;
    private JTextField ingresoMailText;
    private JTextField ingresoMunicipioText;
    private JLabel responsableLabel1;
    private JTextField ingresoResponsableText;
    private JLabel parentescoLabel1;
    private JTextField ingresoParentescoText;
    private JTextField ingresoTelAcompañanteText;
    private JLabel telAcompañanteLabel1;
    private JLabel captacionLabel1;
    private JTextField ingresoRHText;
    private JLabel rhLabel1;
    private JTextField ingresoCaptacionText;
    private JButton continuarRevisionButton;
    private JPanel revisionPanel;
    private JPanel sintomasPanel;
    private JButton guardarInformacionButton;
    private JTextField naturalDeText;
    private JLabel citasLabel;
    private JTable tablaCitas;
    private JScrollPane scrollerTable;
    private JTable tablaBusqueda;
    private JScrollPane scrollerBusqueda;
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModelBusqueda;
    private ArrayList<JTextField> detallePacienteTexts;

    private Main main;

    public JPanel getPanel1() {
        return panel1;
    }

    public void verDetallePaciente(Paciente paciente) {


        String titulo = (paciente.getSegundoApellido() != null)? paciente.getPrimerNombre() + " " +  paciente.getSegundoNombre() + " "
                + paciente.getPrimerApellido() + " " + paciente.getSegundoApellido(): paciente.getPrimerNombre() + " " +
                paciente.getPrimerApellido() + " " + paciente.getSegundoApellido();
        tituloPacienteLabel.setText(titulo);
        manejadorTabs.setSelectedComponent(vistaPacientePanel);
        tipoIdentificacionText.setText(paciente.getTipoDocumento());
        identificacionText.setText(paciente.getNumeroDocumento());
        primerNombreText.setText(paciente.getPrimerNombre());
        segundoNombreText.setText(paciente.getSegundoNombre());
        primerApellidoText.setText(paciente.getPrimerApellido());
        segundoApellidoText.setText(paciente.getSegundoApellido());
        fechaNacimientoText.setText(paciente.getFechaNacimiento());
        generoText.setText(paciente.getSexo());
        naturalDeText.setText(paciente.getNaturalDe());
        procedenteDeText.setText(paciente.getProcedenteDe());
        direccionText.setText(paciente.getDireccion());
        telefonoText.setText(paciente.getTelefono());
        celularText.setText(paciente.getCelular());
        mailText.setText(paciente.getMail());
        acompañanteText.setText(paciente.getAcompaniante());
        telefonoAcompañanteText.setText(paciente.getTelAcompaniante());

        tableModel = new DefaultTableModel();
        tablaCitas.setModel(tableModel);

        ArrayList<Consulta> citas = main.darCitasPaciente(paciente);

        String[] colName = {"Fecha","Motivo","Descripcion"};

        tableModel.setColumnIdentifiers(colName);
        for (Consulta consulta : citas) {
            String data[] = new String[3];
            data[0] = consulta.getFecha();
            data[1] = consulta.getMotivoConsulta();
            data[2] = consulta.getDescripcion();
            tableModel.addRow(data);
        }
        tablaCitas.setModel(tableModel);
        tablaCitas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaCitas.getColumnModel().getColumn(0).setPreferredWidth(120);
        tablaCitas.getColumnModel().getColumn(1).setMinWidth(400);
        tablaCitas.getColumnModel().getColumn(2).setMinWidth(5000);

        MouseListener tableMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object selected = tableModel.getValueAt(tablaCitas.getSelectedRow(),0);
                System.out.println(selected);
            }
        };

        tablaCitas.addMouseListener(tableMouseListener);

        for (JTextField text : detallePacienteTexts) {
            text.setEnabled(false);
        }
        DefaultListModel respuesta = new DefaultListModel();
        for (Object cita : citas) {
            respuesta.addElement(cita);
        }
        citasLabel.setText("Número de citas atendidas: " + citas.size());
    }

    public HCLimei(Main main) {
        this.main = main;
        this.detallePacienteTexts = new ArrayList<>();
        this.detallePacienteTexts.add(tipoIdentificacionText);
        this.detallePacienteTexts.add(identificacionText);
        this.detallePacienteTexts.add(primerNombreText);
        this.detallePacienteTexts.add(segundoNombreText);
        this.detallePacienteTexts.add(primerApellidoText);
        this.detallePacienteTexts.add(segundoApellidoText);
        this.detallePacienteTexts.add(fechaNacimientoText);
        this.detallePacienteTexts.add(edadText);
        this.detallePacienteTexts.add(generoText);
        this.detallePacienteTexts.add(profesionText);
        this.detallePacienteTexts.add(naturalDeText);
        this.detallePacienteTexts.add(procedenteDeText);
        this.detallePacienteTexts.add(direccionText);
        this.detallePacienteTexts.add(direccionText);
        this.detallePacienteTexts.add(telefonoText);
        this.detallePacienteTexts.add(celularText);
        this.detallePacienteTexts.add(mailText);
        this.detallePacienteTexts.add(acompañanteText);
        this.detallePacienteTexts.add(parentescoText);
        this.detallePacienteTexts.add(telefonoAcompañanteText);
        this.detallePacienteTexts.add(captacionText);
        this.detallePacienteTexts.add(rhText);

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
                tableModelBusqueda = new DefaultTableModel();
                tablaBusqueda.setModel(tableModelBusqueda);
                ArrayList<Paciente> pacientes = main.buscarPaciente(textoABuscarText.getText(),String.valueOf(
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
                        verDetallePaciente(main.verPaciente(selected));
                    }
                };

                tablaBusqueda.addMouseListener(tableMouseListener);
            }
        });
        editarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JTextField text : detallePacienteTexts) {
                    consultaPanel.setSelectedComponent(datosPacientePanel);
                    text.setEnabled(true);
                    editarInformacionButton.setVisible(false);
                    guardarInformacionButton.setVisible(true);
                }
            }
        });
        crearPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorTabs.setSelectedComponent(consultaPanel);
            }
        });
        continuarMotivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultaPanel.setSelectedComponent(motivoYAntecedentesPanel);
            }
        });
        continuarRevisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultaPanel.setSelectedComponent(revisionPanel);
            }
        });
        guardarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JTextField text : detallePacienteTexts) {
                    text.setEnabled(false);
                }
                editarInformacionButton.setVisible(true);
                guardarInformacionButton.setVisible(false);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        String[] criterios = {"Nombre","Identificación"};
        DefaultListModel modelo = new DefaultListModel();
        criterioBusquedaComboBox = new JComboBox(criterios);
        tablaCitas = new JTable();
        tablaBusqueda = new JTable();
        tableModel = (DefaultTableModel) tablaCitas.getModel();
        tableModelBusqueda = (DefaultTableModel) tablaBusqueda.getModel();
        scrollerTable = new JScrollPane(tablaCitas, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollerBusqueda = new JScrollPane(tablaBusqueda, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        guardarInformacionButton = new JButton("Guardar información");
        guardarInformacionButton.setVisible(false);
    }
}
