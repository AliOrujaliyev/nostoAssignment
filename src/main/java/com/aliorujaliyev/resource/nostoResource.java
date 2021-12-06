package com.aliorujaliyev.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/number")
public class nostoResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/numberCheck/{number}")
    public String numberCheck(@PathParam("number") String input){
//        Default return value "No answer" for the unsuccessful case
        String result = "No answer";
        long number;

//        Discarding any inputs that are not numeric and less than 0
//        Long can't be larger than 9223372036854775807, so no need to check number > Long.MAX_VALUE
        try {
            number = Long.parseLong(input);
            if (number < 0){
                return result;
            }
        } catch (NumberFormatException nfe) {
            return result;
        }


        return input;
    }
}
