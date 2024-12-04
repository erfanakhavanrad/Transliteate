package ir.efarda.transliterate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Erfan Akhavan Rad
 * @created 11/27/2024
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCaseActivationRequestDTO {
    private String name;
    private String nationalCode;

}