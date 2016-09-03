package source;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton button1;
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
    private JTextField textField1;
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
    private JTextField textField2;
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
    private JTextField textField3;
    private JPanel consultaPanel;
    private JTextArea motivoConsultaText;
    private JTextArea enferemedadActualText;
    private JLabel motivoConsultaLabel;
    private JLabel enfermedadActualLabel;
    private JLabel antecedentesPersonalesLabel;
    private JTextArea antecedentesPersonalesText;
    private JLabel antecedentesFamiliaresLabel;
    private JTextArea antecedentesFamiliaresText;
    private JList list1;
    private JLabel motivoYAntecedentesLabel;
    private JLabel generarRIPSLabel;
    private JLabel buscarPacienteLabel;
    private JButton buscarPacienteButton;
    private JButton generarRIPSButton;

    public HCLimei() {
        consultaControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorTabs.setSelectedComponent(busquedaPanel);
            }
        });
        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorTabs.setSelectedComponent(busquedaPanel);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HCLimei");
        frame.setContentPane(new HCLimei().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
