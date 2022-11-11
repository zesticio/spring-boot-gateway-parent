package in.zestic.gateway.app.document;

import in.zestic.gateway.app.base.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class PredicateEntity extends Entity<String, PredicateEntity> {

    @ApiModelProperty(notes = "The After route predicate factory takes one parameter, a datetime (which is a java ZonedDateTime). This predicate matches requests that happen after the specified datetime. The following example configures an after route predicate eg - After=2017-01-20T17:42:47.789-07:00[America/Denver]")
    private Optional<String> after = Optional.of("2017-01-20T17:42:47.789-07:00[America/Denver]");
    ;

    @ApiModelProperty(notes = "The Before route predicate factory takes one parameter, a datetime (which is a java ZonedDateTime). This predicate matches requests that happen before the specified datetime. The following example configures a before route predicate: - Before=2017-01-20T17:42:47.789-07:00[America/Denver]. This route matches any request made before Jan 20, 2017 17:42 Mountain Time (Denver).")
    private Optional<String> before = Optional.of("2017-01-20T17:42:47.789-07:00[America/Denver]");

    @ApiModelProperty(notes = "The Between route predicate factory takes two parameters, datetime1 and datetime2 which are java ZonedDateTime objects. This predicate matches requests that happen after datetime1 and before datetime2. The datetime2 parameter must be after datetime1. The following example configures a between route predicate: - Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver] This route matches any request made after Jan 20, 2017 17:42 Mountain Time (Denver) and before Jan 21, 2017 17:42 Mountain Time (Denver). This could be useful for maintenance windows.")
    private BetweenZonedDateTime between = new BetweenZonedDateTime(Boolean.FALSE);

    @ApiModelProperty(notes = "The Cookie route predicate factory takes two parameters, the cookie name and a regexp (which is a Java regular expression). This predicate matches cookies that have the given name and whose values match the regular expression. The following example configures a cookie route predicate factory: - Cookie=chocolate, ch.p This route matches requests that have a cookie named chocolate whose value matches the ch.p regular expression.")
    private Optional<String> cookie;

    @ApiModelProperty(notes = "The Header route predicate factory takes two parameters, the header name and a regexp (which is a Java regular expression). This predicate matches with a header that has the given name whose value matches the regular expression. The following example configures a header route predicate: - Header=X-Request-Id, \\d+ This route matches if the request has a header named X-Request-Id whose value matches the \\d+ regular expression (that is, it has a value of one or more digits).")
    private Optional<String> header;

    @ApiModelProperty(notes = "The Host route predicate factory takes one parameter: a list of host name patterns. The pattern is an Ant-style pattern with . as the separator. This predicates matches the Host header that matches the pattern. The following example configures a host route predicate: - Host=**.somehost.org,**.anotherhost.org This route matches if the request has a Host header with a value of www.somehost.org or beta.somehost.org or www.anotherhost.org. ")
    private Optional<String> hosts;

    @ApiModelProperty(notes = "The Method Route Predicate Factory takes a methods argument which is one or more parameters: the HTTP methods to match. The following example configures a method route predicate: - Method=GET,POST This route matches if the request method was a GET or a POST.")
    private Optional<String> method;

    @ApiModelProperty(notes = "The Path Route Predicate Factory takes two parameters: a list of Spring PathMatcher patterns and an optional flag called matchOptionalTrailingSeparator. The following example configures a path route predicate: - Path=/red/{segment},/blue/{segment} This route matches if the request path was, for example: /red/1 or /red/blue or /blue/green.")
    private Optional<String> path;

    @ApiModelProperty(notes = "The Query route predicate factory takes two parameters: a required param and an optional regexp (which is a Java regular expression). The following example configures a query route predicate: - Query=green, The preceding route matches if the request contained a green query parameter. - Query=red, gree. The preceding route matches if the request contained a red query parameter whose value matched the gree. regexp, so green and greet would match.")
    private Optional<String> query;

    @ApiModelProperty(notes = "The RemoteAddr route predicate factory takes a list (min size 1) of sources, which are CIDR-notation (IPv4 or IPv6) strings, such as 192.168.0.1/16 (where 192.168.0.1 is an IP address and 16 is a subnet mask). The following example configures a RemoteAddr route predicate: - RemoteAddr=192.168.1.1/24 This route matches if the remote address of the request was, for example, 192.168.1.10")
    private Optional<String> remoteAddr;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {
    }
}
