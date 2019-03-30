package homework.lesson8.client;

import homework.lesson8.Observer.Model;
import homework.lesson8.Observer.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ControllerSeconds implements Observer {

    @FXML
    TextField textField1;

    @FXML
    Button btn2;

    static Model model;

    public void sendMsg1() {
        model = new Model();
        model.registerObserver(this);
        model.notifyObservers(textField1.getText());
        model.removeObserver(this);
        textField1.clear();
        textField1.requestFocus();
    }

    @Override
    public void notification(String message) {

    }
}
