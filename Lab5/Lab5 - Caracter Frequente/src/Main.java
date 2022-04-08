import java.util.HashMap;
import java.util.HashSet;

public class Main {

    static void encontrarCaracterMaisFrequente(String palavra){

        HashSet<Character> letrasParaContar = new HashSet<>();

        HashMap<Character,Integer> letras = new HashMap<>();

        for(int i = 0; i<palavra.length(); i++){
            letrasParaContar.add(palavra.charAt(i));
        }


        for (int i = 0; i < palavra.length();i++){
            char letra = palavra.charAt(i);
            if(letras.containsKey(letra)){
                letras.put(letra,letras.get(letra)+1);
            }
            else{
                letras.put(palavra.charAt(i),1);
            }
        }

        char maisFrequente = '.';
        int vezes = 0;
        for (Character letra : letrasParaContar){
            if(letras.get(letra) > vezes){
                vezes = letras.get(letra);
                maisFrequente = letra;
            }
        }
        System.out.printf("Caracter mais frequente: %c, vezes: %d", maisFrequente,vezes);
    }

    public static void main(String[] args) {
        encontrarCaracterMaisFrequente("CLEITON");
    }
}
