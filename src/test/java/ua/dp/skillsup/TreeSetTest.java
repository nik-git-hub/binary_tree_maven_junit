package ua.dp.skillsup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeSetTest {

    private TreeSet set;

    @BeforeEach
    public void init() {
        set = new TreeSet();
    }

    @Test
    @DisplayName("Add value.")
    public void shouldAddOneValue() {
        set.add("D");
        set.add("G");
        set.add("A");
        set.add("H");
        set.add("B");
        set.add("C");
        set.add("F");
        set.add("E");
        assertEquals(8, set.size());
    }

    @Test
    @DisplayName("The values must be unique.")
    public void shouldBeUniqValue() {
        set.add("C");
        set.add("C");
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Set contains element <F>.")
    public void shouldContainsLeftValue() {
        set.add("D");
        set.add("G");
        set.add("A");
        set.add("H");
        set.add("B");
        set.add("C");
        set.add("F");
        set.add("E");
        assertTrue(set.contains("F"));
    }

    @Test
    @DisplayName("Set doesn't contain null.")
    public void shouldNotContainNull() {
        set.add(null);
        assertFalse(set.contains(null));
    }

    @Test
    @DisplayName("Set is not empty.")
    public void shouldBeNotEmpty() {
        set.add("W");
        assertFalse(set.isEmpty());

    }
    @Test
    @DisplayName("Show set")
    public void shouldShowSet() {
        set.add("D");
        set.add("G");
        set.add("A");
        set.add("H");
        set.add("B");
        set.add("C");
        set.add("F");
        set.add("E");
        assertEquals("ABCDEFGH",set.show());
    }

}
