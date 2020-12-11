package TPE;

public class EstrategiaAmbicioso extends Estrategia{

	@Override
	public int atributoElegido(Carta c) {
		int AtributoMayor = 0;
		int aux=0;
		for(int i=0;i<c.cantidadAtributos();i++) {
			if (c.selecAtributoValor(i)> AtributoMayor) {
				AtributoMayor = c.selecAtributoValor(i);
				aux =i;
			}
		}
		return aux;
	}

	
	
}
