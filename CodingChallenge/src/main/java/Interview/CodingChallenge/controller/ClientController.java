package Interview.CodingChallenge.controller;

import Interview.CodingChallenge.model.Item;
import Interview.CodingChallenge.service.*;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * REST endpoint for the service.
 * 
 * @param  item   the item posted by the client
 * @return        error response, or eligibility of
 *                the item 
 *
 * @author Kunal Lakhanpal
 */

@Component
@Path("/item")
public class ClientController {
   
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response checkEligibility(Item item) {

        if (CheckService.incorrectInputs(item))
            return Response.status(400).entity(
                "Please provide all mandatory inputs.").build();
        else {
            boolean eligibility = CheckService.checkEligibility(item);
            return Response.status(200).entity(eligibility).build();
        }
    }
}