package TPE;

public class PocionValorFijo extends PocionSimple{
	
	public PocionValorFijo(String nombre, int valor) {
		super(nombre, valor);
	}
	
	@Override
	public int calcularValor(Atributo a) {
		return this.getValor();
	}
	

}
