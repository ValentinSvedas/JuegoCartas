package TPE;

public class Game {
	
	private Jugador juno;
	private Jugador jdos;
	private Jugador ganadorUltimaRonda;
	private boolean empate;
	public Game(Jugador uno, Jugador dos){
		this.juno=uno;
		this.jdos=dos;
		empate =false;
		ganadorUltimaRonda=juno;
	}
	
	public void jugar() {
		int i =0;
		while(juno.cartasDisponibles()>0 && jdos.cartasDisponibles()>0 &&  i != 50 ) {
			System.out.println("--------------" + " Ronda "+(i+1)+ "-------------------");
			jugarRonda();
			i++;
		}
	}
	public void setGanadorRonda(Jugador j) {
		if(j!=null)
			this.ganadorUltimaRonda=j;
		else {
			empate=true;
		}
	}
	public void jugarRonda() {
		Jugador ganador = ganadorUltimaRonda;
		Jugador perdedor= null;
		if(ganador==jdos) {
			perdedor = juno;
		}else if (ganador == juno) {
			perdedor = jdos;
		}
		System.out.println("El Jugador "+ ganador.getNombre() + " seleciona competir por el atributo "+ ganador.getCarta().selecAtributoNombre(ganador.getAtributoSelecionado()));
		System.out.print("La carta de "+ juno +" es "+ juno.getCarta() + " con "+ juno.getCarta().selecAtributoNombre(ganador.getAtributoSelecionado())+ " " +juno.getCarta().ValorSinPocion(ganador.getAtributoSelecionado()));
				if(juno.getCarta().tienePocion()) {
					System.out.println(", se aplicó pócima: "+ juno.getCarta().getPocima()+" valor resultante: " +juno.getCarta().selecAtributoValor(ganador.getAtributoSelecionado()));
				}else
					System.out.println("");
		System.out.print("La carta de "+ jdos +" es "+ jdos.getCarta() + " con "+ jdos.getCarta().selecAtributoNombre(ganador.getAtributoSelecionado())+ " " +jdos.getCarta().ValorSinPocion(ganador.getAtributoSelecionado()));
				if(jdos.getCarta().tienePocion()) {
					System.out.println(", se aplicó pócima: " + jdos.getCarta().getPocima()+" valor resultante: " +jdos.getCarta().selecAtributoValor(ganador.getAtributoSelecionado()));
				}else
					System.out.println("");
		setGanadorRonda(ganador.enfrentarse(perdedor));
		if(empate!=true) {
			System.out.println("Gana la ronda "+ ganadorUltimaRonda);	
		}else {
			System.out.println("Empate");
			empate = false;
		}
		System.out.println(jdos + " posee ahora "+ jdos.cartasDisponibles() + " cartas y "+ juno + " posee ahora "+ juno.cartasDisponibles() + " cartas");
	}
	
}
