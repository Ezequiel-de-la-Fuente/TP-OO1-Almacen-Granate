package comercio;

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
		this.contacto=contacto;
	}
	
	public abstract boolean validarIdentificadorUnico();
	
	public boolean equals(Actor actor)
	{
		return this.id==actor.getId();
	}

	@Override
	public String toString() {
		return "id=" + id + contacto.toString();
	}
	

}
