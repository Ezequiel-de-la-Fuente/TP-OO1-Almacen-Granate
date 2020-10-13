package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import comercio.Contacto;
import comercio.Envio;
import comercio.Ubicacion;
import comercio.Articulo;

import comercio.Cliente;
import comercio.Comercio;
import comercio.RetiroLocal;
import comercio.Turno;

public class TestCasosDeUsoGeneral {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		  LocalDate dia=null;
		  Contacto contacto = new Contacto("almacen@gmail.com", "11 3123 7897", new Ubicacion(-34.7373213, -58.3892883));
		  Comercio almacen = new Comercio(0,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		  
		  Contacto contactoAna = new Contacto("anafc@gmail.com", "11 3030 3456", new Ubicacion(-34.8250834,-58.3943303));
		  Cliente clienteAna=new Cliente(1,contactoAna,"Fernandez","Ana",36500548);
		  
		  Contacto contactoMaxi = new Contacto("abbruzzesemax@gmail.com", "11 5160 9898" ,new Ubicacion(28, 15));
		  Cliente clienteMaxi = new Cliente(2, contactoMaxi, "Abbruzzese","Maximiliano", 38154177);
		
		  Contacto contactoLucas = new Contacto("lucas.brieva@gmail.com", "11 3487 9463", new Ubicacion(30, 50));
		  Cliente clienteLucas = new Cliente(3, contactoLucas, "Brieva","Lucas", 39664602);
			
		  Contacto contactoEze = new Contacto("ezequieldelafuente2001@gmail.com", "11 3633 6131", new Ubicacion(60, 50));
		  Cliente clienteEze = new Cliente(4, contactoEze, "De La Fuente","Ezequiel", 42568324);
		  
		  Articulo pepas = new Articulo("Pepas Pig","7791762131394" , 9.50);
		  Articulo choco = new Articulo("Chocolate Milka","9780425270721" , 80.50);
		  Articulo papas = new Articulo("Papas Lays","7791274198991" , 20.00);
		  Articulo cocacola = new Articulo("Coca-Cola", "7790070411365", 125);
	          Articulo manaos = new Articulo("Manaos","7790070411365",50);
		  
	          Envio envio1 = new Envio(LocalDate.now(), true, LocalTime.of(20, 00, 00), LocalTime.of(18, 00, 00), 8, new Ubicacion(-34.8080732,-58.3981827));
		  RetiroLocal retiroLocal1 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(12,30));  
		  RetiroLocal retiroLocal2 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(13,30)); 
		  RetiroLocal retiroLocal3 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(13,00)); 
		  
		  almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10,envio1, clienteAna);
		  almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10,retiroLocal1, clienteMaxi);
		  almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10,retiroLocal2, clienteLucas);
		  almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10,retiroLocal3, clienteEze);
       
		  almacen.agregarDiaRetiro(1, LocalTime.of( 11, 00), LocalTime.of( 20, 30),30);
		  almacen.agregarDiaRetiro(2,LocalTime.of( 10, 30), LocalTime.of( 19, 30),30);
		  almacen.agregarDiaRetiro(3,LocalTime.of(11, 30), LocalTime.of( 21, 00),30);
		  
		  almacen.traerCarritoPorCliente(clienteAna).agregarItem(pepas, 3);
		  almacen.traerCarritoPorCliente(clienteMaxi).agregarItem(manaos, 10);
		  almacen.traerCarritoPorCliente(clienteMaxi).agregarItem(pepas, 7);
		  almacen.traerCarritoPorCliente(clienteMaxi).agregarItem(choco, 4);
		  almacen.traerCarritoPorCliente(clienteMaxi).agregarItem(papas, 2);
		  almacen.traerCarritoPorCliente(clienteLucas).agregarItem(manaos, 1);
		  almacen.traerCarritoPorCliente(clienteLucas).agregarItem(papas, 5);
		  almacen.traerCarritoPorCliente(clienteEze).agregarItem(cocacola, 2);
		 
		
		 System.out.println(almacen);
		 
		 List<Turno> turnoLibre = almacen.generarAgenda(LocalDate.now());
			System.out.println("\n--AGENDA DE TURNOS--");
			for(Turno turno : turnoLibre) {
				dia = turno.getDiaTurno();
			}
			System.out.println("Dia: " + dia);
			for (Turno turno : turnoLibre) {
				if(turno.isOcupado() == false) {
				System.out.println("Hora:"  + turno.getHoraTurno() + " - Estado:Disponible");
			}	else {
				System.out.println("Hora:"  + turno.getHoraTurno() + " - Estado:Ocupado");
			}
			
	}
	}
}

