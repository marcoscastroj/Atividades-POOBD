import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class main {
    public static void main(string[] args) throws IOException{
        Documento doc = Jsoup.connect("https://pt.wikipedia.org/wiki/Fórmula_1").get();
        System.out.println(doc);
    }
}
