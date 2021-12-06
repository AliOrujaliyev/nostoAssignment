package com.aliorujaliyev.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;


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

//        Constructing an array list from the digits of the number for faster and easier sort
        long temp = number;
        ArrayList<Long> array = new ArrayList<>();
        do{
            array.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);

//       reverse sorting the array, so that larger digits are in the beginning of the array list
        Collections.sort(array);
        Collections.reverse(array);

        long new_number = 0;

//        calculating new number based on the reversed array
        for (long digit: array) {
            new_number *= 10;
            new_number += digit;
        }

//        return number only in case of acquiring larger new number
        if (new_number > number){
            return Long.toString(new_number);
        }

        return result;
    }
}
