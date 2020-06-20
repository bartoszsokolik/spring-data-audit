package pl.solutions.software.sokolik.bartosz.paging;

import org.springframework.data.domain.Sort;

public enum SortDirection {

    asc(Sort.Direction.ASC),
    desc(Sort.Direction.DESC);

    private final Sort.Direction direction;

    SortDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public Sort.Direction getDirection() {
        return direction;
    }
}
