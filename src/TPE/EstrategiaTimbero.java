package TPE;

public class EstrategiaTimbero extends Estrategia{

	@Override
	public int atributoElegido(Carta c) {
			int rn=(int) Math.floor(Math.random()*c.cantidadAtributos());
			return rn;
	}

}
