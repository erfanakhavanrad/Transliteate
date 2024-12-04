package ir.efarda.transliterate;

import java.util.List;

/**
 * @author Erfan Akhavan Rad
 * @created 12/04/2024
 */
public class OpenAiResponse {
    private List<Choice> choices;

    public static class Choice {
        private Message message;

        public Message getMessage() {
            return message;
        }

        public static class Message {
            private String content;

            public String getContent() {
                return content;
            }
        }
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
