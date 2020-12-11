package TPE;

public class EstrategiaObstinado extends Estrategia{

	private int atributo;
	
	public EstrategiaObstinado(int a) {
		this.atributo = a;
	}

	@Override
	public int atributoElegido(Carta c) {
		return atributo;
	}

}
