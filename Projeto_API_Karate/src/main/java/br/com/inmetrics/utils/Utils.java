package br.com.inmetrics.utils;


import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {


    public static String generateName() {

        int i, nrRandomVowel, nrRandomConsonant;

        final String vowel[] = { "a", "e", "i", "o", "u" };
        String nameYou = "", name = "";
        final String consonant[] = {
                "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p",
                "q", "r", "s", "t", "w", "x", "y", "z"
        };
        final Random random = new Random();
        for (i = 0; i <= 8; i++) {
            nrRandomVowel = 0 + random.nextInt(4);
            nrRandomConsonant = 0 + random.nextInt(19);
            nameYou = vowel[nrRandomVowel] + consonant[nrRandomConsonant];
            name = name + "" + nameYou;
        }
        return name;
    }

    public static String generateCPF() throws Exception{

        int digito1 = 0, digito2 = 0, resto = 0;
        String  nDigResult;
        String numerosContatenados;
        String numeroGerado;

        Random numeroAleatorio = new Random();


        int n1 = numeroAleatorio.nextInt(10);
        int n2 = numeroAleatorio.nextInt(10);
        int n3 = numeroAleatorio.nextInt(10);
        int n4 = numeroAleatorio.nextInt(10);
        int n5 = numeroAleatorio.nextInt(10);
        int n6 = numeroAleatorio.nextInt(10);
        int n7 = numeroAleatorio.nextInt(10);
        int n8 = numeroAleatorio.nextInt(10);
        int n9 = numeroAleatorio.nextInt(10);


        int soma = n9*2 + n8*3 + n7*4 + n6*5 + n5*6 + n4*7 + n3*8 + n2*9 + n1*10;

        int valor = (soma / 11)*11;

        digito1 = soma-valor;

        resto = (digito1 % 11);

        if(digito1 < 2){
            digito1 = 0;
        }
        else {
            digito1 = 11-resto;
        }

        int soma2 = digito1 * 2 + n9*3 + n8*4 + n7*5 + n6*6 + n5*7 + n4*8 + n3*9 + n2*10 + n1*11;

        int valor2 = (soma2 / 11)*11;

        digito2 = soma2-valor2;

        resto = (digito2 % 11);

        if(digito2 < 2){
            digito2 = 0;
        }
        else {
            digito2 = 11-resto;
        }

        numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) +"." + String.valueOf(n4) +
                String.valueOf(n5) + String.valueOf(n6) +"."+ String.valueOf(n7) +String.valueOf(n8)  +
                String.valueOf(n9)+"-";

        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        numeroGerado = numerosContatenados+nDigResult;

        return numeroGerado;
    }

    public static String randomestring() {
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }


    public static String generateEmail(){
        String email=randomestring()+"@teste.com";
        return email;
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }
}
