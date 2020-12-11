package TPE;

import java.util.ArrayList;

public class PocionComp extends SistemaPocion{
	
	ArrayList<SistemaPocion> pociones;

	public PocionComp(String nombre) {
		super(nombre);
		pociones= new ArrayList<>();
	}

	public void addPocion(SistemaPocion sistPocion) {
		pociones.add(sistPocion);
	}
	
	
	@Override
	public int calcularValor(Atributo a) {
		for(SistemaPocion sistPocima: pociones) {
			a.setValor(sistPocima.calcularValor(a));
		}
		return a.getValor();
	}

	
}
