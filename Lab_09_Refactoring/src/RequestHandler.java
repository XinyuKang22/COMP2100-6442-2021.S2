import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author: Person X
 * Trails:
 * - No comments
 * - Unnecessary complication of code
 * - Difficult to understand, unconventional code
 * What cannot be changed:
 * - Class name
 * - Any method names, input and return type
 * - quoteHandler field name and type
 * Naming requirement:
 * - QuoteFactory class field must be named quoteFactory (can be in either RequestHandler or QuoteHandler)
 */
public class RequestHandler {

    private final QuoteHandler quoteHandler;
    private static RequestHandler instance = null;

    private RequestHandler() {
        quoteHandler = QuoteHandler.getNewInstance();
    };

    public static RequestHandler getInstance(){
        if (instance == null){
            instance = new RequestHandler();
        }
        return instance;
    }

    /**
     * Get all quotes
     * @return a list of quotes
     */
    public String[] getQuotes() {
        List<String> quoteList = new ArrayList<>();
        for (Quote quote : quoteHandler.get()){
            quoteList.add(quote.getQuote());
        }
        return quoteList.toArray(new String[0]);
    }

    /**
     * Get quotes in a specific type
     * @param type quote type as a string
     * @return a list of quotes of the type
     */
    public String[] getQuotes(String type) {
        List<String> quoteList = new ArrayList<>();
        for (Quote quote : quoteHandler.get()){
            if (quote.getType().toString().equalsIgnoreCase(type)){
                quoteList.add(quote.getQuote());
            }
        }
        return quoteList.toArray(new String[0]);
    }

    /**
     * Add a new quote, return true if succeed and return false if failed
     * @param quote the quote content as a string
     * @param type the quote type as a string
     * @return true if succeed and false if failed
     */
    public boolean addQuote(String quote, String type) {
        try {
            quoteHandler.add(quote, type);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}