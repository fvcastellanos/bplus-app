package edu.umg.p3.dto;

import static org.apache.commons.lang.StringUtils.leftPad;

/**
 * Created by fvcg on 6/1/16.
 */
public class Field {
    private int order;
    private String name;
    private Integer size;
    private boolean key;

    private Field(Builder builder) {
        order = builder.order;
        name = builder.name;
        size = builder.size;
        key = builder.key;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int order;
        private String name;
        private Integer size;
        private boolean key;

        private Builder() {
        }

        public Builder withOrder(int val) {
            order = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withSize(Integer val) {
            size = val;
            return this;
        }

        public Builder withKey(boolean val) {
            key = val;
            return this;
        }

        public Field build() {
            return new Field(this);
        }
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
}
