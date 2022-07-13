package bg.softuni.errorhandling.model;

public class APIErrorDTO {

    private final Long objectId;
    private final String message;

    public APIErrorDTO(Long objectId, String message) {
        this.objectId = objectId;
        this.message = message;
    }

    public Long getObjectId() {
        return objectId;
    }

    public String getMessage() {
        return message;
    }
}
