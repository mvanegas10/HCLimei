package source;

public class PrestadorServiciosSalud {

	/**
	 * Codigo del prestador
	 */
	private String codigo;
	
	/**
	 * Nombres del prestador
	 */
	private String nombres;
	
	/**
	 * Apellidos del prestador
	 */
	private String apellidos;
	
	/**
	 * Tipo de documento de identificacion del prestador
	 */
	private String tipoDocumento;
	
	/**
	 * Numero de documento de identificacion del prestador
	 */
	private String numeroDocumento;

	/**
	 * Cosntructor de prestador de servicios de salud
	 * @param codigo
	 * @param nombres
	 * @param apellidos
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public PrestadorServiciosSalud(String codigo, String nombres,
			String apellidos, String tipoDocumento, String numeroDocumento) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}
	
}
