package br.com.solucao.terceiro.desafio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LeituraArquivoJson {

    public JSONArray lerAquivoJson(String caminhoArquivo) throws FileNotFoundException {
        FileReader fileReader = new FileReader(caminhoArquivo);
        JSONParser jsonParser = new JSONParser();

        try(fileReader) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            return jsonArray;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

}
