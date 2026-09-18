package cine;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Cliente {
	private String nombre;
	private int dni;
	private int id;
	private static int idCliente = 1;
	private ArrayList<CompraCliente> listaCompras;
	private LocalDate fechaNacimiento;
	
	public Cliente(String nombre, int dni, LocalDate fechaNacimiento) {
		this.nombre=nombre;
		this.dni=dni;
		this.id=idCliente;
		idCliente++;
		this.fechaNacimiento=fechaNacimiento;
		this.listaCompras=new ArrayList<CompraCliente>();
	}

	@Override
	public String toString() {
		return "#"+ id + "- " + nombre + "- dni=" + dni + " - fecha de nacimiento= " + fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<CompraCliente> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<CompraCliente> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void modificarCliente(Cine cine) {
		String menu="";
		while (!menu.equals("Volver")) {
			menu=Utilidades.seleccionMenu("Modificar Cliente", toString());
			switch(menu) {
			case "Modificar nombre":
				String nombre=Utilidades.validarString("Elegir nuevo nombre\n Nombre actual: " + getNombre());
				setNombre(nombre);
				break;
			case "Modificar dni":
				boolean dnirepetido=true;
				int dni = 0;
					while (dnirepetido) {
					dnirepetido=false;
					dni = Utilidades.validarInt("Ingrese el dni \n Dni actual: " + getDni(), 1, Integer.MAX_VALUE);
					for (Iterator<Cliente> iterator = cine.getListaClientes().iterator(); iterator.hasNext();) {
						Cliente cliente = (Cliente) iterator.next();
						if(dni==cliente.getDni()){
							dnirepetido=true;
							JOptionPane.showMessageDialog(null, "Ya existe ese dni en el sistema");
						}
					}
				}
				setDni(dni);
				break;
			case "Modificar fecha de nacimiento":
				boolean valido = false;
				LocalDate fechaNac=null;
				while(!valido) {
					String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento en formato AAAA-MM-DD \n Fecha de nacimiento actual:" + getFechaNacimiento());
					if (fechaString!=null) {
						String[] fechaArray = fechaString.split("-");
						if (fechaArray.length ==3) {
						try {
							int anio = Integer.parseInt(fechaArray[0].trim());
							int mes = Integer.parseInt(fechaArray[1].trim());
							int dia = Integer.parseInt(fechaArray[2].trim());
							try {
								fechaNac= LocalDate.of(anio, mes, dia);
								LocalDate hoy = LocalDate.now();
								Period edad = Period.between(fechaNac, hoy);
								if (edad.getYears()>=11) {
								valido = true;
								setFechaNacimiento(fechaNac);
								} else {
									JOptionPane.showMessageDialog(null, "Fecha inválida. Se debe tener al menos 11 años para registrarse");
								}
							} catch (DateTimeException e) {
								JOptionPane.showMessageDialog(null, "Fecha inválida. Formato válido AAAA-MM-DD");
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Fecha inválida. Formato válido AAAA-MM-DD");
						}
					}}
				}

			}
		}
	}
	public void nuevaCompra(Cine cine) {
		Funcion funcion =cine.seleccionarFuncionActiva();
		LocalDate fechaNac = getFechaNacimiento();
		LocalDate fechaFuncion = funcion.getFecha();
		Period edad = Period.between(fechaNac, fechaFuncion);
		if (edad.getYears()<funcion.edadMinima()) {
			JOptionPane.showMessageDialog(null, "Este cliente no tiene la edad adecuanda para ver esa película");
		} else {
		int maxTickets = funcion.getSala().getCapacidad()-funcion.getTicketsVendidos();
		if (maxTickets==0) {
			JOptionPane.showMessageDialog(null, "No quedan tickets disponibles para esa función");
		} else {
		int tickets = Utilidades.validarInt("Ingrese la cantidad de tickets a comprar\n Tickets disponibles: " +maxTickets+" - Precio unitario: $" + funcion.getPrecio() ,1, maxTickets);
		String confirmarCompra = Utilidades.seleccionMenu("Confirmar", "¿Desea confirmar la compra? \n Tickets: " + tickets + " Precio total: $"+ funcion.getPrecio()*tickets);
		if (confirmarCompra.equals("Sí")) {
			CompraCliente compra = new CompraCliente(tickets, funcion);
			listaCompras.add(compra);
			funcion.setTicketsVendidos(funcion.getTicketsVendidos()+tickets);
		}}}
	}
	public CompraCliente seleccionarCompra() {
		CompraCliente a=null;
		if (listaCompras.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El cliente no tiene compras en el sistema");
		} else {
		
			while(a==null) {
				a=(CompraCliente)JOptionPane.showInputDialog(null, "Seleccione una compra", null, 
		                JOptionPane.QUESTION_MESSAGE, null, listaCompras.toArray(), listaCompras.toArray()[0]);		
				if (a==null) {
					JOptionPane.showMessageDialog(null, "Seleccione una compra de la lista");
				} 
			}}
		return a;
	}
}
