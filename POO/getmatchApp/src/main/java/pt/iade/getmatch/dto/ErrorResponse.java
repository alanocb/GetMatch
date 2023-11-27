package pt.iade.getmatch.dto;

import java.sql.Timestamp;
import java.util.Date;

public class ErrorResponse extends StatusResponse {
    private Timestamp timestamp;

    public ErrorResponse() {
        super();
        this.timestamp = new Timestamp(new Date().getTime());
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
