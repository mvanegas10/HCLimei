package source;

import java.util.Date;

public class Consulta {
	
	public final static String PRIMERA_VEZ = "890202";
	
	public final static String CONTROL = "890302";
	
	/**
	 * Fecha de la consulta
	 */
	private Date fecha;
	
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
	 * Constructor de una consulta
	 * @param fecha
	 * @param paciente
	 * @param codigoConsulta
	 * @param diagnostico
	 * @param valorConsulta
	 * @param coutaModeradora
	 */
	public Consulta(Date fecha, Paciente paciente, String codigoConsulta,
			String diagnostico, double valorConsulta, double coutaModeradora) {
		super();
		this.fecha = fecha;
		this.paciente = paciente;
		this.codigoConsulta = codigoConsulta;
		this.diagnostico = diagnostico;
		this.valorConsulta = valorConsulta;
		this.coutaModeradora = coutaModeradora;
	}
	
	
}
