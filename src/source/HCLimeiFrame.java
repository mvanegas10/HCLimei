package source;

import javax.swing.*;

/**
 * Created by Meili on 12/29/16.
 */
public class HCLimeiFrame {

    /**
     * Link to the main class
     */
    private Main main;

    /**
     * First panel in hierarchy
     */
    private JPanel groupPanel;

    /**
     * Tabbed pane
     */
    private JTabbedPane tabbedPane;

    /**
     * Vista inicial
     */
    private InicioPanel inicioPanel;

    /**
     * Vista búsqueda
     */
    private BusquedaPanel busquedaPanel;

    /**
     * Vista paciente
     */
    private PacientePanel pacientePanel;

    /**
     * Constructor of the class
     * @param main
     */
    public HCLimeiFrame(Main main) {
        this.main = main;
        this.inicioPanel = new InicioPanel(this);
        this.busquedaPanel = new BusquedaPanel(this);
        this.pacientePanel = new PacientePanel(this);
        this.tabbedPane.add("Inicio",inicioPanel.getInicioPanel());
        this.tabbedPane.add("Búsqueda",busquedaPanel.getBusquedaPanel());
        this.tabbedPane.add("Vista paciente",pacientePanel.getVistaPacientePanel());
    }

    public Main getMain() {
        return main;
    }

    public JPanel getGroupPanel() {
        return groupPanel;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JPanel getBusquedaPanel() {
        return busquedaPanel.getBusquedaPanel();
    }

    public JPanel getPacientePanel() {
        return pacientePanel.getVistaPacientePanel();
    }

    public void verPaciente(String selected) {
        pacientePanel.verDetallePaciente(main.verPaciente(selected));
    }
}
