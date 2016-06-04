package edu.umg.p3.dto;

import static org.apache.commons.lang.StringUtils.leftPad;

/**
 * Created by fvcg on 6/1/16.
 */
public class Field {
    private int order;
    private String name;
    private int size;
    private boolean key;
    private String value;

    private Field(Builder builder) {
        setOrder(builder.order);
        setName(builder.name);
        setSize(builder.size);
        setKey(builder.key);
        setValue(builder.value);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getValue() {
        return value;
    }

    public String getFullValue() {
        return leftPad(value, size - value.length(), ' ');
    }

    public boolean isKey() {
        return key;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static final class Builder {
        private int order;
        private String name;
        private int size;
        private boolean key;
        private String value;

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

        public Builder withSize(int val) {
            size = val;
            return this;
        }

        public Builder withKey(boolean val) {
            key = val;
            return this;
        }

        public Builder withValue(String val) {
            value = val;
            return this;
        }

        public Field build() {
            return new Field(this);
        }
    }
}
