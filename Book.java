/***
 * Class to model a Book object
 * @author Alec Jang
 * @version 0.1
 * Date of creation: February 17, 2022
 * Last Date Modified: Febraury 20, 2022
 */
public class Book extends Text{
    //Data members
    private long ISBN;
    private String author;
    /**
     * Default constructor
     * Calls super default constructor
     * Initializes ISBN to -1 and author to null
     */
    public Book() {
        super();
        ISBN = -1;
        author = null;
    }
    /**
     * Constructor w/ 7 parameters
     * @param callNum for call number
     * @param title for title of book
     * @param publisher for publisher of book
     * @param pubYear for publishing year of book
     * @param copies for number of copies
     * @param author for author of book
     * @param ISBN for ISBN number
     * Calls super constructor, passes callNum, title, publisher, pubYear, and copies as arguments
     * Initializes ISBN and author w/ respective arguments
     */
    public Book (String callNum, String title, String publisher, int pubYear,
                    int copies, String author, long ISBN)
    {
        super(callNum, title, publisher, pubYear, copies);
        this.ISBN = ISBN;
        this.author = author;
    }
    /**
     * Method to set ISBN
     * @param  for ISBN number of book
     * No return value
     */
    public void setISBN(long isbn) {
        ISBN = isbn;
    }
    /**
     * Method to set author name
     * @param author for author name
     * No return value
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Method to return ISBN number
     * No params
     * @return ISBN number
     */
    public long getISBN() {
        return ISBN;
    }
    /**
     * Method to return author name
     * No params
     * @return author name
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Method to return get simplified Book info
     * No params
     * @return String w/ Book data members
     */
    @Override
    public String fileString() {
        return String.format("%s\n%s\n%d", super.fileString(), author, ISBN);
    }
}
