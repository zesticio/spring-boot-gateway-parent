package in.zestic.gateway.app.document;

import in.zestic.gateway.app.base.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterEntity extends Entity<String, FilterEntity> {

    @ApiModelProperty(notes = "The AddRequestHeader GatewayFilter factory takes a name and value parameter. The following example configures an AddRequestHeader GatewayFilter: - AddRequestHeader=X-Request-red, blue This listing adds X-Request-red:blue header to the downstream request’s headers for all matching requests.")
    private String addRequestHeader;

    @ApiModelProperty(notes = "The AddRequestParameter GatewayFilter Factory takes a name and value parameter. The following example configures an AddRequestParameter GatewayFilter: - AddRequestParameter=red, blue This will add red=blue to the downstream request’s query string for all matching requests.")
    private String addRequestParameter;

    @ApiModelProperty(notes = "The AddResponseHeader GatewayFilter Factory takes a name and value parameter. The following example configures an AddResponseHeader GatewayFilter: - AddResponseHeader=X-Response-Red, Blue This adds X-Response-Foo:Bar header to the downstream response’s headers for all matching requests.")
    private String addResponseHeader;

    @ApiModelProperty(notes = "The DedupeResponseHeader GatewayFilter factory takes a name parameter and an optional strategy parameter. name can contain a space-separated list of header names. The following example configures a DedupeResponseHeader GatewayFilter: - DedupeResponseHeader=Access-Control-Allow-Credentials Access-Control-Allow-Origin This removes duplicate values of Access-Control-Allow-Credentials and Access-Control-Allow-Origin response headers in cases when both the gateway CORS logic and the downstream logic add them.")
    private String dedupeResponseHeader;

    @ApiModelProperty(notes = "The MapRequestHeader GatewayFilter factory takes fromHeader and toHeader parameters. It creates a new named header (toHeader), and the value is extracted out of an existing named header (fromHeader) from the incoming http request. If the input header does not exist, the filter has no impact. If the new named header already exists, its values are augmented with the new values. The following example configures a MapRequestHeader: - MapRequestHeader=Blue, X-Request-Red This adds X-Request-Red:<values> header to the downstream request with updated values from the incoming HTTP request’s Blue header.")
    private String mapRequestHeader;

    @ApiModelProperty(notes = "The PrefixPath GatewayFilter factory takes a single prefix parameter. The following example configures a PrefixPath GatewayFilter: - PrefixPath=/mypath This will prefix /mypath to the path of all matching requests. So a request to /hello would be sent to /mypath/hello.")
    private String prefixPath;

    @ApiModelProperty(notes = "The PreserveHostHeader GatewayFilter factory has no parameters. This filter sets a request attribute that the routing filter inspects to determine if the original host header should be sent, rather than the host header determined by the HTTP client. The following example configures a PreserveHostHeader GatewayFilter: - PreserveHostHeader")
    private Boolean preserveHostHeader;

    @ApiModelProperty(notes = "The RedirectTo GatewayFilter factory takes two parameters, status and url. The status parameter should be a 300 series redirect HTTP code, such as 301. The url parameter should be a valid URL. This is the value of the Location header. For relative redirects, you should use uri: no://op as the uri of your route definition. The following listing configures a RedirectTo GatewayFilter: This will send a status 302 with a Location:https://acme.org header to perform a redirect.")
    private String redirectTo;

    @ApiModelProperty(notes = "The RemoveRequestHeader GatewayFilter factory takes a name parameter. It is the name of the header to be removed. The following listing configures a RemoveRequestHeader GatewayFilter: - RemoveRequestHeader=X-Request-Foo This removes the X-Request-Foo header before it is sent downstream.")
    private String removeRequestHeader;

    @ApiModelProperty(notes = "The RemoveResponseHeader GatewayFilter factory takes a name parameter. It is the name of the header to be removed. The following listing configures a RemoveResponseHeader GatewayFilter: - RemoveResponseHeader=X-Response-Foo This will remove the X-Response-Foo header from the response before it is returned to the gateway client.")
    private String removeResponseHeader;

    @ApiModelProperty(notes = "The RemoveRequestParameter GatewayFilter factory takes a name parameter. It is the name of the query parameter to be removed. The following example configures a RemoveRequestParameter GatewayFilter: - RemoveRequestParameter=red This will remove the red parameter before it is sent downstream.")
    private String removeRequestParameter;

    @ApiModelProperty(notes = "The RewritePath GatewayFilter factory takes a path regexp parameter and a replacement parameter. This uses Java regular expressions for a flexible way to rewrite the request path. The following listing configures a RewritePath GatewayFilter: - RewritePath=/red(?<segment>/?.*), ${segment} For a request path of /red/blue, this sets the path to /blue before making the downstream request. Note that the $ should be replaced with $\\ because of the YAML specification.")
    private String rewritePath;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }
}
