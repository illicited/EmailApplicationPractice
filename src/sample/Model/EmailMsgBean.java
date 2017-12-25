package sample.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;
import java.util.Map;

public class EmailMsgBean {
    public static Map<String, Integer> sizeCorrelate = new HashMap<String, Integer>();;

    private StringProperty sender;
    private StringProperty subject;
    private StringProperty size;
    private String content;

    public EmailMsgBean(String sender, String subject, int size, String content) {
        this.sender = new SimpleStringProperty(sender);
        this.subject = new SimpleStringProperty(subject);
        this.size = new SimpleStringProperty(sizeFormat(size));
        this.content = content;
    }

    public String getSender() {
        return sender.get();
    }

    public StringProperty senderProperty() {
        return sender;
    }

    public String getSubject() {
        return subject.get();
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public String getContent() {
        return content;
    }

    private String sizeFormat(int size) {
        String value;

        if(size <= 0) {
            return value = "0";
        } else if (size < 1024) {
            value = size + " B";
        } else if (size < 1048576) {
            value = size / 1024 + " KB";
        } else {
            value = size / 1048576 + " MB";
        }
        sizeCorrelate.put(value, size);
        return value;
    }
}
