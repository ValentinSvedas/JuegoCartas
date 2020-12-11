package TPE;

public class PocionPorcentaje extends PocionSimple{
		
		public PocionPorcentaje(String nombre, int valor) {
			super(nombre, valor);
		}

		@Override
		public int calcularValor(Atributo a) {
			return (a.getValor()*this.getValor())/100;
		}
		
	
		
}
