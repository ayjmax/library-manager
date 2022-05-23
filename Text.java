/***
 * Class to model a Text object
 * @author Alec Jang
 * @version 0.1
 * Date of creation: February 17, 2022
 * Last Date Modified: Febraury 20, 2022
 */
public abstract class Text implements Comparable<Text>, Restorable{
    //Data members
    private String callNum, title, publisher;
    private int copies, pubYear;
    /**
     * Default constructor
     * Initializes callNUm, title, and publiusher to null
     * Initializes copies and pubYear to -1
     */
    public Text() {
        callNum = title = publisher = null;
        copies = pubYear = -1;
    }
    /**
     * Constructor w/ 5 parameters
     * @param callNum for call number
     * @param title for title of text
     * @param publisher for publisher of text
     * @param pubYear for publishing year of text
     * @param copies for number of copies
     */
    public Text(String callNum, String title, String publisher, int pubYear, int copies) {
        this.callNum = callNum;
        this.title = title;
        this.publisher = publisher;
        this.copies = copies;
        this.pubYear = pubYear;
    }
    /**
     * Method to set call number
     * @param callNum for call number
     * No return values
     */
    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }
    /**
     * Method to set title
     * @param title for title of text
     * No return value
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Method to set publisher
     * @param publisher for publisher of text
     * No return value
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    /**
     * Method to set number of copies
     * @param copies for number of copies
     * No return value
     */
    public void setCopies (int copies) {
        this.copies = copies;
    }
    /**
     * Method to set publishing year
     * @param pubYear for publishing year of text
     * No return value
     */
    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
    /**
     * Method to get call number
     * No params
     * @return String callNum
     */
    public String getCallNum() {
        return callNum;
    }
    /**
     * Method to get title
     * No params
     * @return String title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Method to get publisher of text
     * No params
     * @return String publisher
     */
    public String getPublisher() {
        return publisher;
    }
    /**
     * Method to return number of copies
     * No params
     * @return int copies
     */
    public int getCopies() {
        return copies;
    }
    /**
     * Method to return publishing year
     * No params
     * @return int pubYear
     */
    public int getPubYear() {
        return pubYear;
    }
    /**
     * Method to get Text information
     * No params
     * @return String w/ data members of Text Object
     */
    @Override
    public String toString() {
        return String.format("%-20s%-50s%-25s%d", callNum, title, publisher, pubYear);
    }
    /**
     * Method to get simplified text info
     * No params
     * @return String w/ data members of Text Object
     */
    public String fileString() {
        return String.format("%s\n%s\n%s\n%d\n%d", callNum, title, publisher, pubYear, copies);
    }
    /**
     * Method to compare 2 Text objects
     * @param t Text object
     * @return int based on comparison
     */
    @Override
    public int compareTo(Text t) {
        if (pubYear == t.getPubYear()) {
            return 0;
        }
        else if (pubYear > t.getPubYear()) {
            return 1;
        }
        return -1;
    }
    /**
     * Method to return whether Text object is restorable
     * No params
     * @return boolean whether Text object is restorable
     */
    public boolean isRestorable() {
        if (pubYear - 2022 < (-20)) {
            return true;
        }
        return false;
    }
}
