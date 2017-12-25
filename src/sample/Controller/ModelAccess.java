package sample.Controller;

import sample.Model.EmailMsgBean;

public class ModelAccess {
    private EmailMsgBean selectedMessage;

    public EmailMsgBean getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(EmailMsgBean selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
}
