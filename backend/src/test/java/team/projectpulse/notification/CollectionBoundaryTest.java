package team.projectpulse.notification;

import org.junit.jupiter.api.Test;
import team.projectpulse.ram.document.template.DocumentTemplate;
import team.projectpulse.rubric.dto.CriterionDto;
import team.projectpulse.rubric.dto.RubricDto;
import team.projectpulse.student.Student;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CollectionBoundaryTest {

    @Test
    void reminderResultKeepsSnapshotWhenCallerChangesSourceList() {
        var students = new ArrayList<Student>();
        students.add(new Student());
        var result = new ReminderService.ReminderResult(0, students);

        students.clear();

        assertThat(result.failed()).hasSize(1);
        assertThatThrownBy(() -> result.failed().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void rubricSnapshotPreservesNullElementsAndDoesNotShareInputSet() {
        var criteria = new LinkedHashSet<CriterionDto>();
        criteria.add(null);
        var dto = new RubricDto(1, "Rubric", criteria, 1);

        criteria.clear();

        assertThat(dto.criteria()).containsExactly((CriterionDto) null);
        assertThatThrownBy(() -> dto.criteria().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void templateListCannotBeChangedThroughInputOrGetter() {
        var sections = new ArrayList<DocumentTemplate.SectionTemplate>();
        sections.add(new DocumentTemplate.SectionTemplate());
        var template = new DocumentTemplate();
        template.setSections(sections);

        sections.clear();
        template.getSections().clear();

        assertThat(template.getSections()).hasSize(1);
    }

    @Test
    void nullCollectionsRemainNullForExistingValidationAndCallers() {
        assertThat(new RubricDto(1, "Rubric", null, 1).criteria()).isNull();
        assertThat(new ReminderService.ReminderResult(0, null).failed()).isNull();
    }
}
