package contactService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	 @Test
	    void testAddContact() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");

	        service.addContact(contact);

	        assertNotNull(service.getContact("123"));
	    }

	    @Test
	    void testDeleteContact() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");

	        service.addContact(contact);
	        service.deleteContact("123");

	        assertNull(service.getContact("123"));
	    }

	    @Test
	    void testUpdateFirstName() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");

	        service.addContact(contact);
	        service.updateContact("123", "Jane", null, null, null);

	        assertEquals("Jane", service.getContact("123").getFirstName());
	    }

	    @Test
	    void testUpdateLastName() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");

	        service.addContact(contact);
	        service.updateContact("123", null, "Smith", null, null);

	        assertEquals("Smith", service.getContact("123").getLastName());
	    }

	    @Test
	    void testUpdatePhoneNumber() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");

	        service.addContact(contact);
	        service.updateContact("123", null, null, "0987654321", null);

	        assertEquals("0987654321", service.getContact("123").getPhone());
	    }

	    @Test
	    void testUpdateAddress() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");

	        service.addContact(contact);
	        service.updateContact("123", null, null, null, "456 Maple St");

	        assertEquals("456 Maple St", service.getContact("123").getAddress());
	    }

	    @Test
	    void testDuplicateContactId() {
	        ContactService service = new ContactService();
	        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
	        Contact contact2 = new Contact("123", "Jane", "Smith", "0987654321", "456 Maple St");

	        service.addContact(contact1);

	        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
	    }
