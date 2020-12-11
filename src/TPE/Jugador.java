package TPE;


public class Jugador {

	private String nombre;
	private Mazo mazo;
	private Estrategia estrategia;
	
	public Jugador(String nombre, Estrategia estrategia) {
		this.nombre=nombre;
		this.estrategia=estrategia;
	}

	public String getNombre() {
		return nombre;
	}
	public Carta getCarta() {
		return mazo.getCarta();
	}
	
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}

	public Mazo getMazo() {
		return mazo;
	}
	public int cartasDisponibles() {
		return mazo.tamanio();
	}
	
	public Carta darCarta() {
		Carta aux = mazo.getCarta();
		mazo.eliminarCartaJugada();
		return aux;
	}
	
	public void devolverCarta() {
		mazo.ultimaCarta();
	}
	
	public Jugador enfrentarse(Jugador j) {
		if(getCarta().compararCarta(j.getCarta(),getAtributoSelecionado())) {
			this.getMazo().añadirCarta(j.darCarta());
			this.devolverCarta();
			return this;
		}else if(j.getCarta().compararCarta(getCarta(),getAtributoSelecionado())) {
			j.getMazo().añadirCarta(this.darCarta());
			j.devolverCarta();
			return j;
		}else
			this.devolverCarta();
			j.devolverCarta();
			return null;
	}
	
	public int getAtributoSelecionado() {
		return estrategia.atributoElegido(getCarta());
	}
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
	public boolean equals(Object o) {
		try {
			Jugador jugador = (Jugador) o;
			return this.getNombre().equals(jugador.getNombre());
		}catch(Exception exc){
			return false;
		}
	}
	
}
