import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite {

    public static int TAMANHO_MAXIMO_TUITES = 120;

    private HashMap<String,Usuario> usuariosCadastrados;

    private HashMap<String,Usuario> listaTuites;

    private HashMap<String,Integer> hashtagsPorQuantidade;

    public TuiterLite(){
        this.usuariosCadastrados=new HashMap<>();
        this.listaTuites= new HashMap<>();
        this.hashtagsPorQuantidade = new HashMap<>();
    }

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {  // throws UsuarioJaExisteException {
        Usuario usuarioNovo = new Usuario(nome,email);
        if(usuariosCadastrados.containsKey(email)){
            return null;
        }
        usuariosCadastrados.put(email,usuarioNovo);

        return usuarioNovo;
    }

    /**
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     *
     * PS.: Se o texto exceder o limite pré-definido, ou o usuário não estiver cadastrado, return null
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {
        if (usuariosCadastrados.containsKey(usuario.getEmail()) == false){
            return null;
        }

        if (texto.length() > TAMANHO_MAXIMO_TUITES){
            return null;
        }

        Tuite tuiteNovo = new Tuite(usuario,texto);

        //contabilizando hashtag
        String[] tuiteSeparado = texto.split("\\s+");
        for (String palavra : tuiteSeparado){
            if (palavra.startsWith("#")){
                tuiteNovo.setHashtags(palavra);
                if(hashtagsPorQuantidade.containsKey(palavra) == false){
                    hashtagsPorQuantidade.put(palavra,1);
                }
                hashtagsPorQuantidade.put(palavra,hashtagsPorQuantidade.get(palavra)+1);
            }
        }
        return tuiteNovo;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        int maiorQuantidade = 0;
        String maisComum = null;
        for(String palavra : hashtagsPorQuantidade.keySet()){
            if (hashtagsPorQuantidade.get(palavra) > maiorQuantidade){
                maiorQuantidade = hashtagsPorQuantidade.get(palavra);
                maisComum = palavra;
            }
        }
        return maisComum;
    }
}
