package comercio;

public class Cliente extends Actor {
     
	 private String apellido;
     private String nombres;
     private int dni;
	
     public Cliente(int id, Contacto contacto, String apellido, String nombres, int dni ) 
     {
    	//TODO: no esta implementada la clase Actor
		super(id, contacto);
		setApellido(apellido);
		setNombres(nombres);
		setDni(dni);
	 }

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
		validarIdentificadorUnico();
	}
	
	public boolean validarIdentificadorUnico()
    	{
    	String auxiliar = Integer.toString(dni);
    	boolean retorno = false;
    	
    	if(auxiliar.length()==8)
    	{
    		retorno = true;
    	}
    	else
    	{
    		throw new InvalidParameterException("[WARNING] El dni ingresado es inválido");
    	}
    	
    	return retorno;
    	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
     
    public boolean equals(Cliente cliente)
    {
    	return super.equals(cliente)&&(this.dni==cliente.getDni());
    }

	@Override
	public String toString() {
		return super.toString() + "Nombres: " + nombres + "Apellido: " + apellido + "DNI: " + dni;
	}
    
    
}
