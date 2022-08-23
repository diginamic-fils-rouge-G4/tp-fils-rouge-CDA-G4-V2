package dev.controller.dto;

import java.util.List;

/**
 * DTO utilisé pour la gestion des erreurs
 */
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
