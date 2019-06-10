package pl.solutions.software.sokolik.bartosz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.solutions.software.sokolik.bartosz.configuration.AuditingConstants;

import java.util.Optional;

import static pl.solutions.software.sokolik.bartosz.configuration.AuditingConstants.TEST_AUDITOR;

@Configuration
@Profile("test")
@EnableJpaAuditing(auditorAwareRef = "testAuditorProvider")
public class TestAuditingConfiguration {

    @Bean
    @Primary
    public AuditorAware<String> testAuditorProvider() {
        return () -> Optional.of(TEST_AUDITOR);
    }

}
