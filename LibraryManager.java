import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
/***
 * Class to manage a catalogue of Text objects
 * @author Alec Jang
 * @version 0.1
 * Date of creation: February 17, 2022
 * Last Date Modified: Febraury 20, 2022
 */
public class LibraryManager {
    /**
     * Method to print menu options
     * No params
     * No return value
     */
    public static void printMenu() {
        System.out.println("----------Select an operation:----------\n" + "1: View all titles\n"
        + "2: Search by call number\n" + "3: Search by title\n"
        + "4: Search by year\n" + "5: Add new title\n"
        + "6: Remove title\n" + "7: Sort titles by year\n"
        + "8: View Titles due for restoration\n" + "9: Exit");
    }
    /**
     * Method to print text objects in an arraylist
     * @param tList for arraylist of text objects
     * No return value
     */
    public static void printTitles(ArrayList<Text> tList) {
        for (Text t : tList) {
            System.out.println(t);
        }
    }
    /**
     * Method to check validity of a call number input
     * @param c for call number
     * @throws InvalidInputException
     * No return value
     */
    public static void checkCallNum (String c) throws InvalidInputException {
        if (!c.matches("[PB](-\\d\\d\\d){3}")) {
            throw new InvalidInputException ("Invalid call number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
        }
    }
    /**
     * Method to check validity of ISBN input
     * @param isbn for ISBN to check
     * @throws InvalidInputException
     * No return value
     */
    public static void checkISBN(String isbn) throws InvalidInputException {
        if (!(isbn.matches("\\d{10}"))) {
            throw new InvalidInputException ("Invalid ISBN. Must be long integer w/ 10 digits");
        }
    }
    /**
     * Method to check validity of year input
     * @param year for year to check
     * @throws InvalidInputException
     * No return value
     */
    public static void checkYear(String year) throws InvalidInputException {
        if (!(year.matches("\\d{4}") && year.compareTo("2022") <= 0 && year.compareTo("1900") >= 0)) {
            throw new InvalidInputException("Invalid year. Must be integer between 1900 and 2022");
        }
    }
    /**
     * Method to check validity of month input
     * @param month for month to check
     * @throws InvalidInputException
     * No return value
     */
    public static void checkMonth(String month) throws InvalidInputException {
        if (!month.matches("[1-9]|10|11|12")) {
            throw new InvalidInputException("Invalid month. Must be integer [1-12]");
        }
    }
    /**
     * Method to find a title in arraylist of text objects
     * @param title for title to search for
     * @param tList arraylist of titles to search through
     * @return index of text object if found; otherwise, return -1
     */
    public static int findTitle(String title, ArrayList<Text> tList) {
        for (int i = 0; i < tList.size(); i ++) {
            if (tList.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Method to insertion sort arraylist of text objects
     * @param tList arraylist to sort
     * No return value
     */
    public static void sortList (ArrayList<Text> tList) {
        for (int i = 1; i < tList.size(); i++)
        {
            int j = i - 1;
            while (j >= 0 && tList.get(j).compareTo(tList.get(j+1)) > 0)
            {
                Text temp = tList.get(j);
                tList.set(j, tList.get(j+1));
                tList.set(j+1, temp);
                j--;
            }
        }
    }
    /**
     * Main method
     * @param args
     * No return value
     */
    public static void main(String[] args) {
        String userInput, callNum, title, publisher, author, year, type, isbn, month;
        int counter, copies, issueNum;
        userInput = callNum = null;
        Scanner keyboard = new Scanner (System.in);
        ArrayList<Text> titleList = new ArrayList<Text>();
        ArrayList<Text> foundText = new ArrayList<Text>();
        try {
            File titleFile = new File("titles.txt");
            Scanner readFile = new Scanner(titleFile);
            while (readFile.hasNextLine()) {
                callNum = readFile.nextLine();
                if (callNum.charAt(0) == 'P') {
                    titleList.add(new Periodical(callNum, readFile.nextLine(), readFile.nextLine(),
                                    Integer.parseInt(readFile.nextLine()), Integer.parseInt(readFile.nextLine()),
                                    Integer.parseInt(readFile.nextLine()), Integer.parseInt(readFile.nextLine())));
                }
                else {
                    titleList.add(new Book(callNum, readFile.nextLine(), readFile.nextLine(),
                                    Integer.parseInt(readFile.nextLine()), Integer.parseInt(readFile.nextLine()),
                                    readFile.nextLine(), Long.parseLong(readFile.nextLine())));
                }
            }
            readFile.close();

            do {
                counter = 0;
                printMenu();
                userInput = keyboard.nextLine();
                if (!userInput.matches("[1-9]")) {
                    System.out.println("Invalid input. Must be integer [1-9]");
                    continue;
                }
                switch(userInput) {
                    case "1":
                        printTitles(titleList);
                        break;
                    case "2":
                        System.out.println("Enter a call number:");
                        callNum = keyboard.nextLine();
                        try {
                            checkCallNum(callNum);
                        }
                        catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        for (Text t : titleList) {
                            if (t.getCallNum().equals(callNum)) {
                                System.out.println("Text Found:\n" + "CallNumber: " + callNum
                                                    + "\nTitle: " + t.getTitle()
                                                    + "\nPublisher: " + t.getPublisher()
                                                    + "\nYear: " + t.getPubYear()
                                                    + "\nCopies: " + t.getCopies());
                                if (t.getClass() == Book.class) {
                                    System.out.println("Author: " + ((Book)t).getAuthor()
                                                        + "\nISBN: " + ((Book)t).getISBN());
                                }
                                else {
                                    System.out.println("Month: " + ((Periodical)t).getMonth()
                                                        + "\nIssueNumber: " + ((Periodical)t).getIssueNum());
                                }
                                counter++;
                                break;
                            }
                        }
                        if (counter == 0) {
                            System.out.println("Title not found.");
                        }
                        break;
                    case "3":
                        System.out.println("Enter a title to find:");
                        title = keyboard.nextLine();
                        for (Text t : titleList) {
                            if (t.getTitle().equals(title)) {
                                counter++;
                                foundText.add(t);
                            }
                        }
                        if (counter != 0) {
                            System.out.println("List of titles found: " + counter);
                            printTitles(foundText);
                            foundText.clear();
                            break;
                        }
                        System.out.println("No titles found.");
                        break;
                    case "4":
                        System.out.println("Enter a year:");
                        year = keyboard.nextLine();
                        try {
                            checkYear(year);
                        }
                        catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        for (Text t : titleList) {
                            if (t.getPubYear() == Integer.parseInt(year)) {
                                counter++;
                                foundText.add(t);
                            }
                        }
                        if (counter != 0) {
                            System.out.println("List of titles found: " + counter);
                            printTitles(foundText);
                            foundText.clear();
                            break;
                        }
                        System.out.println("No titles found.");
                        break;
                    case "5":
                        System.out.println("Enter a title:");
                        title = keyboard.nextLine();
                        System.out.println("Enter the publisher:");
                        publisher = keyboard.nextLine();
                        System.out.println("Enter the year of publication:");
                        try {
                            year = keyboard.nextLine();
                            checkYear(year);
                            System.out.println("Enter number of copies:");
                            if (!keyboard.hasNextInt()) {
                                throw new InvalidInputException ("Invalid input. Must be integer.");
                            }
                            copies = keyboard.nextInt();
                            keyboard.nextLine();
                            System.out.println("Enter the type of title (book/periodical):");
                            type = keyboard.nextLine().toLowerCase();
                            if (!type.matches("(book|periodical)")) {
                                throw new InvalidInputException ("Invalid type. Must be periodical or book.");
                            }
                            System.out.print("Enter call number ");
                            System.out.println(type.equals("book") ? "(B-ddd-ddd-ddd):" : "(P-ddd-ddd-ddd):");
                            callNum = keyboard.nextLine();
                            checkCallNum(callNum);
                            if (type.equals("book")) {
                                System.out.println("Enter the author:");
                                author = keyboard.nextLine();
                                System.out.println("Enter ISBN:");
                                isbn = keyboard.nextLine();
                                checkISBN(isbn);
                                titleList.add(new Book(callNum, title, publisher, Integer.parseInt(year),
                                                copies, author, Long.parseLong(isbn)));
                            }
                            else {
                                System.out.println("Enter a month:");
                                month = keyboard.nextLine();
                                checkMonth(month);
                                System.out.println("Enter issue number:");
                                if (!keyboard.hasNextInt()) {
                                    throw new InvalidInputException ("Invalid issue number. Must be integer.");
                                }
                                issueNum = keyboard.nextInt();
                                keyboard.nextLine();
                                titleList.add(new Periodical(callNum, title, publisher, Integer.parseInt(year),
                                                copies, Integer.parseInt(month), issueNum));
                            }
                            System.out.println("New title successfully added.");
                        }
                        catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "6":
                        System.out.println("Enter a title to remove:");
                        title = keyboard.nextLine();
                        int indexRemove = findTitle(title, titleList);
                        if (indexRemove != -1) {
                            titleList.remove(indexRemove);
                            System.out.println("\"" + title + "\"" + " removed successfully.");
                            break;
                        }
                        System.out.println("Title not found in list.");
                        break;
                    case "7":
                        sortList(titleList);
                        //Could also use Collections.sort(titleList);
                        System.out.println("List successfully sorted.");
                        break;
                    case "8":
                        for (Text t : titleList) {
                            if (t.isRestorable()) {
                                counter++;
                                foundText.add(t);
                            }
                        }
                        if (counter != 0) {
                            System.out.println("List of titles found: " + counter);
                            printTitles(foundText);
                            foundText.clear();
                            break;
                        }
                        System.out.println("No titles found.");
                        break;
                    default:
                        PrintWriter writeFile = new PrintWriter(titleFile);
                        for (Text t : titleList) {
                            writeFile.println(t.fileString());
                        }
                        System.out.println("File successfully saved.");
                        writeFile.close();
                        break;
                }
            } while (!userInput.equals("9"));
            System.out.println("Thanks for using my program. Bye!");
            keyboard.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}