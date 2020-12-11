package TPE;

public class PocionSelectiva extends PocionSimple{

	private String atributo;
	
	public PocionSelectiva(String nombre, int valor, String atributo) {
		super(nombre, valor);
		this.atributo=atributo;
	}

	@Override
	public int calcularValor(Atributo a) {
		if(a.getName().equalsIgnoreCase(atributo))
		return a.getValor()*this.getValor();
		else
			return 0;
	}
	
}
