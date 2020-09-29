package comercio;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;


public class Carrito{

	private static int cantidad = 0;
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private ArrayList<Itemcarrito> lstItemcarrito;
	private Entrega entrega;
	
	public Carrito(LocalDate fecha, LocalTime hora,
			boolean cerrado, double descuento, Cliente cliente, Entrega entrega) {
				
		this.id = Carrito.cantidad;
		setFecha(fecha);
		setHora(hora);
		setCerrado(cerrado);
		setDescuento(descuento);
		setLstItemcarrito(lstItemcarrito);
		setEntrega(entrega);
		lstItemcarrito = new ArrayList<Itemcarrito>();
		Carrito.cantidad++;
		
	}
	public Carrito(LocalDate fecha, LocalTime hora,
			boolean cerrado, double descuento, Cliente cliente) {
				
		this.id = Carrito.cantidad;
		setFecha(fecha);
		setHora(hora);
		setCerrado(cerrado);
		setDescuento(descuento);
		setLstItemcarrito(lstItemcarrito);
		setEntrega(null);
		lstItemcarrito = new ArrayList<Itemcarrito>();
		
	}

	public int getId() {
		return id;
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
		
	public boolean agregarItem(Articulo articulo, int cantidad)
	{
		int c=0;
		boolean encontre = false;
		while(c<lstItemcarrito.size()&&!encontre)
		{
			if(lstItemcarrito.get(c).getArticulo().equals(articulo))
			{
				lstItemcarrito.get(c).setCantidad(lstItemcarrito.get(c).getCantidad()+cantidad);
				encontre = true;
			}
			c++;
		}
		
		if(!encontre)
		{
			Itemcarrito iCarrito = new Itemcarrito(cantidad,articulo);
			lstItemcarrito.add(iCarrito);
		}
		return true;
	}
	
	public boolean equals(Comercio comercio)
	{
		return this.id==comercio.getId();
	}

	@Override
	public String toString() {
		String str = "Id carrito: "+ id + "\nFecha: "+fecha+ "\nHora: "+ hora + " cerrado: " + cerrado + "\nDescuento: " +descuento+ 
					"\nLista de items en carrito: " + lstItemcarrito;
		if(entrega!=null){
			str = str + "\n Entrega: "+entrega.toString();
		}
		return str;
	}

	//CU 10
	public double calcularTotalCarrito(){
		double total = 0;
		for (Itemcarrito itemcarrito : lstItemcarrito) {
			total+=itemcarrito.calcularSubTotalItem();
		}
		return total;
	}

	//CU 11
	public double calcularDescuentoDia (int diaDescuento, double porcentajeDescuentoDia){
		//  this.fecha.getDayOfWeek().getValue()
		if (diaDescuento == this.fecha.getDayOfWeek().getValue()){
			double porcentaje = porcentajeDescuentoDia/100.0;//Lo hago asuminedo que el numero que se me pasa esta entre [0;100]

			double viejoTotal = calcularTotalCarrito();

			double nuevoTotal = viejoTotal - viejoTotal * porcentaje;

			return nuevoTotal;
		}else{
			throw new InvalidParameterException("El dia de descuento no concuerda con la fecha del carrito");
		}
		
	}

	//CU 12
	public double calcularDescuentoEfectivo (double porcentajeDescuentoEfectivo){
		double porcentaje = porcentajeDescuentoEfectivo/100.0;//Lo hago asuminedo que el numero que se me pasa esta entre [0;100]

		double viejoTotal = calcularTotalCarrito();

		double nuevoTotal = viejoTotal - viejoTotal * porcentaje;

		return nuevoTotal;
	}
	//CU 13
	public void calcularDescuentoCarrito (int diaDescuento, double porcentajeDescuentoDia, double porcentajeDescuentoEfectivo){
		double totalDescuentoDia = 0;
		boolean elDiaDescuentoEsCorrecto = true;
		try {
			totalDescuentoDia = calcularDescuentoDia(diaDescuento, porcentajeDescuentoDia);
		} catch (Exception e) {
			elDiaDescuentoEsCorrecto = false;
		}
		
		double totatDescuentoEfectuvi = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);

		if (!elDiaDescuentoEsCorrecto){
			setDescuento(porcentajeDescuentoEfectivo);
		}
		else if (totalDescuentoDia>=totatDescuentoEfectuvi){
			setDescuento(porcentajeDescuentoEfectivo);
		}else{
			setDescuento(porcentajeDescuentoDia);
		}
	}
}
	
	
	
