package pt.iade.getmatch.dto;

public abstract class StatusResponse {
    private int status;
    private String message;

    public StatusResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
