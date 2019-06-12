package pl.solutions.software.sokolik.bartosz.actor.domain.dto;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(String message) {
        super(message);
    }
}
