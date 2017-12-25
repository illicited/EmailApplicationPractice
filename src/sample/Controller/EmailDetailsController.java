package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import sample.Model.EmailMsgBean;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailDetailsController extends AbstractController implements Initializable{

    @FXML
    private WebView wvEmailDetailContents;

    @FXML
    private Label lblSubject;

    @FXML
    private Label lblSender;

    public EmailDetailsController(ModelAccess ma) {
        super(ma);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EmailMsgBean selectedMessage = getModelAccess().getSelectedMessage();

        lblSubject.setText("Subject: " + selectedMessage.getSubject());
        lblSender.setText("From: " + selectedMessage.getSender());
        wvEmailDetailContents.getEngine().loadContent(selectedMessage.getContent());
    }
}
