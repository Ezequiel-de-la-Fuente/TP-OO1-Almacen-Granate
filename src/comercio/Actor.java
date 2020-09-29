package comercio;
import java.security.InvalidParameterException;

public abstract class Actor {
  
  protected int id;
	protected Contacto contacto;
	
	public Actor(int id, Contacto contacto)
	{
		setId(id);
		setContacto(contacto);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Contacto getContacto() {
		return contacto;
	}
	
	public void setContacto(Contacto contacto) {
		if(contacto!=null) {
			this.contacto = contacto;			
		}else {
			throw new InvalidParameterException("[WARNING] El contacto no debe ser nulo");
		}
	}
	
	public abstract boolean validarIdentificadorUnico();
	
	public boolean equals(Actor actor)
	{
		return this.id==actor.getId();
	}
	
	Ubicacion traerUbicacion()
	{
		if(contacto==null)
		{
			throw new InvalidParameterException("[WARNING] El contacto es nulo");
		}
	   return contacto.getUbicacion();
	}

	@Override
	public String toString() {
		return "id=" + id + "\n" + contacto.toString();
	}
	

}
