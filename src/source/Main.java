package source;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Main {

	public static String SEPARATOR = "\t\t\t\t\t\t\t\t";

	private static String userName;
	private static String password;
	private static Connection conn;
	private static String database;

	public void generarRIPS(EntidadAdministradora entidad, PrestadorServiciosSalud prestador, Date fechaInicioRIPS, Date fechaFinalRIPS) {
		String fInicio = fechaInicioRIPS.toLocaleString();
		fInicio = fInicio.substring(0,fInicio.indexOf(" "));
		String fFinal = fechaFinalRIPS.toLocaleString();
		fFinal = fFinal.substring(0,fFinal.indexOf(" "));
		RIPS rips = new RIPS(entidad, prestador, fInicio, fFinal);
	}

	public static Connection getConnection() throws SQLException,ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, connectionProps);
		System.out.println("Connected to database " + database);
		return conn;
	}

	public Paciente verPaciente(String id){
		Paciente paciente = null;
		try {
			Statement s = conn.createStatement();
			String query = "SELECT * FROM pacientes WHERE id_paciente = '" + id + "';";
			System.out.println(query);
			ResultSet r = s.executeQuery(query);
			if (r.next()) {
				String tipoIdentificacion = r.getString(2);
				String numIdentificacion = r.getString(3);
				String fechaNacimiento = r.getString(4);
				String nombre1 = r.getString(5);
				String nombre2 = r.getString(6);
				String apellido1 = r.getString(7);
				String apellido2 = r.getString(8);
				String genero = r.getString(9);
				String naturalDe = r.getString(16);
				String procedenteDe = r.getString(17);
				String direccion = r.getString(18);
				String telefono = r.getString(19);
				String celular = r.getString(20);
				String mail = r.getString(23);
				String acompañante = r.getString(33);
				String telAcompañante = r.getString(35);
				paciente = new Paciente(id, tipoIdentificacion,numIdentificacion,fechaNacimiento,nombre1,nombre2,apellido1,apellido2,
						genero,naturalDe,procedenteDe,direccion,telefono,celular,mail,acompañante,telAcompañante);
				return paciente;
			}
			r.close();
			s.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return paciente;
	}

	public ArrayList<Paciente> buscarPaciente(String textoABuscar, String criterio) {
		ArrayList<Paciente> pacientes = new ArrayList<>();
		try {
			Statement s = conn.createStatement();
			textoABuscar = textoABuscar.trim();
			textoABuscar = textoABuscar.toUpperCase();
			String query = null;
			if (criterio.equals("Nombre")) {
				query = "SELECT id_paciente,num_identificacion,nombre1,nombre2,apellido1,apellido2 FROM pacientes WHERE nombre1 LIKE '" +
						textoABuscar + "%' OR nombre2 LIKE '" + textoABuscar + "%' OR apellido1 LIKE '" + textoABuscar + "%' OR " +
						"apellido2 LIKE '%" + textoABuscar + "';";
			} else if (criterio.equals("Identificación")) {
				query = "SELECT id_paciente,num_identificacion,nombre1,nombre2,apellido1,apellido2  FROM pacientes WHERE " +
						"CAST(num_identificacion AS CHAR) LIKE '" + textoABuscar + "%';";
			}
			System.out.println(query);
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				String idPaciente = r.getString(1);
				String identificacion = r.getString(2);
				String nombre1 = r.getString(3);
				String nombre2 = r.getString(4);
				String apellido1 = r.getString(5);
				String apellido2 = r.getString(6);
				Paciente paciente = new Paciente(idPaciente,identificacion,nombre1,nombre2,apellido1,apellido2);
				pacientes.add(paciente);
			}
			s.close();
			r.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return pacientes;
	}

	public ArrayList<Consulta> darCitasPaciente(Paciente paciente) {
		ArrayList<Consulta> citas = new ArrayList<>();
		try {
			Statement s = conn.createStatement();
			String query = "SELECT * FROM motivo_consulta WHERE id_paciente = '" + paciente.getIdPaciente() + "' ORDER BY fecha_consulta DESC;";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				String fecha = r.getString(4);
				String idCodigo = r.getString(7);
				String motivoConsulta = r.getString(2);
				String descripcion = r.getString(3);
				Consulta consulta = new Consulta(fecha,paciente,idCodigo,motivoConsulta,descripcion);
				citas.add(consulta);
			}
			s.close();
			r.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return citas;
	}

	public static void main(String[] args) {
		userName = "root";
		password = "1234";
		database = "hclimei";
		try {
			conn = getConnection();

//			Process p = new ProcessBuilder("postgres -D /usr/local/var/postgres").start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Main _this = new Main();

		JFrame frame = new JFrame("HCLimei");
		frame.setContentPane(new HCLimei(_this).getPanel1());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		Date date = new Date();
		String dat = date.toLocaleString();
		System.out.println(dat.substring(0,dat.indexOf(" ")));
	}
}
