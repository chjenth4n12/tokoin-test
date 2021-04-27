package com.tungxuannguyen.tokoin.services;

import com.tungxuannguyen.tokoin.Tokoin;
import com.tungxuannguyen.tokoin.entity.OrganizationResponse;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;
import com.tungxuannguyen.tokoin.service.OrganizationService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tokoin.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class OrganizationServiceTest {

  @Autowired
  OrganizationService organizationService;

  private List<Organization> organizations = new ArrayList<>();
  private List<Ticket> tickets = new ArrayList<>();
  private List<User> users = new ArrayList<>();
  private Organization organization = new Organization();

  @Before
  public void setUp() {
    organization.setId(116);
    organization.setUrl("http://initech.tokoin.io.com/api/v2/organizations/116.json");
    organization.setExternalId("dbc692fc-e1ae-47d8-a1d7-263d07710fe1");
    organization.setName("Zentry");
    organization.setCreatedAt("2016-01-13T09:34:07 -11:00");
    organization.setDetails("Artisan");
    organization.setSharedTickets(false);
    organization.setDomainNames(new String[]{"datagene.com"});
    organization.setTags(new String[]{"Schneider"});
    organizations.add(organization);
  }

  @Test
  public void testFindOrganizationById() {
    OrganizationResponse result = this.organizationService.findOrganizationById(organizations, tickets, users, 116);
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByIdNotFound() {
    assertThrows(NoSuchElementException.class, () -> this.organizationService.findOrganizationById(organizations, tickets, users, 123456));
  }

  @Test
  public void testFindOrganizationByIdField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "_id", "116");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByIdFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "_id", "123456");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationByUrlField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "url", "http://initech.tokoin.io.com/api/v2/organizations/116.json");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByUrlFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "url", "url");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationByExternalIdField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "external_id", "dbc692fc-e1ae-47d8-a1d7-263d07710fe1");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByExternalIdFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "external_id", "external_id");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationByNameField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "name", "Zentry");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByNameFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "name", "name");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationByCreatedAtField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "created_at", "2016-01-13T09:34:07 -11:00");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByCreatedAtFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "created_at", "created_at");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationByDetailsField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "details", "Artisan");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByDetailsFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "details", "details");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationBySharedTicketsField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "shared_tickets", "false");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByDomainNamesField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "domain_names", "datagene.com");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByDomainNamesFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "domain_names", "domain_names");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationByTagsField() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "tags", "Schneider");
    assertNotNull(result);
  }

  @Test
  public void testFindOrganizationByTagsFieldNotFound() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "tags", "domain_names");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindOrganizationWithNullKey() {
    assertThrows(NullPointerException.class, () -> this.organizationService.findOrganizationBySearchable(organizations, tickets, users, null, null));
  }

  @Test
  public void testFindOrganizationWithInvalidKey() {
    List<OrganizationResponse> result = this.organizationService.findOrganizationBySearchable(organizations, tickets, users, "key", null);
    assertEquals(0, result.size());
  }
}
