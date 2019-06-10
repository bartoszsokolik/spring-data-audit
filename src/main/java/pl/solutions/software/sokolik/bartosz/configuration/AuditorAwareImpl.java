package pl.solutions.software.sokolik.bartosz.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

import static pl.solutions.software.sokolik.bartosz.configuration.AuditingConstants.DEFAULT_AUDITOR;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(DEFAULT_AUDITOR);
    }
}
