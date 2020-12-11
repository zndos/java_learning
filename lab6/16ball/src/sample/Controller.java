package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Controller {
    @FXML public Button Button1;
    @FXML public TextField TextField1;
    @FXML public Label Label1;
    @FXML public Label Label2;
    @FXML public Label Label11;
    @FXML public ImageView Image1;
    @FXML public Label LabelAns;


    public void Button1Click(ActionEvent actionEvent) throws InterruptedException {
        if (!TextField1.getCharacters().toString().equals("")) {

            String[] predictions = new String[20];
            //all the predictions
            predictions[0] = "Уверенно ДА!";
            predictions[1] = "Честно не знаю";
            predictions[2] = "Спроси еще раз , я не расслышал";
            predictions[3] = "Нет";

            //pause
            TimeUnit.SECONDS.sleep(3);

            Random random = new Random();
            LabelAns.setText(predictions[random.nextInt(3)]);

        }
    }
}


