package source;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Meili on 12/29/16.
 */
public class PacientePanel {
    private JPanel principalPanel;
    private JPanel vistaPacientePanel;
    private JPanel detallePacientePanel;
    private JLabel primerNombreLabel;
    private JLabel primerApellidoLabel;
    private JLabel fechaNacimientoLabel;
    private JLabel segundoNombreLabel;
    private JTextField segundoNombreText;
    private JTextField primerApellidoText;
    private JLabel segundoApellidoLabel;
    private JTextField segundoApellidoText;
    private JLabel edadLabel;
    private JTextField edadText;
    private JTextField tipoIdentificacionText;
    private JLabel identificacionLabel;
    private JTextField identificacionText;
    private JLabel generoLabel;
    private JTextField fechaNacimientoText;
    private JTextField generoText;
    private JLabel profesionLabel;
    private JTextField profesionText;
    private JLabel departamentoNacimientoLabel;
    private JTextField primerNombreText;
    private JLabel municipioNacimientoLabel;
    private JLabel tipoIdentificacionLabel;
    private JTextField direccionText;
    private JLabel direccionLabel;
    private JTextField telefonoText;
    private JLabel telefonoLabel;
    private JLabel celularLabel;
    private JTextField celularText;
    private JLabel mailLabel;
    private JTextField mailText;
    private JLabel acompañanteLabel;
    private JTextField acompañanteText;
    private JLabel parentescoLabel;
    private JTextField parentescoText;
    private JTextField telefonoAcompañanteText;
    private JLabel telefonoAcompañanteLabel;
    private JLabel captacionLabel;
    private JTextField rhText;
    private JLabel rhLabel;
    private JTextField captacionText;
    private JTextField naturalDeText;
    private JTextField procedenteDeText;
    private JLabel tituloPacienteLabel;
    private JButton editarInformacionButton;
    private JButton iniciarConsultaDetalleButton;
    private JButton guardarInformacionButton;
    private JLabel citasLabel;
    private JScrollPane scrollerTable;
    private JTable tablaCitas;
    private HCLimeiFrame hclimei;
    private DefaultTableModel tableModel;
    private ArrayList<JTextField> detallePacienteTexts;

    public PacientePanel(HCLimeiFrame hclimei) {
        this.hclimei = hclimei;
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

        editarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JTextField text : detallePacienteTexts) {
                    text.setEnabled(true);
                    editarInformacionButton.setVisible(false);
                    guardarInformacionButton.setVisible(true);
                }
            }
        });
        guardarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public JPanel getVistaPacientePanel() {
        return vistaPacientePanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        guardarInformacionButton = new JButton("Guardar información");
        guardarInformacionButton.setVisible(false);
    }

    public void verDetallePaciente(Paciente paciente) {

        String titulo = (paciente.getSegundoApellido() != null)? paciente.getPrimerNombre() + " " +  paciente.getSegundoNombre() + " "
                + paciente.getPrimerApellido() + " " + paciente.getSegundoApellido(): paciente.getPrimerNombre() + " " +
                paciente.getPrimerApellido() + " " + paciente.getSegundoApellido();
        tituloPacienteLabel.setText(titulo);
        hclimei.getTabbedPane().setSelectedComponent(vistaPacientePanel);
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

        ArrayList<Consulta> citas = hclimei.getMain().darCitasPaciente(paciente);

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

//        MouseListener tableMouseListener = new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                Object selected = tableModel.getValueAt(tablaCitas.getSelectedRow(),0);
//                System.out.println(selected);
//            }
//        };
//
//        tablaCitas.addMouseListener(tableMouseListener);

        for (JTextField text : detallePacienteTexts) {
            text.setEnabled(false);
        }
        DefaultListModel respuesta = new DefaultListModel();
        for (Object cita : citas) {
            respuesta.addElement(cita);
        }
        citasLabel.setText("Número de citas atendidas: " + citas.size());
    }
}
