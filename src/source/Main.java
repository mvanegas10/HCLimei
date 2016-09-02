package source;

import java.util.Date;

public class Main {

	public void generarRIPS(EntidadAdministradora entidad, PrestadorServiciosSalud prestador, Date fechaInicioRIPS, Date fechaFinalRIPS) {
		String fInicio = fechaInicioRIPS.toLocaleString();
		fInicio = fInicio.substring(0,fInicio.indexOf(" "));
		String fFinal = fechaFinalRIPS.toLocaleString();
		fFinal = fFinal.substring(0,fFinal.indexOf(" "));
		RIPS rips = new RIPS(entidad, prestador, fInicio, fFinal);
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		String dat = date.toLocaleString();
		System.out.println(dat.substring(0,dat.indexOf(" ")));
	}
}
