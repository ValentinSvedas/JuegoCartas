package TPE;

public class PocionSuma extends PocionSimple{

	public PocionSuma(String nombre, int valor) {
		super(nombre, valor);
	}
	@Override
	public int calcularValor(Atributo a) {
		return a.getValor()+this.getValor();
	}

}
