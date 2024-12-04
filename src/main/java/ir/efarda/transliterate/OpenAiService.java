package ir.efarda.transliterate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author Erfan Akhavan Rad
 * @created 12/04/2024
 */
@Service
public class OpenAiService {

    private String apiKey = "";

    private String apiUrl = "https://api.openai.com/v1/chat/completions";


    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public OpenAiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String transliterate(String inputText) throws Exception {
        // Prepare the request body
        OpenAiRequest requestBody = new OpenAiRequest(
                "gpt-3.5-turbo",
                Collections.singletonList(new OpenAiRequest.Message("user",
                        "Please transliterate the following Persian text into Latin script:\n" + inputText))
        );

        // Create headers
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        // Build the request
        org.springframework.http.HttpEntity<OpenAiRequest> entity = new org.springframework.http.HttpEntity<>(requestBody, headers);

        // Send POST request
        org.springframework.http.ResponseEntity<OpenAiResponse> response = restTemplate.postForEntity(apiUrl, entity, OpenAiResponse.class);

        // Extract and return the transliteration result
        if (response.getBody() != null && response.getBody().getChoices() != null && !response.getBody().getChoices().isEmpty()) {
            return response.getBody().getChoices().get(0).getMessage().getContent().trim();
        } else {
            throw new Exception("Invalid response from OpenAI API");
        }
    }


}
