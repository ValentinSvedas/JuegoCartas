package TPE;

public class PocionSimple extends SistemaPocion{
	
	private int valor;

	public PocionSimple(String nombre, int valor) {
		super(nombre);
		this.valor=valor;
	}

	@Override
	public int calcularValor(Atributo a) {
		return a.getValor();
	}

	public int getValor() {
		return valor;
	}	
	
}
