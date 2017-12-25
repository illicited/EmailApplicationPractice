package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.Model.EmailMsgBean;
import sample.Model.SampleData;
import sample.View.ViewFactory;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller extends AbstractController implements Initializable {

    @FXML
    private WebView msgRenderer;
    private SampleData sd = new SampleData();
    private MenuItem showDetails = new MenuItem("Show details");
    private ViewFactory vf;

    @FXML
    private Button btn1;

    public Controller(ModelAccess ma) {
        super(ma);
    }

    @FXML
    void btn1Action(ActionEvent event) {
        System.out.println("Button action initiated");
    }

    @FXML
    private TableView<EmailMsgBean> tv_emailHeaders;
    private TreeItem<String> root = new TreeItem<>();

    @FXML
    private TreeView<String> tv_emailFolders;

    @FXML
    private TableColumn<EmailMsgBean, String> subjectCol;

    @FXML
    private TableColumn<EmailMsgBean, String> senderCol;

    @FXML
    private TableColumn<EmailMsgBean, String> sizeCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        msgRenderer.getEngine().loadContent("<html><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p></html>");

        senderCol.setCellValueFactory(new PropertyValueFactory<>("sender"));
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));

        tv_emailHeaders.setContextMenu(new ContextMenu(showDetails));

        tv_emailFolders.setOnMouseClicked(event -> {
            TreeItem<String> item = tv_emailFolders.getSelectionModel().getSelectedItem();
            if(item != null) {
                tv_emailHeaders.setItems(sd.emailFolders.get(item.getValue()));
            }
        });
        vf = ViewFactory.defaultViewFactory;

        tv_emailHeaders.setOnMouseClicked((MouseEvent event) -> {
            EmailMsgBean msg = tv_emailHeaders.getSelectionModel().getSelectedItem();
            if(msg != null) {
                getModelAccess().setSelectedMessage(msg);
                msgRenderer.getEngine().loadContent(msg.getContent());
            }
        });

        showDetails.setOnAction(event -> {

            Scene scene = null;
            try {
                scene = vf.getScene("email_detail_layout");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage msgDetailsStage = new Stage();
            msgDetailsStage.setScene(scene);
            msgDetailsStage.show();
        });

        sizeCol.setComparator(new Comparator<String>() {
            Integer int1, int2;

            @Override
            public int compare(String o1, String o2) {
                int1 = EmailMsgBean.sizeCorrelate.get(o1);
                int2 = EmailMsgBean.sizeCorrelate.get(o2);
                return int1.compareTo(int2);
            }
        });


        tv_emailFolders.setRoot(root);
        root.setValue("example@gmail.com");
        root.setGraphic(vf.getIcon(root.getValue()));
        TreeItem<String> inbox = new TreeItem<>("Inbox", vf.getIcon("Inbox"));
        TreeItem<String> sent = new TreeItem<>("Sent", vf.getIcon("Sent"));
            TreeItem<String> sentSubItem1 = new TreeItem<>("Sent SubItem 1", vf.getIcon("subItem1"));
            TreeItem<String> sentSubItem2 = new TreeItem<>("Sent SubItem 2", vf.getIcon("subItem2"));
            sent.getChildren().addAll(sentSubItem1, sentSubItem2);
        TreeItem<String> spam = new TreeItem<>("Spam", vf.getIcon("spam"));
        TreeItem<String> trash = new TreeItem<>("Trash", vf.getIcon("trash"));

        root.getChildren().addAll(inbox, sent, spam, trash);
        root.setExpanded(true);

     }



}
