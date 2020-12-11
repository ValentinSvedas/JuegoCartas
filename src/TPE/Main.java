package TPE;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {
	
	public static Mazo cargarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        Mazo auxMazo = new Mazo();
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                ArrayList<Atributo> aux= new ArrayList<>();
                for (String nombreAtributo:atributos.keySet()) {
                	aux.add(new Atributo(nombreAtributo, atributos.getInt(nombreAtributo)));
                }
                Carta a = new Carta(nombreCarta, aux);
                auxMazo.añadirCarta(a);
            }
            
            reader.close();
    
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return auxMazo;
    }
	
public static void main(String args[]) {
	ArrayList<SistemaPocion> pociones= new ArrayList<>();
	
	PocionPorcentaje p1= new PocionPorcentaje("Fortalecedora", 120);
	PocionSelectiva p2= new PocionSelectiva("FurzaSelectiva", 120,"fuerza");
	PocionValorFijo p3= new PocionValorFijo("MagicaWea", 999);
	PocionSuma p4= new PocionSuma("PocionUpgrade", 1200);
	PocionComp p5 = new PocionComp("PocionCocktail");
	PocionPorcentaje p6= new PocionPorcentaje("Fortalecedora", 120);
	PocionSelectiva p7= new PocionSelectiva("FurzaSelectiva", 120,"fuerza");
	PocionValorFijo p8= new PocionValorFijo("MagicaWea", 999);
	PocionSuma p9= new PocionSuma("PocionUpgrade", 1200);
	PocionComp p10 = new PocionComp("PocionCocktail");
	
	p5.addPocion(p1);
	p5.addPocion(p3);
	p10.addPocion(p7);
	p10.addPocion(p8);
	
	pociones.add(p1);
	pociones.add(p2);
	pociones.add(p3);
	pociones.add(p4);
	pociones.add(p5);
	pociones.add(p6);
	pociones.add(p7);
	pociones.add(p8);
	pociones.add(p9);
	pociones.add(p10);
	
	
	EstrategiaAmbicioso EA= new EstrategiaAmbicioso();
	EstrategiaObstinado EO= new EstrategiaObstinado(1);
	EstrategiaTimbero RNG= new EstrategiaTimbero();
	
	Jugador juno = new Jugador("Jorge",EA);
	Jugador jdos = new Jugador("Pepe",RNG);
	
	Game g1 = new Game(juno,jdos);
	String mazoPathHeores = "./superheroes.json";
	String mazoPathAutos = "./automoviles.json";
	Mazo m1 = cargarMazo(mazoPathHeores);
	Mazo m2 = cargarMazo(mazoPathAutos);
	m2.insertarPociones(pociones);
	m2.mezclarMazo();
	m2.repartirCartas(juno, jdos);
	 g1.jugar();

	 
	}
}
