import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {
    private Tree<Node> tree;

    @Before
    public void set_up() throws Exception {
        tree = new Tree<>();
    }

    @Test
    public void is_empty() {
        assertTrue(tree.isEmpty());

        tree.add(4);
        assertFalse(tree.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_one_node_multiple_times() {
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(6);

    }

    @Test
    public void add_and_contains() {
        assertFalse("do not contain 4", tree.contains(4));
        tree.add(4);
        assertTrue("contains 4", tree.contains(4));

        assertFalse("do not contain 2", tree.contains(2));
        assertFalse("do not contain 6", tree.contains(6));

        tree.add(2);
        tree.add(6);

        assertTrue("contains 2", tree.contains(2));
        assertTrue("contains 6", tree.contains(6));
    }

    @Test
    public void get_elements() {
        int[] arr = new int[]{3, 1, 2, 5, 4, 6, 7};
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }

        List<Node> nodeList = tree.getElements();
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i + 1, nodeList.get(i).getValue());
        }
    }
}