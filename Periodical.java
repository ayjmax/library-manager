/***
 * Class to model a Periodical Object
 * @author Alec Jang
 * @version 0.1
 * Date of creation: February 17, 2022
 * Last Date Modified: Febraury 20, 2022
 */
public class Periodical extends Text{
    //Data members
    private int month, issueNum;
    /**
     * Deafult constructor
     * Calls super constructor, initializes month and issueNum to -1
     */
    public Periodical() {
        super();
        month = issueNum = -1;
    }
    /**
     * Constructor w/ 7 parameters
     * @param callNum for callNum
     * @param title for title of periodical
     * @param publisher for publisher of periodical
     * @param pubYear for publishing year of periodical
     * @param copies for number of copies
     * @param month for issue month of periodical
     * @param issueNum for issue number of periodical
     * Calls super constructor and passes callNum, title, publisher, pubYear, and copies as arguments
     * Initializes month and issueNum w/ respective arguments
     */
    public Periodical(String callNum, String title, String publisher, int pubYear,
                        int copies, int month, int issueNum)
    {
        super(callNum, title, publisher, pubYear, copies);
        this.month = month;
        this.issueNum = issueNum;
    }
    /**
     * Method to set month
     * @param month for issue month of periodical
     * No return value
     */
    public void setMonth(int month) {
        this.month = month;
    }
    /**
     * Method to set issue number
     * @param issueNum for issue number of periodical
     * No return value
     */
    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }
    /**
     * Method to return month
     * No params
     * @return month of publication
     */
    public int getMonth() {
        return month;
    }
    /**
     * Method to return issue number
     * No params
     * @return issue number
     */
    public int getIssueNum() {
        return issueNum;
    }
    /**
     * Method to get simplified Periodical info
     * No params
     * @return String w/ Periodical data members
     */
    @Override
    public String fileString() {
        return String.format("%s\n%d\n%d", super.fileString(), month, issueNum);
    }
}
