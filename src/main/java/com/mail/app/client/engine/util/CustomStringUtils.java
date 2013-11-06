package com.mail.app.client.engine.util;

/**
 * Since GWT can't compile StringUtils class from commons.lang package, given
 * class is its replacement with a set of required methods.
 * 
 */
public class CustomStringUtils {
    /**
     * The empty String "".
     */
    public static final String EMPTY = "";
    /**
     * <p>
     * The maximum size to which the padding constant(s) can expand.
     * </p>
     */
    private static final int PAD_LIMIT = 8192;
    /**
     * p>An array of <code>String</code>s used for padding.</p>
     * <p>
     * Used for efficient space padding. The length of each String expands as
     * needed.
     * </p>
     */
    private static final String[] PADDING = new String[Character.MAX_VALUE];
    static {
        // space padding is most common, start with 64 chars
        PADDING[32] = " ";
    }

    /**
     * Checks if a String is empty ("") or null. <br>
     * <code>StringUtils.isEmpty(null) = true StringUtils.isEmpty("") = true</code>
     * <br>
     * <code>StringUtils.isEmpty(" ") = false StringUtils.isEmpty("bob") = false</code>
     * <br>
     * <code>StringUtils.isEmpty("  bob  ") = false</code>
     * 
     * @param str
     *            - the String to check, may be null.
     * @return <tt>true</tt> if the String is empty or null, <tt>false</tt>
     *         otherwise.
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * Checks if a String is not empty ("") and not null. <br>
     * 
     * <code>StringUtils.isNotEmpty(null) = false
     * <br> 
     * StringUtils.isNotEmpty("") = false</code> <br>
     * <code>StringUtils.isNotEmpty(" ") = true
     * <br> 
     * StringUtils.isNotEmpty("bob") = true</code> <br>
     * <code>StringUtils.isNotEmpty("  bob  ") = true</code><br>
     * 
     * @param str
     *            - the String to check, may be null.
     * @return <code>true</code> if the String is not empty and not null,
     *         <code>false</code> otherwise.
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && str.length() > 0);
    }

    /**
     * Checks if strings are not empty ("") and not null. <br>
     * 
     * @param strings
     *            - the string array to check, may be null.
     * @return <code>true</code> if the strings are not empty and not null,
     *         <code>false</code> otherwise.
     */
    public static boolean areStringsNotEmpty(String... strings) {
        if (strings == null)
            return false;
        for (String str : strings) {
            if (str == null || str.length() == 0)
                return false;
        }
        return true;
    }

    /**
     * <p>
     * Compares two Strings, returning <code>true</code> if they are equal.
     * </p>
     * 
     * <p>
     * <code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered to be equal. The comparison is case sensitive.
     * </p>
     * 
     * <pre>
     * StringUtils.equals(null, null)   = true
     * StringUtils.equals(null, "abc")  = false
     * StringUtils.equals("abc", null)  = false
     * StringUtils.equals("abc", "abc") = true
     * StringUtils.equals("abc", "ABC") = false
     * </pre>
     * 
     * @param str1
     *            - the first String, may be null.
     * @param str2
     *            - the second String, may be null.
     * @return <code>true</code> if the Strings are equal, case sensitive, or
     *         both <code>null</code>
     */
    public static boolean equals(final String str1, String str2) {
        return (str1 == null || str1.equals(EMPTY)) ? (str2 == null || str2.equals(EMPTY)) : str1.equals(str2);
    }

    /**
     * <p>
     * Checks if the String contains only unicode digits. A decimal point is not
     * a unicode digit and returns false.
     * </p>
     * 
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String ("")
     * will return <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isNumeric(null)   = false
     * StringUtils.isNumeric("")     = true
     * StringUtils.isNumeric("  ")   = false
     * StringUtils.isNumeric("123")  = true
     * StringUtils.isNumeric("12 3") = false
     * StringUtils.isNumeric("ab2c") = false
     * StringUtils.isNumeric("12-3") = false
     * StringUtils.isNumeric("12.3") = false
     * </pre>
     * 
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if only contains digits, and is non-null
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Right pad a String with a specified String.
     * </p>
     * 
     * <p>
     * The String is padded to the size of <code>size</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.rightPad(null, *, *) = null
     * StringUtils.rightPad("", 3, "z") = "zzz"
     * StringUtils.rightPad("bat", 3, "yz") = "bat"
     * StringUtils.rightPad("bat", 5, "yz") = "batyz"
     * StringUtils.rightPad("bat", 8, "yz") = "batyzyzy"
     * StringUtils.rightPad("bat", 1, "yz") = "bat"
     * StringUtils.rightPad("bat", -1, "yz") = "bat"
     * StringUtils.rightPad("bat", 5, null) = "bat "
     * StringUtils.rightPad("bat", 5, "") = "bat "
     * </pre>
     * 
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padStr
     *            the String to pad with, null or empty treated as single space
     * @return right padded String or original String if no padding is
     *         necessary, <code>null</code> if null String input
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }
        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    /**
     * <p>
     * Right pad a String with a specified character.
     * </p>
     * 
     * <p>
     * The String is padded to the size of <code>size</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.rightPad(null, *, *) = null
     * StringUtils.rightPad("", 3, 'z') = "zzz"
     * StringUtils.rightPad("bat", 3, 'z') = "bat"
     * StringUtils.rightPad("bat", 5, 'z') = "batzz"
     * StringUtils.rightPad("bat", 1, 'z') = "bat"
     * StringUtils.rightPad("bat", -1, 'z') = "bat"
     * </pre>
     * 
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padChar
     *            the character to pad with
     * @return right padded String or original String if no padding is
     *         necessary, <code>null</code> if null String input
     * @since 2.0
     * 
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    /**
     * <p>
     * Returns padding using the specified delimiter repeated to a given length.
     * </p>
     * 
     * <pre>
     * StringUtils.padding(0, 'e') = ""
     * StringUtils.padding(3, 'e') = "eee"
     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
     * </pre>
     * 
     * @param repeat
     *            number of times to repeat delim
     * @param padChar
     *            character to repeat
     * @return String with repeated character
     * @throws IndexOutOfBoundsException
     *             if <code>repeat &lt; 0</code>
     * 
     */
    private static String padding(int repeat, char padChar) {
        String pad = PADDING[padChar];
        if (pad == null) {
            pad = String.valueOf(padChar);
        }
        while (pad.length() < repeat) {
            pad = pad.concat(pad);
        }
        PADDING[padChar] = pad;
        return pad.substring(0, repeat);
    }
}
