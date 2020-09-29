package comercio;

import java.security.InvalidParameterException;
import java.util.ArrayList;

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
			throw new InvalidParameterException("[WARNING] El cuit ingresado es inválido");
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
	
	
}
