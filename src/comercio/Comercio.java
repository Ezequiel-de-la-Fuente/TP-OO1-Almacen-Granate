package comercio;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Comercio extends Actor {
	
	private String nombreComercio;
	private String cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private ArrayList<DiaRetiro> lstDiaRetiro;
	private ArrayList<Carrito> lstCarrito;
	
	public Comercio(int id, Contacto contacto,String nombreComercio, String cuit, double costoFijo, double costoPorKm, int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo)
	{
		super(id, contacto);
		setNombreComercio(nombreComercio);
		setCuit(cuit);
		setCostoFijo(costoFijo);
		setCostoPorKm(costoPorKm);
		setDiaDescuento(diaDescuento);
		setPorcentajeDescuentoDia(porcentajeDescuentoDia);
		setPorcentajeDescuentoEfectivo(porcentajeDescuentoEfectivo);
		lstDiaRetiro = new ArrayList<DiaRetiro>();
		lstCarrito   = new ArrayList<Carrito>(); 
		
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		
		this.cuit = cuit;
		validarIdentificadorUnico();
	}
	
	public boolean validarIdentificadorUnico()
	{
		boolean esValido=false;
		
		String parte = cuit.replaceAll("-",""); 
		int[] cadenaProductos = new int[]{5,4,3,2,7,6,5,4,3,2}; 
		
		if (Integer.parseInt(cuit.substring(0,2))==30)
		{
			int acumulador =0;
			for (int n=0; n<10;n++) 
			{
				acumulador  = acumulador + ((Character.getNumericValue(parte.charAt(n))) * cadenaProductos[n]);
			}
			int ultimoDigitoCuit=acumulador%11;
			if(ultimoDigitoCuit!=0)
			{
				ultimoDigitoCuit=11-ultimoDigitoCuit;
			}
			
			esValido = ultimoDigitoCuit == Character.getNumericValue(cuit.charAt(12));
		
		}
		
		if(!esValido)
		{
			throw new InvalidParameterException("[WARNING] El cuit ingresado es invÃƒÂ¡lido");
		}
		
		return esValido;
	}
	
	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	public ArrayList<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public void setLstDiaRetiro(ArrayList<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}

	public ArrayList<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(ArrayList<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	
	public boolean equals(Comercio comercio)
	{
		return this.id==comercio.getId();
	}

	@Override
	public String toString() {
		return super.toString()+"\nNombre: "+ nombreComercio + "\nCuit: "+cuit+ "\nCosto Fijo: "+ costoFijo + " Costo Por KM: " + costoPorKm + "\nDia de Descuento: " + diaDescuento + " Porcentaje Descuento Por dia: " + porcentajeDescuentoDia +"%"+ " Porcentaje Descuento por Efectivo: "+porcentajeDescuentoEfectivo
				+"%"+"\nDias de Retiro: " + lstDiaRetiro.toString()+"\nLista de carritos: " + lstCarrito.toString();
	}
	
	public int getIndiceDiaSemana(LocalDate fecha) {
		
		int indiceDiaSemana= -5; // 
		for( int i=0; i < lstDiaRetiro.size();i++) {   // 
				if(fecha.getDayOfWeek().getValue() == lstDiaRetiro.get(i).getDiaSemana()) { // 
				indiceDiaSemana=i;
			}
			
		}
		return indiceDiaSemana;
	}
	
		
		public boolean getEstado(LocalTime hora) { //este metodo es para saber si el turno esta ocupado(devuelve true) o no (devuelve false) 
		boolean estado = false; //creamos un booleano llamado estado que devuelve false
		if(lstDiaRetiro != null) { //si la lista dia Retiro no esta vacia
			for(int i = 0; i < lstCarrito.size() ; i++) { //obtenemos el tamaño de nuestra lista de carritos
				Entrega entrega = lstCarrito.get(i).getEntrega(); //instanciamos una entrega para guardar la que tiene en posicion "i" la lista de carrito
				if(entrega instanceof RetiroLocal) { //si la entrega es de tipo retiro local
					LocalTime horaDeEntrega = ((RetiroLocal)entrega).getHoraEntrega(); //instanciamos un objeto de tipo localtime para guardar la "hora entrega" de Retiro local
					if(hora.equals(horaDeEntrega)) { //si la "hora desde" que ingreso en el metodo es igual a la "Hora de entrega" de retiro local
						estado = true; // el booleano cambia devuelve false
					}
				}
			}
		}
		return estado;
	}
	// CU 2.
	public LocalTime traerHoraRetiro(LocalDate fecha) throws Exception {
		int indiceDiaSemana = getIndiceDiaSemana(fecha);
		if(indiceDiaSemana ==  -5)  //si no hay ningun dia que coincida significa que el local no abre
			throw new Exception("No se realizan entregas en la fecha ingresada!!!"+ fecha);
		LocalTime hora = lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();
		boolean turnoLibre = false;
		while(!turnoLibre) {
			if(getEstado(hora)) {
				turnoLibre = true;
			}
			else {
				hora = hora.plusMinutes(lstDiaRetiro.get(indiceDiaSemana).getIntervalo());	
			}
		}
		return hora;
	}
	
	// CU 3.
	public List<Turno> generarTurnosLibres(LocalDate fecha) throws Exception{ // creamos el metodo de tipo "Lista" de turnos
		
		List<Turno> agenda = new ArrayList<Turno>(); //instanciamos una lista de turnos llamada agenda
				
		int indiceDiaSemana= getIndiceDiaSemana(fecha); //instanciamos un obj. de tipo int donde se va a guardar el dia de la fecha ingresada
				
		if(indiceDiaSemana > 7 || indiceDiaSemana < 1) //creamos la excepcion en caso que no sea valido el dia
			throw new Exception("En la fecha ingresada no se realizan entregas!"+ fecha); 
		
		LocalTime hora= lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();//instanciamos un objeto de tipo LocalTime para guardar
		                                                                // la "hora desde" (apertura de comercio) de la fecha ingresada
		
		while (hora.isBefore(lstDiaRetiro.get(indiceDiaSemana).getHoraHasta())) { // mientras la "hora desde" sea menor a "hora hasta" del comercio
			boolean ocupado = getEstado(hora); // creamos un booleando "ocupado" donde guardamos 
			if(ocupado == false) {   //si ocupado es false
			Turno turno = new Turno(fecha , hora, ocupado); // instanciamos un turno y lo agregamos a la lista
			agenda.add(turno); //
			}
			hora= hora.plusMinutes(lstDiaRetiro.get(indiceDiaSemana).getIntervalo());// Le agregamos el intervalo a la hora desde de dia retiro
		
		}
		return agenda; //retornamos una lista de turnos
	   }
	// CU 4.
	public List<Turno> generarTurnosOcupados(LocalDate fecha) throws Exception{ // 
		
		List<Turno> agenda = new ArrayList<Turno>(); //
		
		int indiceDiaSemana= getIndiceDiaSemana(fecha); // 	
		
		if(indiceDiaSemana > 7 || indiceDiaSemana < 1) //
			throw new Exception("En la fecha ingresada no se realizan entregas!"+ fecha); 
		
		LocalTime hora= lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();//  
		while (hora.isBefore(lstDiaRetiro.get(indiceDiaSemana).getHoraHasta())) { // 
			boolean ocupado = getEstado(hora);
			if(ocupado == true) {
			Turno turno = new Turno(fecha , hora, ocupado); // 
			agenda.add(turno); // 
			}
			hora= hora.plusMinutes(lstDiaRetiro.get(indiceDiaSemana).getIntervalo());// 
		}
		return agenda; //
	   }
	// CU 5.
	public List<Turno> generarAgenda(LocalDate fecha) throws Exception{ // 
		
		List<Turno> agenda = new ArrayList<Turno>();
		boolean ocupado;
		int indiceDiaSemana= getIndiceDiaSemana(fecha);; // 
		if(indiceDiaSemana ==  -5)
			throw new Exception("En la fecha ingresada no se realizan entregas!"+ fecha);
		
		LocalTime hora= lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();//
		while (hora.isBefore(lstDiaRetiro.get(indiceDiaSemana).getHoraHasta())) { // 
			ocupado=getEstado(hora); //Reutilización
			Turno turno = new Turno(fecha , hora, ocupado); //
			hora= hora.plusMinutes(lstDiaRetiro.get(indiceDiaSemana).getIntervalo());// 
			agenda.add(turno);
		}
		return agenda;
	   }
	// CU 6.
	public boolean agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int
			intervalo) throws Exception {
		int idDiaRetiro = 1; 
		if(getLstDiaRetiro().size() != 0) {
			idDiaRetiro = lstDiaRetiro.get(getLstDiaRetiro().size() -1).getId() +1;
		}
		
		DiaRetiro nuevoDiaRetiro = new DiaRetiro(idDiaRetiro, diaSemana, horaDesde, horaHasta, intervalo);
		
		for(int i = 0; i<lstDiaRetiro.size(); i++) {
			if(nuevoDiaRetiro.equals(lstDiaRetiro.get(i))) {
				throw new Exception("El d�a ya existe." + nuevoDiaRetiro);
			}
		}
		lstDiaRetiro.add(nuevoDiaRetiro);
		return true;
		
	}
	
}
