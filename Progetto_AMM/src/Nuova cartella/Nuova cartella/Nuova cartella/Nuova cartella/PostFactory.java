/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;


import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Andreea
 */
public class PostFactory {
    
     //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
     private ArrayList<Post> listaPost = new ArrayList<Post>();
     
      private PostFactory() {
        
        UtentiRegistratiFactory utentiRegistratiFactory = UtentiRegistratiFactory.getInstance();
                
        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Un sondaggio inglese rivela: la frase più ricordata tra gli amanti dei cartoon è quella del celebre coniglio: «Che succede amico?»Bugs Bunny Per gli americani dev'essere una sorta di riflesso condizionato: davanti alle orecchie di un coniglio viene automatico pensare «what's up doc?». E si capisce. E' la frase «tormentone» del coniglio più famoso d'America: Bugs Bunny. La faccia soddisfatta del dentone carota-dipendente la dice a ripetizione anche da noi, al di qua delle Alpi: «Che succede amico?». E non è un caso che sia proprio quella la frase la più famosa legata a un personaggio dei cartoon. Lo rivela un recente studio-sondaggio voluto dalla sede inglese del gruppo di distribuzione cinematografica Uci Cinemas per lanciare l'ultimo film della Warner Bros, Back in Action. A 500 cinefili inglesi appassionati di cartoni animati è stato chiesto quale detto, frase o parola amano e ricordano di più in relazione a un cartoon. Bene: su tutti ha prevalso quel «what's up doc?», seguito da «Doh!», espressione fra lo sgomento e lo stupito di un personaggio ben più giovane di Bugs, Homer Simpson il confuso ispettore nucleare della famiglia più strampalata dei cartoon.");
        post1.setId(0);
        post1.setUser(utentiRegistratiFactory.getUtentiRegistratiById(0));

        Post post2 = new Post();
        post2.setContent(" Che c'è, non hai mai sentito parlare di Google? Dovresti cercarlo su Google.\n" +
        "- A volte, non sempre ovviamente, ma a volte, io... vedo come delle cose. Ho delle visioni. Immagini distorte della realtà. [...] Oh, non è una cosa fissa. Ma il piccolo uomo pallido dietro la tenda, cioè il mio editor-- dice non più di due per episodio.\n" +
        "- Ehi, tamarro. Senti, io sono uno dei buoni--- be', almeno in questo numero...\n" +
        "-Fare l'eroe è la professione più breve del mondo. Fa tutto ridere, finchè capita a qualcun altro.\n" +
        "- Sono stato creato specificamente dagli umani... per uccidere gli umani. Il che la dice lunga sulla razza umana in generale, non credete?!\n" +
        "- Una volta uno mi ha detto che alla fine di tutto rimpiangiamo non quello che abbiamo fatto, ma quello che non abbiamo fatto.\n" +
        "img/pool.jpg");
        post2.setId(1);
        post2.setUser(utentiRegistratiFactory.getUtentiRegistratiById(2));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContent("La Ofcom ha spiegato che Tom & Jerry è un cartone animato vintage realizzato in un periodo in cui il rischio legato al fumo non era ancora stato attentamente studiato e che questa era un'ottima ragione per chiedere alla Turner di prendere provvedimenti. Tom & Jerry però sono stati censurati altre volte. Molte scene di altri episodi contenevano dei blackface, cioè quando esplodeva qualcosa o il viso di Tom, Jerry o altri personaggi si coprivano di fango, essi diventavano come delle persone africane e ciò poteva risultare offensivo per le persone di origine africana. Un altro episodio censurato è Il suo topo Venerdì (His Mouse Friday, 1951) a causa degli stereotipi razziali in esso contenuti.\n" +
            "\n" + "https://i.makeagif.com/media/6-06-2015/nc_GSl.gif");
        post3.setId(2);
        post3.setUser(utentiRegistratiFactory.getUtentiRegistratiById(3));
        post3.setPostType(Post.Type.LINK);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);

    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }
       
    public List getPostList(UtentiRegistrati user) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(user)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
