package se.kth.iv1350.felixselling.mypos.integration;

import java.time.LocalDateTime;

/**
 * Thrown when attempt to connect to database fails.
 */
public class DatabaseConnectionFailureException extends Exception {
    DatabaseConnectionFailureException(String msg) {
        super(msg);
        System.out.println("LOG: " + LocalDateTime.now() + " Could not connect do database.");
    }

}
