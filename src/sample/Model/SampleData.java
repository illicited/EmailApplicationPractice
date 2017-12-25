package sample.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class SampleData {
    private final ObservableList<EmailMsgBean> spam = FXCollections.observableArrayList(
            new EmailMsgBean("xxx@yyy.com", "Enlarge your p3niz", 10000, "<html><h3>Try out the new and improved medicine</h3></br><p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p></html>"),
            new EmailMsgBean("dude@duder.com", "H0w dO yoU knOw ME", 1325, "<html><h3>We are number one</h3></br><p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p></html>"),
            new EmailMsgBean("illicit@illicitartwork.com", "fgt", 36, "<html><p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p></html>")
    );

    private final ObservableList<EmailMsgBean> inbox = FXCollections.observableArrayList(
            new EmailMsgBean("illicit@game-envy.com", "The report you're looking for is attached", 1995155, "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            new EmailMsgBean("rgrain@yahoo.com", "Class next week", 315, "<html><h2>Excepteur sint</h2></br> occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</html>"),
            new EmailMsgBean("paco@chase.com", "Account status", 11555, "<html><h2>Excepteur sint</h2></br> occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</html>"),
            new EmailMsgBean("jeff@playoverwatch.com", "Account activity", 1315, "<html><h2>Excepteur sint</h2></br> occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</html>.")
    );

    private final ObservableList<EmailMsgBean> sent = FXCollections.observableArrayList(
            new EmailMsgBean("paco@chase.com", "RE: Account Status", 355, "<html><h2>Excepteur sint</h2></br> occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</html>"),
            new EmailMsgBean("rod@mwh20.com", "RE: Update on San Bernardino class", 2452, "<html><h2>Excepteur sint</h2></br> occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</html>")
    );

    public Map<String, ObservableList<EmailMsgBean>> emailFolders = new HashMap<>();

    public SampleData() {
        emailFolders.put("Inbox", inbox);
        emailFolders.put("Spam", spam);
        emailFolders.put("Sent", sent);
    }
}
