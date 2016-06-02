package edu.umg.p3.dto;

/**
 * Created by fvcg on 6/1/16.
 */
public class FileStructure {
    private int order;
    private String name;
    private int size;
    private boolean key;

    private FileStructure(Builder builder) {
        order = builder.order;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private int size;
        private boolean key;
        private int order;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withSize(int val) {
            size = val;
            return this;
        }

        public Builder withKey(boolean val) {
            key = val;
            return this;
        }

        public FileStructure build() {
            return new FileStructure(this);
        }

        public Builder withOrder(int val) {
            order = val;
            return this;
        }
    }
}
