package com.rslakra.theorem.algos.text;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Apr 03, 2021 16:27:17
 */
public enum RegExp {
    INSTANCE;

    private enum RegExpEnum {
        /**
         * Java email validation permitted by RFC 5322 All the characters permitted by RFC 5322, which governs the email
         * message format. Among the permitted characters are some that present a security risk if passed directly from
         * user input to an SQL statement, such as the single quote (‘) and the pipe character (|).
         */
        // Pattern.compile("^[a-zA-Z0-9_!#$%&*+/=?{}~^.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]+){2,}$");
        // Pattern.compile("^(?=.{6,50}@)[A-Za-z0-9_!#$%&*+]+(\\.[A-Za-z0-9_!#$%&*+]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        EMAIL("^(?=.{1,50}@)[a-zA-Z0-9_!#$%&*+/=?{}~^.-]+@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"),

        /**
         * REGEX_PHONE = "^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$";
         * <p>
         * Regardless of the way the phone number is entered, the capture groups can be used to breakdown the phone
         * number so you can process it in your code.
         *
         * <pre>
         * Group1: Country Code (ex: 1 or 86)
         * Group2: Area Code (ex: 800)
         * Group3: Exchange (ex: 555)
         * Group4: Subscriber Number (ex: 1234)
         * Group5: Extension (ex: 5678)
         *
         * Here is a breakdown of the expression if you're interested:
         *
         * ^\s*                #Line start, match any whitespaces at the beginning if any.
         * (?:\+?(\d{1,3}))?   #GROUP 1: The country code. Optional.
         * [-. (]*             #Allow certain non numeric characters that may appear between the Country Code and the Area Code.
         * (\d{3})             #GROUP 2: The Area Code. Required.
         * [-. )]*             #Allow certain non numeric characters that may appear between the Area Code and the Exchange number.
         * (\d{3})             #GROUP 3: The Exchange number. Required.
         * [-. ]*              #Allow certain non numeric characters that may appear between the Exchange number and the Subscriber number.
         * (\d{4})             #Group 4: The Subscriber Number. Required.
         * (?: *x(\d+))?       #Group 5: The Extension number. Optional.
         * \s*$                #Match any ending whitespaces if any and the end of string.
         * </pre>
         * <p>
         * To make the Area Code optional, just add a question mark after the (\d{3}) for the area code.
         */
        // Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$");
        PHONE("^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$"),

        /**
         * ZipCode Validation - USA
         *
         * <pre>
         * A breakdown of the ZIP code regular expression follows:
         *
         * ^           # Assert position at the beginning of the string.
         * [0-9]{5}    # Match a digit, exactly five times.
         * (?:         # Group but don't capture:
         * -           # Match a literal "-".
         * [0-9]{4}    # Match a digit, exactly four times.
         * )           # End the non-capturing group.
         * ?           # Make the group optional.
         * $           # Assert position at the end of the string.
         * </pre>
         */
        ZIP_CODE_USA("^[0-9]{5}(?:-[0-9]{4})?$"),

        /**
         * ZipCode Validation - CA
         * <p>
         * The negative lookahead at the beginning of this regular expression prevents D, F, I, O, Q, or U anywhere in
         * the subject string. The ‹[A-VXY]› character class further prevents W or Z as the first character. Aside from
         * those two exceptions, Canadian postal codes simply use an alternating sequence of six alphanumeric characters
         * with an optional space in the middle.
         * <p>
         * For example, the regex will match K1A 0B1, which is the postal code for Canada Post’s Ottawa headquarters.
         */
        ZIP_CODE_CA("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z]?[0-9][A-Z][0-9]$"),

        // Password
        PASSWORD("^[A-Za-z0-9!#$%&()\\[\\]*+,-.:;<=>?@^_{}~]{8,128}$"),

        // First Name, Last Name
        NAME("^[A-Za-z']{2,40}$"),

        // Bank Account & Routing Number
        ACCOUNT_ROUTING_NUMBER("^[0-9]{6,25}$"),

        // URLs
        URL("^http(?:s)?://[\\w+\\.]*[\\w+]$"),
        ;

        private Pattern pattern;

        /**
         * @param regExp
         */
        private RegExpEnum(final String regExp) {
            pattern = Pattern.compile(regExp);
        }

        /**
         * Returns the zipCode pattern based on the country code.
         *
         * @param countryCode
         * @return
         */
        private static RegExpEnum ofZipCode(final String countryCode) {
            return (RegExpEnum.valueOf("ZIP_CODE_" + countryCode.toUpperCase()));
        }

        /**
         * @param input
         * @return
         */
        private boolean isMatches(final String input) {
            return pattern.matcher(input).matches();
        }
    }

    /**
     * @param input
     * @param regEx
     * @return
     */
    public static boolean isMatches(final String input, final String regEx) {
        return input.matches(regEx);
    }

    /**
     * Returns true if the email address is valid otherwise false.
     *
     * @param email
     * @return
     */
    public static boolean isValidEmail(final String email) {
        return RegExpEnum.EMAIL.isMatches(email);
    }

    /**
     * Returns true if the phone number is valid otherwise false.
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isValidPhone(final String phoneNumber) {
        return RegExpEnum.PHONE.isMatches(phoneNumber);
    }

    /**
     * Returns true if the <code>zipCode</code> is valid for the given <country>countryCode</country> otherwise false.
     *
     * @param countryCode
     * @param zipCode
     * @return
     */
    public static boolean isValidZipCode(final String countryCode, final String zipCode) {
//        if (BeanUtils.isNotNullOrEmpty(countryCode) && BeanUtils.isNotNullOrEmpty(zipCode)) {
        return RegExpEnum.ofZipCode(countryCode).isMatches(zipCode);
//        }

//        return false;
    }


    /**
     * Returns true if the password is valid otherwise false.
     *
     * @param password
     * @return
     */
    public static boolean isValidPassword(final String password) {
        return /*BeanUtils.isNotNullOrEmpty(password) && */ RegExpEnum.PASSWORD.isMatches(password);
    }

    /**
     * Returns true if the name is valid otherwise false.
     *
     * @param name
     * @return
     */
    public static boolean isValidName(final String name) {
        return RegExpEnum.NAME.isMatches(name);
    }

    /**
     * Returns true if the bank account and routing number is valid otherwise false.
     *
     * @param number
     * @return
     */
    public static boolean isValidAccountRoutingNumber(final String number) {
        return RegExpEnum.ACCOUNT_ROUTING_NUMBER.isMatches(number);
    }

    public static boolean isValidUrl(final String urlString) {
        return RegExpEnum.URL.isMatches(urlString);
    }

    public static void main(String[] args) {
        List<String>
            urls =
            Arrays.asList("http://devamatre.com", "https://devamatre.com", "http://www.devamatre.com",
                          "https://www.devamatre.com", "http://website.devamatre.com",
                          "http://www.website.devamatre.com", "https://website.devamatre.com",
                          "https://www.website.devamatre.com");
        for (String url : urls) {
            System.out.println(url + ", matches:" + RegExp.isValidUrl(url));
        }
    }

}
