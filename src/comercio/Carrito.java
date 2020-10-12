package comercio;
import java.security.InvalidParameterException;
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
	
	public Carrito(LocalDate fecha, LocalTime hora,
			boolean cerrado, double descuento, Cliente cliente, Entrega entrega, int id) {
				
		this.id = id;
		setFecha(fecha);
		setHora(hora);
		setCerrado(cerrado);
		setDescuento(descuento);
		setEntrega(entrega);
		setCliente(cliente);
		lstItemcarrito = new ArrayList<Itemcarrito>();
	}
	public Carrito(LocalDate fecha, LocalTime hora,
			boolean cerrado, double descuento, Cliente cliente, int id) {
				
		this.id = id;
		setFecha(fecha);
		setHora(hora);
		setCliente(cliente);
		//Cuando se crea no debería autosetearse en false? Y después en el total carrito o algun otro lado que 
		//se cambie a true? 
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
		if (fecha != null) {
			this.fecha = fecha;
		}else {
			throw new InvalidParameterException("[WARNING] La fecha no puede ser nula");
		}
	}


	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		if(hora!=null) {
			this.hora = hora;
		}else {
			throw new InvalidParameterException("[WARNING] La hora no puede ser nula");
		}
	}
	//Esto no debería ser getCerrado? 
	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	protected void setDescuento(double descuento) {
		if (descuento>=0) {
			this.descuento = descuento;
		}else {
			throw new InvalidParameterException("[WARNING] El descuento debe ser mayor o igual a cero");
		}
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
		
	public int traerIndiceItem(Articulo articulo)//Devuelve la posicion del item o -1 si no se encuentra en la lista
	{
		int retorno=-1;
		int contador=0;
		boolean encontre = false;
		
		while(contador<lstItemcarrito.size()&&!encontre)
		{
			if(lstItemcarrito.get(contador).getArticulo().equals(articulo))
			{
				retorno=contador;
				encontre = true;
			}
			contador++;
		}
		
		return retorno;
	}
	
	//Caso de Uso 8	
	public boolean agregarItem(Articulo articulo, int cantidad)
	{
		int indiceItem=traerIndiceItem(articulo);
		
		if(indiceItem!=-1)//Si esta
			{
				lstItemcarrito.get(indiceItem).setCantidad(lstItemcarrito.get(indiceItem).getCantidad()+cantidad);
			}
			
		if(indiceItem==-1)//Si no esta
		{
			Itemcarrito iCarrito = new Itemcarrito(cantidad,articulo);
			lstItemcarrito.add(iCarrito);
		}
		return true;
	}
	
	public boolean borrarItem(Articulo articulo, int cantidad)
	{
		int indiceItem=traerIndiceItem(articulo);
		
		if(indiceItem!=-1)//Si esta
			{
				int cantidadExistente=lstItemcarrito.get(indiceItem).getCantidad(); 
				if(cantidadExistente==cantidad)
				{
					lstItemcarrito.remove(indiceItem);
				} 
				if(cantidadExistente>cantidad)
				{
					lstItemcarrito.get(indiceItem).setCantidad(cantidadExistente-cantidad);
				}
				
			        if(cantidadExistente<cantidad)
				{
					throw new InvalidParameterException("[WARNING] La cantidad a borrar es mayor que la existente en el carrito");
				}
			}
			
		if(indiceItem==-1)//Si no esta
		{
			throw new InvalidParameterException("[WARNING]El producto no se encuentra en el carrito");
		}
		return true;
	}
	
	public boolean equals(Carrito carrito)
	{
		return this.id==carrito.getId();
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
		//Faltaría chequear que la lista no este vacia? 
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
	
	//CU 15
	public double totalAPagarCarrito() {
		double parcial;
		double total;
		if(!lstItemcarrito.isEmpty()) {
			parcial = calcularTotalCarrito() * getDescuento()/100;
			total = calcularTotalCarrito() - parcial;
			return total;
		}
		else {
			throw new InvalidParameterException("El carrito no contiene items aún cargados.");
		}
	}
	
	
	
}
