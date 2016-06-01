package edu.umg.p3.structures;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by fvcg on 6/1/16.
 */
public class BPTreeTest {

    @Test
    public void instanceTreeTest() {
        BPlusTree tree = new BPlusTree(10);

        assertNotNull(tree);
    }
}
