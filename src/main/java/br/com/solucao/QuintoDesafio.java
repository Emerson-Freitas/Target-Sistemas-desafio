package br.com.solucao;

import java.util.Scanner;

public class QuintoDesafio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma String: ");
        var stringInput = scanner.next();

        var stringInvertida = inverterCaracteresString(stringInput);
        System.out.println("Palavra invertida: " + stringInvertida);
        System.out.println("Palavra normal: " + stringInput);
    }

    public static String inverterCaracteresString(String palavra){

        char[] caracteres = palavra.toCharArray();

        for(int i = 0; i < caracteres.length / 2; i++){
            char temp = caracteres[i];
            caracteres[i] = caracteres[caracteres.length - 1 - i];
            caracteres[caracteres.length - 1 - i] = temp;
        }

        return new String(caracteres);
    }
}
