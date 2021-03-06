package com.jobhive.sakimonkey.utils;

import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {

    private static final long serialVersionUID = 1L;

    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(StringBuilder builder) {
        this.builder = builder;
    }

    /**
     * Append a single character to this Writer.
     *
     * @param value
     *            The character to append
     * @return This writer instance
     */
    @Override
    public Writer append(char value) {
        builder.append(value);
        return this;
    }

    /**
     * Append a character sequence to this Writer.
     *
     * @param value
     *            The character to append
     * @return This writer instance
     */
    @Override
    public Writer append(CharSequence value) {
        builder.append(value);
        return this;
    }

    /**
     * Append a portion of a character sequence to the {@link StringBuilder}.
     *
     * @param value
     *            The character to append
     * @param start
     *            The index of the first character
     * @param end
     *            The index of the last character + 1
     * @return This writer instance
     */
    @Override
    public Writer append(CharSequence value, int start, int end) {
        builder.append(value, start, end);
        return this;
    }

    /**
     * Closing this writer has no effect.
     */
    @Override
    public void close() {
    }

    /**
     * Flushing this writer has no effect.
     */
    @Override
    public void flush() {
    }

    /**
     * Write a String to the {@link StringBuilder}.
     * 
     * @param value
     *            The value to write
     */
    @Override
    public void write(String value) {
        if (value != null) {
            builder.append(value);
        }
    }

    /**
     * Write a portion of a character array to the {@link StringBuilder}.
     *
     * @param value
     *            The value to write
     * @param offset
     *            The index of the first character
     * @param length
     *            The number of characters to write
     */
    @Override
    public void write(char[] value, int offset, int length) {
        if (value != null) {
            builder.append(value, offset, length);
        }
    }

    /**
     * Return the underlying builder.
     *
     * @return The underlying builder
     */
    public StringBuilder getBuilder() {
        return builder;
    }

    /**
     * Returns {@link StringBuilder#toString()}.
     *
     * @return The contents of the String builder.
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}