package ua.dp.skillsup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeSetTest {

    private TreeSet set;

    @BeforeEach
    void init() {
        set = new TreeSet();
    }

    @Test
    @DisplayName("Add value.")
    void shouldAddOneValue() {
        set.add("B");
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("The values must be unique.")
    void shouldBeUniqValue() {
        set.add("C");
        set.add("C");
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Set contains element <C>.")
    void shouldContainsLeftValue() {
        set.add("D");
        set.add("G");
        set.add("B");
        set.add("H");
        set.add("A");
        set.add("C");
        set.add("F");
        set.add("E");
        assertTrue(set.contains("C"));
    }

    @Test
    @DisplayName("Set doesn't contain null.")
    void shouldNotContainNull() {
        set.add(null);
        assertFalse(set.contains(null));
    }

    @Test
    @DisplayName("Set is not empty.")
    void shouldBeNotEmpty() {
        set.add("W");
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Show set")
    void shouldShowSet() {
        set.add("D");
        set.add("F");
        set.add("B");
        set.add("H");
        set.add("A");
        set.add("C");
        set.add("G");
        set.add("E");
        assertEquals("ABCDEFGH", set.show());
    }

}
