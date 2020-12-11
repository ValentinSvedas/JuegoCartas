package TPE;


public abstract class SistemaPocion{
	
	private String nombre;
	
	public SistemaPocion(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public abstract int calcularValor(Atributo a);
	
	@Override
	public String toString() {
		return	getNombre();
	}
	/*
	Fortalecedora
	Fija
	Selectiva
	
	Cocktail ArrayList<Pocimas>
	
	CocktailComp(probable)
	Setters
	
	
	Parte 2
	
	Estretegia por parametro jugador
	Estretegia clase
	clase dependiendo de la Estretegia
	seter de estretegia
	
	
	Detalles
	
	*/
	
}
