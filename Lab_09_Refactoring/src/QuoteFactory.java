/**
 * Author: Z
 * Traits:
 * - Helpful comments
 * - Did not understand project
 * - Did not understand project leading to unnecessary or unused code beyond class purpose
 * - Does not use make use of exceptions
 */
public class QuoteFactory {
    /**
     * Creates a new quote
     * @param quote string
     * @param type string representing type of quote
     * @return Quote
     */
    public Quote createQuote(String quote, String type) {
        return new Quote(quote, tokenize(type));
    }

    /**
     * Converts a string into a QuoteType
     * @param type string of the type
     * @return QuoteType or error
     */
    public Quote.QuoteType tokenize(String type) {
        switch (type.toLowerCase()) {
            case "philosophical":
                return Quote.QuoteType.PHILOSOPHICAL;
            case "motivational":
                return Quote.QuoteType.MOTIVATIONAL;
            case "discouragement":
                return Quote.QuoteType.DISCOURAGEMENT;
            case "happy":
                return Quote.QuoteType.HAPPY;
            case "sad":
                return Quote.QuoteType.SAD;
            default:
                throw new IllegalArgumentException();
        }
    }
}