package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Controller {
    @FXML
    TextField urlTextField;
    @FXML
    Label wynikLabel;
    @FXML
    Label statusLabel;
    @FXML
    void clicked () throws IOException {
        System.out.println("kliknięcie");
        //wynikLabel.setText("Wpisałeś: " +urlTextField.getText());
        //String Url = "http://www.wp.pl/";
        Document doc = null;
        try {
            doc = Jsoup.connect(urlTextField.getText()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        statusLabel.setText("Połączenie udane");
        wynikLabel.setText("Tytuł podanej strony to: " +title);
    }
}
