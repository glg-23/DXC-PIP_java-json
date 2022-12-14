package jsonParsing.jsonSimple;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {

        System.out.println("DXC-PIP progetto per creazione e lettura di un file JSON con org.json.simple");

        JSONObject elencoRicette = new JSONObject();
        JSONArray ricetta = new JSONArray();


        //versione 1 (creare json direttamente nel main)
        /*
            JSONObject ricetta1 = new JSONObject();
            JSONObject ricetta2 = new JSONObject();

            ricetta1.put("categoria", "primi");
            ricetta1.put("nome", "pasta");
            ricetta1.put("ingredienti", "pasta, pomodoro");
            ricetta1.put("colore", "yellow");

            ricetta2.put("categoria", "secondi");
            ricetta2.put("nome", "carne");
            ricetta2.put("ingredienti", "carne, sale, olio");
            ricetta2.put("colore", "orange");
        */


        //versione 2 (creare json da RicettaJsonSimple)
        RicettaJsonSimple ricetta1 = new RicettaJsonSimple(1, "primi", "pasta", "pasta, pomodoro", "yellow");
        RicettaJsonSimple ricetta2 = new RicettaJsonSimple(2, "secondi", "carne", "carne, sale, olio", "orange");

        ricetta.add(ricetta1);
        ricetta.add(ricetta2);


        //ok per tutte le versioni
        elencoRicette.put("elenco ricette", ricetta);

        System.out.println(elencoRicette);

        try (FileWriter file = new FileWriter("elencoRicetteJsonSimple.json")) {
            elencoRicette.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
