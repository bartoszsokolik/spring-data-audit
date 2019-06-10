package pl.solutions.software.sokolik.bartosz.actor.dto;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(String message) {
        super(message);
    }
}
