package in.zestic.gateway.app.document;

import in.zestic.gateway.app.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetweenZonedDateTime extends Entity<String, BetweenZonedDateTime> {

    private Boolean present = Boolean.FALSE;
    private String from = "2017-01-20T17:42:47.789-07:00[America/Denver]";
    private String to = "2017-01-21T17:42:47.789-07:00[America/Denver]";

    public BetweenZonedDateTime(Boolean present) {
        this.present = present;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    public String toString() {
        if (present)
            return from + ", " + to;
        else
            return null;
    }
}
