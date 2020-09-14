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
		this.contacto = contacto;
	}
	
	public boolean equals(Actor act)
	{
		return this.id==act.id;
	}

	@Override
	public String toString() {
		return "id=" + id + contacto.toString();
	}
	

}
