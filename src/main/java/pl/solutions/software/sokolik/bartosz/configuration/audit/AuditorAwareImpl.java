package pl.solutions.software.sokolik.bartosz.configuration.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static pl.solutions.software.sokolik.bartosz.configuration.audit.AuditingConstants.DEFAULT_AUDITOR;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
            .map(Authentication::getName)
            .or(() -> Optional.of(DEFAULT_AUDITOR));
    }
}
