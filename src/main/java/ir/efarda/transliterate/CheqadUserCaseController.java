package ir.efarda.transliterate;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erfan Akhavan Rad
 * @created 11/27/2024
 */
@RestController
@RequestMapping(path = CheqadUserCaseController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CheqadUserCaseController {
    public static final String BASE_URL = "/api/cheqad/userCase";
    private final OpenAiService openAiService;

    public CheqadUserCaseController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("/transliterate")
    public String transliterateUsername(@RequestBody UserCaseActivationRequestDTO userCaseActivationRequestDTO) throws Exception {
        return openAiService.transliterate(userCaseActivationRequestDTO.getName());
    }

    @PostMapping("/hello")
    public String hello(@RequestBody UserCaseActivationRequestDTO userCaseActivationRequestDTO) throws Exception {
        return "openAiService.transliterate(userCaseActivationRequestDTO.getName())";
    }

    private String capitalizeWords(String input) {
        String[] words = input.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return capitalized.toString().trim();
    }

}
