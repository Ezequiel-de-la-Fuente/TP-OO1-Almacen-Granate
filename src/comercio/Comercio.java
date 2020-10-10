package comercio;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

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
			throw new InvalidParameterException("[WARNING] El cuit ingresado es invÃ¡lido");
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
	// CU 3.
	public List<Turno> generarTurnosLibres(LocalDate fecha) throws Exception{ // 
		
		List<Turno> agenda = new ArrayList<Turno>();
		Iterator <DiaRetiro> mi_iterator = lstDiaRetiro.iterator();
		
		int indiceDiaSemana= -5; // 
		
		
		
		while (mi_iterator.hasNext()) {   // 
			                                              //
			int i= 0;
			if(fecha.getDayOfWeek().getValue() == lstDiaRetiro.get(i).getDiaSemana()) { // 
				indiceDiaSemana=i;
				
			}
			i=i+1;
		}
		
		
		
		if(indiceDiaSemana ==  -5)
			throw new Exception("En la fecha ingresada no se realizan entregas!"+ fecha);
		
		LocalTime hora= lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();//
		
		while (hora.isBefore(lstDiaRetiro.get(indiceDiaSemana).getHoraHasta())) { // 
			for(int i=0;i< lstDiaRetiro.size();i++) { // 
				Entrega entrega = lstCarrito.get(i).getEntrega(); //
				if(entrega instanceof RetiroLocal) { // 
					if(hora != ((RetiroLocal) entrega).getHoraEntrega()){ // 
						Turno turno = new Turno(fecha , hora, false); // 
						agenda.add(turno); //
					}
					
				}
			}
			hora= hora.plusMinutes(lstDiaRetiro.get(indiceDiaSemana).getIntervalo());// 
		}
		return agenda;
	   }
	
	// CU 4.
	public List<Turno> generarTurnosOcupados(LocalDate fecha) throws Exception{ // Retorna una lista de objetos de tipo Turno
		
		List<Turno> agenda = new ArrayList<Turno>(); //creamos la agenda que retornaremos con nuestros turnos ocupados
		Iterator <DiaRetiro> mi_iterator = lstDiaRetiro.iterator(); //iterador para recorrer la lista dia retiro
		
		int indiceDiaSemana= -5; // 
		
		
		while (mi_iterator.hasNext()) {    // Recorremos toda la lista DiaRetiro 
			                                              
			int i= 0;		
			if(fecha.getDayOfWeek().getValue() == lstDiaRetiro.get(i).getDiaSemana()) { //Si el dia de la semana de la fecha ingresada es igual al dia de la semana que abre el comercio. 
				indiceDiaSemana=i; // el indice de la semana va a ser el del dia que abre el local en valor numero de 1 a 7.
			}
			i=i+1;
		}
		
		
		
		if(indiceDiaSemana ==  -5)  //si no hay ningun dia que coincida significa que el local no abre
			throw new Exception("No se realizan entregas en la fecha ingresada!!!"+ fecha);
		
		LocalTime hora= lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();// creamos la variable hora y guardamos la "hora desde" del dia de la semana que abre nuestro comercio.
		
		while (hora.isBefore(lstDiaRetiro.get(indiceDiaSemana).getHoraHasta())) { // mientras la horadesde sea menor a la hora hasta
			for(int i=0;i< lstCarrito.size();i++) { // recorro la lista de carritos para ver cuantos tipos de entrega hay
				Entrega entrega = lstCarrito.get(i).getEntrega(); //guardo la entrega "i" de la lista en entrega y chequeo si es envio o retiro local.
				if(entrega instanceof RetiroLocal) { // Si entrega es de tipo retiro local(para hacer
					if(hora == ((RetiroLocal) entrega).getHoraEntrega()){ // Si la horadesde es igual a : casto de clase: la hora entrega de retiro local como entrega
						Turno turno = new Turno(fecha , hora, true); // creamos un turno asignando: fecha ingresada, horadesde del dia que abre, true=ocupado.
						agenda.add(turno); // agregamos el turno a nuestra lista de turnos ocupos
					}
				}
			}
			hora= hora.plusMinutes(lstDiaRetiro.get(indiceDiaSemana).getIntervalo());// le agregamos el intervalo a la horadesde
		}
		return agenda; //retornamos la agenda
	   }
	// CU 5.
public List<Turno> generarAgenda(LocalDate fecha) throws Exception{ // 
		
		List<Turno> agenda = new ArrayList<Turno>();
		Iterator <DiaRetiro> mi_iterator = lstDiaRetiro.iterator();
		boolean ocupado;
		
		int indiceDiaSemana= -5; // 
		
		
		
		while (mi_iterator.hasNext()) {   // 
            //
        int i= 0;
               if(fecha.getDayOfWeek().getValue() == lstDiaRetiro.get(i).getDiaSemana()) { // 
               indiceDiaSemana=i;

               }
         i=i+1;
         }
		
		if(indiceDiaSemana ==  -5)
			throw new Exception("En la fecha ingresada no se realizan entregas!"+ fecha);
		
		LocalTime hora= lstDiaRetiro.get(indiceDiaSemana).getHoraDesde();//
		
		while (hora.isBefore(lstDiaRetiro.get(indiceDiaSemana).getHoraHasta())) { // 
			ocupado=false;
			
			for(int i=0;i< lstDiaRetiro.size();i++) { // 
				Entrega entrega = lstCarrito.get(i).getEntrega();
				
				if(entrega instanceof RetiroLocal) { // 
					
					if(hora == ((RetiroLocal) entrega).getHoraEntrega()){ //  
						ocupado= true; // 					
					}
				}
			}
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
				throw new Exception("El día ya existe." + nuevoDiaRetiro);
			}
		}
		lstDiaRetiro.add(nuevoDiaRetiro);
		return true;
		
	}
	
}
