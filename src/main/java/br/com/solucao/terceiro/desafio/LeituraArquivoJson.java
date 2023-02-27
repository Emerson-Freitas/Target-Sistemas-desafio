package br.com.solucao.terceiro.desafio;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class LeituraArquivoJson {

    public JSONObject lerAquivoJson(String caminhoArquivo) throws FileNotFoundException {
        FileReader fileReader = new FileReader(caminhoArquivo);
        JSONParser jsonParser = new JSONParser();

        try(fileReader) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            return jsonObject;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

}
