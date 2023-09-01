import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractTitles {
    public static void main(String[] args) {
        String url = "https://www.example.com"; // Substitua pela URL da página desejada
        String outputFile = "titles.txt"; // Nome do arquivo de saída

        try {
            // Faz a requisição HTTP e obtém o documento HTML da página
            Document document = Jsoup.connect(url).get();

            // Seleciona todos os elementos de título (h1, h2, h3, etc.)
            Elements titles = document.select("h1, h2, h3, h4, h5, h6");

            // Cria um BufferedWriter para escrever no arquivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Itera sobre os elementos de título e escreve no arquivo
            for (Element title : titles) {
                writer.write(title.text());
                writer.newLine();
            }

            // Fecha o BufferedWriter
            writer.close();

            System.out.println("Títulos extraídos e salvos em " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
