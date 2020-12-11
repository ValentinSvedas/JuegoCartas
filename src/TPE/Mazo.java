package TPE;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo{

	private ArrayList<Carta> cartas;
	
	public Mazo() {
		this.cartas=new ArrayList<>();
	}

	public void añadirCarta(Carta c) {//Añade personaje sin que se repita un existente
		if(!cartas.contains(c)) {
			if(cartas.size()==0)
			cartas.add(c);
			else if(c.cantidadAtributos()==getCarta().cantidadAtributos()) 
				cartas.add(c);
			}
	}
	
	public void eliminarCartaJugada() {
		if(cartas.size()>0) {
			cartas.remove(0);
		}
	}
	
	public void ultimaCarta() {
		Carta aux = cartas.get(0);
		this.eliminarCartaJugada();
		this.añadirCarta(aux);
	}
	
	public Carta getCarta(){
		if(cartas.size()>0)
			return cartas.get(0);
		else 
			return null;
	}
	public Carta getCartaAt(int i){
		if(cartas.size()>0)
			return cartas.get(i);
		else 
			return null;
	}
	
	public void repartirCartas(Jugador j1, Jugador j2) {
		Mazo m1 = new Mazo();
		Mazo m2 = new Mazo();
		for(int i = 0; i<this.tamanio();i++) {
			m1.añadirCarta(this.getCartaAt(i));
			if(i+1<this.tamanio()) {
				i++;
				m2.añadirCarta(this.getCartaAt(i));
			}
		}
		j1.setMazo(m1);
		j2.setMazo(m2);
	}
	
	public void mezclarMazo() {
		Collections.shuffle(cartas);
	}
	
	public int tamanio() {
		return cartas.size();
	}
	public void insertarPociones(ArrayList<SistemaPocion> pociones) {
		for(int i =0; i<pociones.size();i++) {
			this.cartas.get(i).setPocima(pociones.get(i));
		}
	}
	
	
	
}
