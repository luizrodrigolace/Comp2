import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private final ArrayList<String> hashtags;
    private T anexo;

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.hashtags = new ArrayList<>();
    }

    public void anexarAlgo(Object anexo) {
        this.anexo = (T) anexo;
    }

    public Object getAnexo() {
        return this.anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public List<String> getHashtags() {
        return this.hashtags;
    }
    public void setHashtags(String hashtag){
        this.hashtags.add(hashtag);
    }
}
