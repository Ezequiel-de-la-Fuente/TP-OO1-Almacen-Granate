package comercio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;


public class Carrito{

	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private ArrayList<Itemcarrito> lstItemcarrito;
	private Entrega entrega;
	
	public Carrito(int id, LocalDate fecha, LocalTime hora,
			boolean cerrado, double descuento, Cliente cliente, ArrayList<Itemcarrito> lstItemcarrito,
			Entrega entrega) {
				
		setId(id);
		setFecha(fecha);
		setHora(hora);
		setCerrado(cerrado);
		setDescuento(descuento);
		setLstItemcarrito(lstItemcarrito);
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Itemcarrito> getLstItemcarrito() {
		return lstItemcarrito;
	}

	public void setLstItemcarrito(ArrayList<Itemcarrito> lstItemcarrito) {
		this.lstItemcarrito = lstItemcarrito;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
		
		
	public boolean equals(Comercio comercio)
	{
		return this.id==comercio.getId();
	}

	@Override
	public String toString() {
		return super.toString()+"Id carrito: "+ id + "\nFecha: "+fecha+ "\nHora: "+ hora + " cerrado: " + cerrado + "\nDescuento: " +descuento+ 
	          "\nLista de items en carrito: " + lstItemcarrito+"\n "+Entrega.toString(Entrega = new Entrega());
	}
	
	
	}
	
	
	