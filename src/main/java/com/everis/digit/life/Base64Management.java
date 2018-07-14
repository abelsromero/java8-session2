package com.everis.digit.life;

import com.google.common.io.BaseEncoding;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;

public class Base64Management {

    public static void main(String[] args) throws IOException {

        /**
         * Apache Commons
         */
        byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64("Hola mundo!".getBytes());
        byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(encoded);
        System.out.println(String.format("'%s' from Apache", new String(decoded)));

        /**
         * Guava
         */
        String encoded1 = BaseEncoding.base64().encode("Hola mundo!".getBytes());
        byte[] decoded1 = BaseEncoding.base64().decode(encoded1);
        System.out.println(String.format("'%s' from Guava", new String(decoded1)));

        /**
         * "Standard" Java
         */
        java7();
        java8();
    }

    /**
     * This will show a warning message during compilation and won't work by default in Java9.
     */
    private static void java7() throws IOException {
        String encoded = new BASE64Encoder().encode("Hola mundo!".getBytes());
        byte[] decoded = new BASE64Decoder().decodeBuffer(encoded);
        System.out.println(String.format("'%s' from Java7", new String(decoded)));
    }

    /**
     * This is the Java8 recommended way.
     */
    private static void java8() {
        byte[ ] encoded = Base64.getEncoder().encode("Hola mundo!".getBytes());
        byte[] decoded = Base64.getDecoder().decode(encoded);
        System.out.println(String.format("'%s' from Java8", new String(decoded)));
    }

}
