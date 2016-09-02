package source;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public class RIPS {
	
	/**
	 * Entidad administradora
	 */
	private EntidadAdministradora entidad;
	
	/**
	 * Prestador de servicios de salud
	 */
	private PrestadorServiciosSalud prestador;
	
	/**
	 * Fecha de remision
	 */
	private String fechaRemision;
	
	/**
	 * Fecha de inicio que abarcan los RIPS
	 */
	private String fechaInicioRIPS;

	/**
	 * Fecha de finalizacion que abarcan los RIPS
	 */
	private String fechaFinalRIPS;

	public RIPS(EntidadAdministradora entidad,
			PrestadorServiciosSalud prestador, String fechaInicioRIPS,
			String fechaFinalRIPS) {
		super();
		this.entidad = entidad;
		this.prestador = prestador;
		this.fechaInicioRIPS = fechaInicioRIPS;
		this.fechaFinalRIPS = fechaFinalRIPS;
		Date date = new Date();
		String dat = date.toLocaleString();
		this.fechaRemision = dat.substring(0,dat.indexOf(" "));
	}
	
	public void generarArchivos(String folder) throws FileNotFoundException{
		
		
		
		
		
		
	}
	
	public void generarArchivoTransacciones(String folder) throws IOException {
		BufferedWriter writerAF = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(folder + "/AF" + this.fechaRemision + ".txt")));
	}

	public void generarArchivoUsuarios(String folder) throws IOException {
		BufferedWriter writerUS = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(folder + "/US" + this.fechaRemision + ".txt")));
	}
	
	public void generarArchivoConsulta(String folder) throws IOException {
		BufferedWriter writerAC = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(folder + "/AC" + this.fechaRemision + ".txt")));
	}
	
	public void generarArchivoControl(String folder) throws IOException {
		BufferedWriter writerCT = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(folder + "/CT" + this.fechaRemision + ".txt")));
		writerCT.write("");
		writerCT.close();
	}
}
