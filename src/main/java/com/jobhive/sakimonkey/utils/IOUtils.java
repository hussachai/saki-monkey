package com.jobhive.sakimonkey.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.Charsets;

import com.jobhive.sakimonkey.exception.IORuntimeException;


public class IOUtils {

    private static final int EOF = -1;

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public static String readFileToString(File file){
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
            return new String(encoded, "UTF-8");
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }
    
    public static String toString(InputStream input, String encoding)
            throws IOException {
        StringBuilderWriter sw = new StringBuilderWriter();
        copy(input, sw, encoding);
        return sw.toString();
    }

    public static void copy(InputStream input, Writer output, String encoding)
            throws IOException {
        InputStreamReader in = new InputStreamReader(input,
                Charsets.toCharset(encoding));
        copy(in, output);
    }

    public static int copy(Reader input, Writer output) throws IOException {
        long count = copyLarge(input, output);
        if (count > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) count;
    }

    public static long copyLarge(Reader input, Writer output)
            throws IOException {
        return copyLarge(input, output, new char[DEFAULT_BUFFER_SIZE]);
    }

    public static long copyLarge(Reader input, Writer output, char[] buffer)
            throws IOException {
        long count = 0;
        int n = 0;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
}
