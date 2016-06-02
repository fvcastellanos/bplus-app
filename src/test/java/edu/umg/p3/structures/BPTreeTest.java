package edu.umg.p3.structures;

import edu.umg.p3.structures.tree.BTree;
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

    @Test
    public void insertTreeNodeTest() {
        BPlusTree tree = new BPlusTree(5);

        tree.insertIntoTree(new DataNode(10));
        tree.insertIntoTree(new DataNode(20));
        tree.insertIntoTree(new DataNode(30));
        tree.insertIntoTree(new DataNode(40));
        tree.insertIntoTree(new DataNode(12));
        tree.insertIntoTree(new DataNode(1));

    }

    @Test
    public void testTest() {
        BTree<String, String> tree;
    }
}
