/*
 * Copyright (c) 2018. Cours Outils de développement intégré, HEG Arc.
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.exception.CustomerException;
import ch.hearc.ig.odi.minishop.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class CustomerResource {

  @Inject
  private PersistenceService persistenceService;

  @GET
  public List<Customer> getCustomer() {
    return persistenceService.getAllCustomers();
  }

  @GET
  @Path("{id}")
  public Customer getProduct(@PathParam("id") Long customerId) throws CustomerException {
    return persistenceService.getCustomerByID(customerId);
  }

  @POST
  @Consumes (MediaType.APPLICATION_FORM_URLENCODED)
  public Customer createCustomer(
    @FormParam("unsername") String unserName,
    @FormParam("firstname") String firstName,
    @FormParam("lastname") String lastName,
     @FormParam("email") String email,
    @FormParam("phone") String phone){
   return persistenceService.createAndPersistCustomer(unserName,firstName,lastName,email,phone);
  }


}

