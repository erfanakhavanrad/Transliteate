package ir.efarda.transliterate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Erfan Akhavan Rad
 * @created 12/04/2024
 */
public class OpenAiRequest {
    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;

    public OpenAiRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public static class Message {
        @JsonProperty("role")
        private String role;
        @JsonProperty("content")
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public String getContent() {
            return content;
        }
    }
}
