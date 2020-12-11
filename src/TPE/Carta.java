package TPE;

import java.util.ArrayList;

public class Carta {
	
	private String personaje;
	
	private ArrayList<Atributo> atributos;
	private SistemaPocion pocima;
	
	public Carta(String personaje, ArrayList<Atributo> atributos) {
		this.personaje=personaje;
		this.atributos=atributos;
	}
	public void setPocima(SistemaPocion pocima) {
		this.pocima = pocima;
	}
	public SistemaPocion getPocima() {
		return pocima;
	}
	public int valorPocima(int n) {
		return pocima.calcularValor(atributos.get(n));
	}
	
	public String getPersonaje() {
		return personaje;
	}
	
	public boolean tienePocion() {
		return pocima!=null;
	}
	
	public int selecAtributoValor(int n) {		
		if(pocima!=null) {
			return valorPocima(n);
		}
		else
			return atributos.get(n).getValor();
	}
	public int ValorSinPocion(int n) {
		return atributos.get(n).getValor();
	}
	
	public String selecAtributoNombre(int n) {
		return atributos.get(n).getName();
	}
	
	public int cantidadAtributos() {
		return atributos.size();
	}
	
	public boolean compararCarta(Carta c, int n) {
		if(selecAtributoValor(n)>c.selecAtributoValor(n))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return	getPersonaje();
	}
	@Override
	public boolean equals(Object o1) {
		try {
			Carta c = (Carta) o1;
			return this.getPersonaje().equals(c.getPersonaje());
			
		}catch(Exception exc) {
			return false;
		}
	}
	
}
