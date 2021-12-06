package com.aliorujaliyev.resource;

import javax.ws.rs.*;


@Path("/number")
public class nostoResource {

    @POST
    @Path("/numberCheck")
    public String numberCheck() {
        return "Hello";
    }
}
