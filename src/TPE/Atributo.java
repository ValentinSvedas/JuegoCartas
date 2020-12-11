package TPE;


public class Atributo{
	
	private String name;
	private int valor;
	
	public Atributo(String name, int valor) {
		this.name=name;
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}

	public String getName() {
		return name;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	
	
	@Override
	public String toString() {
		return "Atributo: "+getName() + " valor: "+getValor();
	}
	
	
}
