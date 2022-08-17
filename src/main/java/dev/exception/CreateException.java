package dev.exception;

import java.util.List;

public class CreateException extends QualiteAirException{
    private List<String> messages;

    public CreateException() {
    }

    public CreateException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
