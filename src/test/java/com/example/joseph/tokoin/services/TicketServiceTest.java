package com.example.joseph.tokoin.services;

import com.tungxuannguyen.tokoin.Tokoin;
import com.tungxuannguyen.tokoin.entity.TicketResponse;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;
import com.tungxuannguyen.tokoin.service.TicketService;
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
public class TicketServiceTest {

  @Autowired
  TicketService ticketService;

  private List<Organization> organizations = new ArrayList<>();
  private List<Ticket> tickets = new ArrayList<>();
  private List<User> users = new ArrayList<>();
  private Organization organization = new Organization();
  private Ticket ticket = new Ticket();
  private User user = new User();

  @Before
  public void setUp() {
    ticket.setId("13aafde0-81db-47fd-b1a2-94b0015803df");
    ticket.setUrl("http://initech.tokoin.io.com/api/v2/tickets/13aafde0-81db-47fd-b1a2-94b0015803df.json");
    ticket.setExternalId("6161e938-50cc-4545-acff-a4f23649b7c3");
    ticket.setCreatedAt("2016-03-30T08:35:27 -11:00");
    ticket.setType("task");
    ticket.setSubject("A Problem in Malawi");
    ticket.setDescription("Lorem ipsum eiusmod pariatur enim. Qui aliquip voluptate cupidatat eiusmod aute velit non aute ullamco.");
    ticket.setPriority("urgent");
    ticket.setStatus("solved");
    ticket.setSubmitterId(1);
    ticket.setAssigneeId(1);
    ticket.setOrganizationId(122);
    ticket.setTags(new String[]{"New Mexico"});
    ticket.setHasIncidents(false);
    ticket.setDueAt("2016-08-08T03:25:53 -10:00");
    ticket.setVia("voice");
    tickets.add(ticket);
    organization.setId(122);
    organization.setUrl("http://initech.tokoin.io.com/api/v2/organizations/122.json");
    organization.setExternalId("33c4e38d-bfa3-4b12-9bb6-6f547524cf33");
    organization.setName("Geekfarm");
    organization.setDomainNames(new String[]{"comstar.com"});
    organization.setCreatedAt("2016-04-10T11:12:35 -10:00");
    organization.setDetails("Non profit");
    organization.setSharedTickets(true);
    organization.setTags(new String[]{"Hensley"});
    organizations.add(organization);
    user.setId(1);
    user.setUrl("http://initech.tokoin.io.com/api/v2/users/1.json");
    user.setExternalId("74341f74-9c79-49d5-9611-87ef9b6eb75f");
    user.setName("Francisca Rasmussen");
    user.setAlias("Miss Coffey");
    user.setCreatedAt("2016-04-15T05:19:46 -10:00");
    user.setActive(true);
    user.setVerified(true);
    user.setShared(false);
    user.setLocale("en-AU");
    user.setTimezone("Sri Lanka");
    user.setLastLoginAt("2013-08-04T01:03:27 -10:00");
    user.setEmail("coffeyrasmussen@flotonic.com");
    user.setPhone("8335-422-718");
    user.setSignature("Don't Worry Be Happy!");
    user.setOrganizationId(122);
    user.setTags(new String[]{"Springville"});
    user.setSuspended(true);
    user.setRole("admin");
    users.add(user);
  }

  @Test
  public void testFindTicketById() {
    TicketResponse result = this.ticketService.findTicketById(organizations, tickets, users, "13aafde0-81db-47fd-b1a2-94b0015803df");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByIdNotFound() {
    assertThrows(NoSuchElementException.class, () -> this.ticketService.findTicketById(organizations, tickets, users, "test"));
  }

  @Test
  public void testFindTicketByUrl() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "url", "http://initech.tokoin.io.com/api/v2/tickets/c527e065-ec62-40ed-aa72-136f5ab0eb89.json");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByUrlNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "url", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByExternalId() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "external_id", "cf722acf-35c2-40a2-9b65-c193efb9baa8");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByExternalIdNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "external_id", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByCreatedAt() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "created_at", "2016-02-19T07:11:16 -11:00");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByCreatedAtNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "created_at", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByType() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "type", "question");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByTypeNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "type", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketBySubject() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "subject", "A Catastrophe in France");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketBySubjectNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "subject", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByDescription() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "description", "Mollit velit mollit irure est ea dolor ipsum aliqua nostrud laborum sint sunt. Irure quis mollit nisi et deserunt sunt dolore velit sunt.");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByDescriptionNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "description", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByPriority() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "priority", "high");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByPriorityNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "priority", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByStatus() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "status", "hold");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByStatusNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "status", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketBySubmitterId() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "submitter_id", "25");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketBySubmitterIdNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "submitter_id", "12345");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByAssigneeId() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "assignee_id", "30");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByAssigneeIdNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "assignee_id", "12345");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByOrganizationId() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "organization_id", "121");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByOrganizationIdNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "organization_id", "12345");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByTags() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "tags", "California");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByTagsNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "tags", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByHasIncidents() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "has_incidents", "false");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByDueAt() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "due_at", "2016-08-06T04:15:59 -10:00");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByDueAtNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "due_at", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketByVia() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "via", "chat");
    assertNotNull(result);
  }

  @Test
  public void testFindTicketByViaNotFound() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "via", "test");
    assertEquals(0, result.size());
  }

  @Test
  public void testFindTicketWithNullKey() {
    assertThrows(NullPointerException.class, () -> this.ticketService.findTicketBySearchable(organizations, tickets, users, null, null));
  }

  @Test
  public void testFindTicketWithInvalidKey() {
    List<TicketResponse> result = this.ticketService.findTicketBySearchable(organizations, tickets, users, "key", null);
    assertEquals(0, result.size());
  }
}
