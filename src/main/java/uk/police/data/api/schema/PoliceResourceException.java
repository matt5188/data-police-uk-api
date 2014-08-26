package uk.police.data.api.schema;

public class PoliceResourceException extends RuntimeException {

    private static final long serialVersionUID = 5368194567742044349L;

    public PoliceResourceException() {
        super();
    }

    public PoliceResourceException(String message) {
        super(message);
    }
}
