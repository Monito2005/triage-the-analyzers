package team.projectpulse.instructor;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.util.Locale;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ResourceLock("java.util.Locale.default")
class InstructorSpecsLocaleTest {

    @Test
    @SuppressWarnings("unchecked")
    void firstNameSearchUsesStableCaseConversionOnTurkishServer() {
        Locale original = Locale.getDefault();
        try {
            Locale.setDefault(Locale.forLanguageTag("tr-TR"));
            Root<Instructor> root = mock(Root.class);
            CriteriaQuery<?> query = mock(CriteriaQuery.class);
            CriteriaBuilder builder = mock(CriteriaBuilder.class);

            InstructorSpecs.hasFirstName("IVAN").toPredicate(root, query, builder);

            // The query must search for ivan regardless of the application server's locale.
            verify(builder).equal(any(), eq("ivan"));
        } finally {
            Locale.setDefault(original);
        }
    }
}
