package com.algaworks.algacomments.moderation.domain.service;

import com.algaworks.algacomments.moderation.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.api.model.ModerationOutput;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

@Service
public class ModerationService {

    private final List<String> blockedWords = Arrays.asList("ódio", "xingamento");

    public ModerationOutput moderation(ModerationInput moderationInput){

        String normalizeText = normalize(moderationInput.getText());

        for (String blockedWord : blockedWords) {
            String normalizedWord = normalize(blockedWord);
            if (normalizeText.contains(normalizedWord)) {
                return ModerationOutput
                        .builder()
                        .approved(false)
                        .reason("The word "+ blockedWord +" is not allowed")
                        .build();
            }
        }
        return ModerationOutput.builder()
                .approved(true)
                .build();

    }

    private String normalize(String str) {
        return Normalizer.normalize(str.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
