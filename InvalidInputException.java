import java.util.InputMismatchException;
/***
 * Class to represent Invalid Input Exception
 * @author Alec Jang
 * @version 0.1
 * Date of creation: Febraury 17, 2022
 * Last Date Modified: February 20, 2022
 */
public class InvalidInputException extends InputMismatchException{
    /**
     * Default constructor
     * Calls super() default constructor
     */
    public InvalidInputException() {
        super();
    }
    /**
     * Constructor w/ single parameter
     * @param message String to represent message to print out
     * Calls super constructor and passes message as argument
     */
    public InvalidInputException (String message) {
        super(message);
    }
}
