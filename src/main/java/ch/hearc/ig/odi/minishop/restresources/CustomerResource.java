/*
 * Copyright (c) 2018. Cours Outils de développement intégré, HEG Arc.
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("customer")


public class CustomerResource {
  @Inject
  private PersistenceService persistenceService;


  @GET
  public List<Customer> getCustomer() {
    return persistenceService.getAllCustomers();
  }

}

