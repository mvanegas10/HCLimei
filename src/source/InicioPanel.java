package source;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Meili on 12/29/16.
 */
public class InicioPanel {
    private JPanel inicioPanel;
    private JLabel controlLabel;
    private JLabel primeraVezLabel;
    private JButton consultaControlButton;
    private JButton crearPacienteButton;
    private JLabel generarRIPSLabel;
    private JLabel buscarPacienteLabel;
    private JButton buscarPacienteInicioButton;
    private JButton generarRIPSButton;
    private JPanel principalPanel;
    private HCLimeiFrame hclimei;

    public InicioPanel(HCLimeiFrame hclimei) {
        this.hclimei = hclimei;
        buscarPacienteInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hclimei.getTabbedPane().setSelectedComponent(hclimei.getBusquedaPanel());
            }
        });
    }

    public JPanel getInicioPanel() {
        return inicioPanel;
    }

    public JLabel getControlLabel() {
        return controlLabel;
    }

    public JLabel getPrimeraVezLabel() {
        return primeraVezLabel;
    }

    public JButton getConsultaControlButton() {
        return consultaControlButton;
    }

    public JButton getCrearPacienteButton() {
        return crearPacienteButton;
    }

    public JLabel getGenerarRIPSLabel() {
        return generarRIPSLabel;
    }

    public JLabel getBuscarPacienteLabel() {
        return buscarPacienteLabel;
    }

    public JButton getBuscarPacienteInicioButton() {
        return buscarPacienteInicioButton;
    }

    public JButton getGenerarRIPSButton() {
        return generarRIPSButton;
    }

    public JPanel getPrincipalPanel() {
        return principalPanel;
    }
}
