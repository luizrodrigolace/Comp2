import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class UsuarioTest {

    private CalculadorIntersecao calculadorEsperto;
    private CalculadorIntersecao calculadorIngenuo;
    private CalculadorIntersecao calculadorBuscaBinaria;

    @Before
    public void setUp(){
        calculadorEsperto = new CalculadorIntersecaoEsperto();
        calculadorIngenuo = new CalculadorIntersecaoIngenuo();
        calculadorBuscaBinaria = new CalculadorIntersecaoViaBuscaBinaria();
    }

    @Test
    public void testeDeFuncionalidade() {
        Usuario usuarioEsperto = new Usuario(111, calculadorEsperto);
        Usuario usuarioIngenuo = new Usuario(222,calculadorIngenuo);
        Usuario usuarioBinario = new Usuario(333,calculadorBuscaBinaria);

        Usuario usuario2 = new Usuario(2, calculadorEsperto);
        Usuario usuario3 = new Usuario(3, calculadorEsperto);
        Usuario usuario4 = new Usuario(4, calculadorEsperto);
        Usuario usuario5 = new Usuario(5, calculadorEsperto);

        usuarioEsperto.setAmigos(usuario2);
        usuarioEsperto.setAmigos(usuario3);
        usuarioEsperto.setAmigos(usuario4);

        usuarioIngenuo.setAmigos(usuario2);
        usuarioIngenuo.setAmigos(usuario3);
        usuarioIngenuo.setAmigos(usuario5);

        usuarioBinario.setAmigos(usuario3);
        usuarioBinario.setAmigos(usuario5);




        assertEquals(2,
                usuarioEsperto.obterQuantidadeDeAmigosEmComum(usuarioIngenuo));
        assertEquals(2,
                usuarioIngenuo.obterQuantidadeDeAmigosEmComum(usuarioEsperto));
        assertEquals(1
                ,usuarioEsperto.obterQuantidadeDeAmigosEmComum(usuarioBinario));
        assertEquals(2,
                usuarioIngenuo.obterQuantidadeDeAmigosEmComum(usuarioBinario));
    }

    @Test
    public void testePerformance(){
        int AMIGOS = 50_000;

        Usuario usuarioEsperto = new Usuario(111, calculadorEsperto);
        Usuario usuarioIngenuo = new Usuario(222,calculadorIngenuo);
        Usuario usuarioBinario = new Usuario(333,calculadorBuscaBinaria);


        for (int i = 1;i<AMIGOS;i++){
            Usuario usuario = new Usuario(i,calculadorEsperto);
            usuarioEsperto.setAmigos(usuario);
            usuarioIngenuo.setAmigos(usuario);
            usuarioBinario.setAmigos(usuario);
        }

        long inicio = System.currentTimeMillis();
        usuarioEsperto.obterQuantidadeDeAmigosEmComum(usuarioIngenuo);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuração com Esperto = %.3fs",
                duracao / 1000f);

        long inicio2 = System.currentTimeMillis();
        usuarioIngenuo.obterQuantidadeDeAmigosEmComum(usuarioEsperto);
        long duracao2 = System.currentTimeMillis() - inicio2;
        System.out.printf("\nDuração com Ingenuo = %.3fs",
                duracao2 / 1000f);

        long inicio3 = System.currentTimeMillis();
        usuarioBinario.obterQuantidadeDeAmigosEmComum(usuarioIngenuo);
        long duracao3 = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuração com Busca Binaria = %.3fs",
                duracao3 / 1000f);

    }




}