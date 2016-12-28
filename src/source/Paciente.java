package source;

import java.util.Date;

public class Paciente {

	/**
	 * Id del paciente
	 */
	private String idPaciente;

	/**
	 * Primer nombre del paciente
	 */
	private String primerNombre;
	
	/**
	 * Segundo nombre del paciente
	 */
	private String segundoNombre;
	
	/**
	 * Primer apellido del paciente
	 */
	private String primerApellido;
	
	/**
	 * Segundo apellido del paciente
	 */
	private String segundoApellido;

	/**
	 * Tipo de documento del paciente
	 */
	private String tipoDocumento;
	
	/**
	 * Numero documento del paciente
	 */
	private String numeroDocumento;

	/**
	 * Tipo de usuario (Usualmente es Vinculado: 3)
	 */
	private String tipoAfiliado;
	
	/**
	 * Fecha de nacimiento del paciente
	 */
	private String fechaNacimiento;
	
	/**
	 * Sexo del paciente
	 */
	private String sexo;

	/**
	 * Orientacion sexual del paciente
	 */
	private String orientacionSexual;
	
	/**
	 * Religion del paciente
	 */
	private String religion;
	
	/**
	 * Ocupacion del paciente
	 */
	private String ocupacion;
	
	/**
	 * Profesion del paciente
	 */
	private String profesion;
	
	/**
	 * Escolaridad del paciente
	 */
	private String escolaridad;
	
	/**
	 * Estado civil del paciente
	 */
	private String estadoCivil;
	
	/**
	 * Natural de del paciente
	 */
	private String naturalDe;
	
	/**
	 * Procedente de del paciente
	 */
	private String procedenteDe;
	
	/**
	 * Direccion del paciente
	 */
	private String direccion;
	
	/**
	 * Telefono del paciente
	 */
	private String telefono;

	/**
	 * Celular del paciente
	 */
	private String celular;
	
	/**
	 * Mail del paciente
	 */
	private String mail;
	
	/**
	 * Acompaniante del paciente
	 */
	private String acompaniante;

	/**
	 * Telefono del Acompaniante del paciente
	 */
	private String telAcompaniante;

	/**
	 * Departamento de residencia actual
	 */
	private Departamento departamento; 
	
	/**
	 * Municipio de residencia actual
	 */
	private Municipio municipio;

	public Paciente(String idPaciente, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
		this.idPaciente = idPaciente;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.numeroDocumento = numeroDocumento;
	}

	public Paciente(String id, String tipoIdentificacion,String numIdentificacion,String fechaNacimiento,String nombre1,String nombre2,String apellido1,String apellido2,
					String genero,String naturalDe, String procedenteDe, String direccion,String telefono,String celular,String mail, String acompaniante, String telAcompaniante){
		this.idPaciente = id;
		this.tipoDocumento = tipoIdentificacion;
		this.numeroDocumento = numIdentificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.primerNombre = nombre1;
		this.segundoNombre = nombre2;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
		this.sexo = genero;
		this.naturalDe = naturalDe;
		this.procedenteDe = procedenteDe;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		this.mail = mail;
		this.acompaniante = acompaniante;
		this.telAcompaniante = telAcompaniante;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getTipoAfiliado() {
		return tipoAfiliado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getOrientacionSexual() {
		return orientacionSexual;
	}

	public String getReligion() {
		return religion;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public String getProfesion() {
		return profesion;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getNaturalDe() {
		return naturalDe;
	}

	public String getProcedenteDe() {
		return procedenteDe;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCelular() {
		return celular;
	}

	public String getMail() {
		return mail;
	}

	public String getAcompaniante() {
		return acompaniante;
	}

	public String getTelAcompaniante() {
		return telAcompaniante;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public String toString(){
		return idPaciente + "\t\t\t\t\t\t\t\t" + numeroDocumento + "\t\t\t\t\t\t\t\t" + primerNombre + "\t" + segundoNombre + "\t" + primerApellido + "\t" + segundoApellido;
	}
}
