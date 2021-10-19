/**
 * Author: Z
 * Traits:
 * - Helpful comments
 * - Did not understand project leading to unnecessary or unused code beyond class purpose
 * - Does not use make use of exceptions
 */
public class Quote {
    // Defines the types of quotes
    public enum QuoteType {
        PHILOSOPHICAL, MOTIVATIONAL, DISCOURAGEMENT, HAPPY, SAD;
    }

    // Fields
    private final String quote;
    private final QuoteType type;
    private String author;

    // Constructors
    public Quote(String quote, QuoteType type) {
        this.quote = quote;
        this.type = type;
        this.author = "";
    }

    public Quote(String quote, QuoteType type, String author) {
        this.quote = quote;
        this.type = type;
        this.author = author;
    }

    /**
     * Sets quote author
     * @param author String
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return String quote
     */
    public String getQuote() {
        return quote;
    }

    /**
     * @return QuoteType
     */
    public QuoteType getType() {
        return type;
    }

    /**
     * @return String author name
     */
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", type=" + type +
                '}';
    }
}
