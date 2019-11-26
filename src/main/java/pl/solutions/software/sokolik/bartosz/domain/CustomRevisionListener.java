package pl.solutions.software.sokolik.bartosz.domain;

import java.util.Optional;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) revisionEntity;

        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
            .map(Authentication::getName)
            .ifPresentOrElse(customRevisionEntity::setUsername, () -> customRevisionEntity.setUsername("undefined"));
    }
}
