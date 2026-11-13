package team.projectpulse.ram.usecase.dto;

import java.util.Collections;

import java.util.ArrayList;

import team.projectpulse.ram.usecase.ExtensionExit;
import team.projectpulse.ram.usecase.ExtensionKind;

import java.util.List;

public record UseCaseExtensionDto(
        Long id,
        String conditionText,
        ExtensionKind kind,
        ExtensionExit exit,
        List<UseCaseExtensionStepDto> steps) {
    public UseCaseExtensionDto {
        // DTO collections are snapshots; preserve null for existing validation behavior.
        steps = steps == null ? null : Collections.unmodifiableList(new ArrayList<>(steps));
    }

}
