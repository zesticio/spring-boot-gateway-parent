package in.zestic.gateway.app.document;

import in.zestic.gateway.app.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "route")
public class Route extends Entity<String, Route> {

    @Id
    private String id;
    private String uri;
    private String path;
    private String method;
    @Builder.Default
    private Integer order = 0;
}
