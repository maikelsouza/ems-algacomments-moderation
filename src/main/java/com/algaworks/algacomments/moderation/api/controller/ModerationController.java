package com.algaworks.algacomments.moderation.api.controller;

import com.algaworks.algacomments.moderation.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.api.model.ModerationOutput;
import com.algaworks.algacomments.moderation.domain.service.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/moderations")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationService service;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput moderate(@RequestBody ModerationInput moderationInput){
        return service.moderation(moderationInput);
    }
}
