package dev.exception.controller.dto;

import java.util.List;

public class ErrorDTO {
    private List<String> messages;

    public ErrorDTO() {
    }

    public ErrorDTO(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
