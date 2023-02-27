package br.com.solucao;

import java.util.Objects;
import java.util.Scanner;

public class SegundoDesafio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        var numero = scanner.nextInt();

        var pertenceFibonacci = calculaSequenciaFibonacci(numero);

        if(pertenceFibonacci){
            System.out.println("O número " + numero + " pertence a sequência de Fibonacci");
        }else{
            System.out.println("O número " + numero + " não pertence a sequência de Fibonacci");
        }

    }

    public static boolean calculaSequenciaFibonacci(Integer numero){

        int a = 0;
        int b = 1;

        while(b < numero){
            int variavelAuxiliar = b;
            b = a + b;
            a = variavelAuxiliar;
        }

        return b == numero;
    }
}
