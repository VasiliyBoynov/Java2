package Lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    private final String nickName = "TestName";
    @FXML
    TextArea listStrings;
    public TextField message;

    public void sendMessage(ActionEvent actionEvent) {
    listStrings.appendText(String.format("%s> %s%n",nickName,message.getText()));
    message.clear();


    }
}
