package edu.umg.p3.structures;

public class DataNode {
    // I chose Integer because it allows a null value, unlike int
    private Integer data;

    public DataNode() {
        data = null;
    }

    public String toString() {
        return data.toString();
    }
    public DataNode(int x) {
        data = x;
    }
    public int getData() {
        return data.intValue();
    }
    public boolean inOrder(DataNode dnode) {
        return (dnode.getData() <= this.data.intValue());
    }
}
