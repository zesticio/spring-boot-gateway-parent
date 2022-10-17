package com.zestic.gateway.app.document;

import com.zestic.springboot.common.collection.LinkedList;
import com.zestic.springboot.common.entity.Entity;
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
    private LinkedList<String> predicates;
    private LinkedList<String> filters;
    @Builder.Default
    private Integer order = 0;

    public void addPredicate(String predicate) {
        predicates.add(predicate);
    }

    public void removePredicate(String predicate) {
        predicates.remove(predicate);
    }

    public void addFilter(String filter) {
        filters.add(filter);
    }

    public void removeFilter(String filter) {
        filters.remove(filter);
    }
}
