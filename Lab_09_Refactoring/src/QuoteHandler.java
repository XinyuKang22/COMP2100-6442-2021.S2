import java.util.ArrayList;
import java.util.List;

/**
 * Author: Person Y
 * Traits:
 * - Unhelpful comments
 * - Unsure of difference between static and non-static
 * - Commented out unfinished code
 * What cannot be changed:
 * - Class name
 * - Any method names
 * - quoteStorage field name
 * Naming requirement:
 * - QuoteFactory class field must be named quoteFactory (can be in either RequestHandler or QuoteHandler)
 */
public class QuoteHandler {

    private final List<Quote> quoteStorage;
    private final QuoteFactory quoteFactory;
    private static QuoteHandler instance = null;

    private QuoteHandler() {
        quoteStorage = new ArrayList<>();
        quoteFactory = new QuoteFactory();
    }

    public static QuoteHandler getInstance(){
        if (instance == null){
            instance = new QuoteHandler();
        }
        return instance;
    }

    public static QuoteHandler getNewInstance(){
        return new QuoteHandler();
    }

    /**
     * Add a new quote into quoteStorage
     * @param quote the quote content as a string
     * @param type the quote type as a string
     */
    public void add(String quote, String type) {
        quoteStorage.add(quoteFactory.createQuote(quote, type));
    }

    /**
     * Add a Quote object into quoteStorage
     * @param quote a Quote object
     */
    public void add(Quote quote){
        quoteStorage.add(quote);
    }

    /**
     * Get all quotes stored in quoteStorage
     * @return a copy of quoteStorage
     */
    public List<Quote> get() {
        return new ArrayList<>(quoteStorage);
    }

    /**
     * Get the quotes with a certain type string
     * @param type quote type as a string
     * @return a list of quotes
     */
    public List<Quote> get(String type){
        List<Quote> filtered = new ArrayList<>();
        for (Quote quote : quoteStorage){
            if (quote.getType().toString().equals(type)){
                filtered.add(quote);
            }
        }
        return filtered;
    }

    /**
     * Get the quotes with a certain type
     * @param type quote type
     * @return a list of quotes
     */
    public List<Quote> get(Quote.QuoteType type){
        List<Quote> filtered = new ArrayList<>();
        for (Quote quote : quoteStorage){
            if (quote.getType() != type){
                filtered.add(quote);
            }
        }
        return filtered;
    }

}
