package com.algaworks.algacomments.moderation.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ModerationInput {

    private UUID id;

    private String text;

}
