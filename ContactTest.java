package contactService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        assertNotNull(contact);
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", null, "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", null, "1234567890", "123 Elm St"));
    }

    @Test
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "12345", "123 Elm St"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "1234567890", null));
    }

    @Test
    void testSetFirstName() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testSetLastName() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testSetPhoneNumber() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testSetAddress() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        contact.setAddress("456 Maple St");
        assertEquals("456 Maple St", contact.getAddress());
    }
}
