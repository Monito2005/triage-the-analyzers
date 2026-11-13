package team.projectpulse.notification.dto;

import java.util.Collections;

import java.util.ArrayList;

import team.projectpulse.notification.SubmittableItem;

import java.util.List;

/**
 * @param sent   how many reminders the mail server accepted; 0 with no failures means nobody owed the item
 * @param failed the students who could not be reached
 */
public record ReminderResultDto(SubmittableItem item,
                                String week,
                                int sent,
                                List<OwingStudentDto> failed) {
    public ReminderResultDto {
        // DTO collections are snapshots; preserve null for existing validation behavior.
        failed = failed == null ? null : Collections.unmodifiableList(new ArrayList<>(failed));
    }

}
