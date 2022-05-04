package org.ippdej;

import io.quarkus.security.Authenticated;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secure")
@Produces(MediaType.TEXT_PLAIN)
public class SecureResource {

    @GET
    @Path("/public")
    public String pub() {
        return "public";
    }

    @GET
    @Path("/authen")
    @Authenticated
    public String authen() {
        return "authen";
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    public String admin() {
        return "admin";
    }

}
