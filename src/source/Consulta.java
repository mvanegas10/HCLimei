package source;

import java.util.Date;

public class Consulta {
	
	public final static String PRIMERA_VEZ = "890202";
	
	public final static String CONTROL = "890302";
	
	/**
	 * Fecha de la consulta
	 */
	private String fecha;
	
	/**
	 * Paciente
	 */
	private Paciente paciente;
	
	/**
	 * Tipo de la consulta (Primera vez o control)
	 */
	private String codigoConsulta;
	
	/**
	 * Diagnostico del paciente en esta consulta
	 */
	private String diagnostico;

	/**
	 * Valor total de la consulta
	 */
	private double valorConsulta;

	/**
	 * Valor del pago que debe hacer el usuario del servicio, como cuota de recuperacion, cuota moderadora o copago
	 */
	private double coutaModeradora;

	/**
	 * Motivo consulta
	 */
	private String motivoConsulta;

	/**
	 * Descripcion
	 */
	private String descripcion;




	/**
	 * Constructor de una consulta
	 * @param fecha
	 * @param paciente
	 * @param codigoConsulta
	 * @param diagnostico
	 * @param valorConsulta
	 * @param coutaModeradora
	 */
	public Consulta(String fecha, Paciente paciente, String codigoConsulta,
			String diagnostico, double valorConsulta, double coutaModeradora) {
		super();
		this.fecha = fecha;
		this.paciente = paciente;
		this.codigoConsulta = codigoConsulta.equals("1")? "Primera vez": "Control";
		this.diagnostico = diagnostico;
		this.valorConsulta = valorConsulta;
		this.coutaModeradora = coutaModeradora;
	}

	public Consulta(String fecha, Paciente paciente, String codigoConsulta, String motivoConsulta, String descripcion) {
		this.fecha = fecha;
		this.paciente = paciente;
		this.codigoConsulta = codigoConsulta.equals("1")? "Primera vez": "Control";
		this.motivoConsulta = motivoConsulta;
		this.descripcion = descripcion;
	}

	public static String getPrimeraVez() {
		return PRIMERA_VEZ;
	}

	public static String getCONTROL() {
		return CONTROL;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(String codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public double getCoutaModeradora() {
		return coutaModeradora;
	}

	public void setCoutaModeradora(double coutaModeradora) {
		this.coutaModeradora = coutaModeradora;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return fecha + Main.SEPARATOR + motivoConsulta + Main.SEPARATOR + descripcion;
	}


}
