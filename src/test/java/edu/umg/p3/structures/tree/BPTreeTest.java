package edu.umg.p3.structures.tree;

import edu.umg.p3.structures.tree.BTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by fvcg on 6/1/16.
 */
public class BPTreeTest {


    @Test
    public void insertTreeNodeTest() {
        String key = "1";
        String data = "This is a test data";
        BTree<String, String> tree = new BTree<>(5);
        assertNotNull(tree);

        tree.insert(key, data);

        String value = tree.search(key);

        assertEquals(value, data);
    }

    @Test
    public void deleteTreeNodeTest() {
        String key = "1";
        String data = "This is a test data";

        String key2 = "2";
        String data2 = "This a second test data";

        BTree<String, String> tree = new BTree<>(5);
        assertNotNull(tree);

        tree.insert(key, data);
        tree.insert(key2, data2);

        tree.delete(key2);

        assertNull(tree.search(key2));
        assertNotNull(tree.search(key));
        assertEquals(data, tree.search(key));

    }
}
