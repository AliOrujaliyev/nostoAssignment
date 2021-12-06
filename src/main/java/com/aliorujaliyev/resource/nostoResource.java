package com.aliorujaliyev.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/number")
public class nostoResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/numberCheck/{number}")
    public String numberCheck(@PathParam("number") String input){
        return input;
    }
}
