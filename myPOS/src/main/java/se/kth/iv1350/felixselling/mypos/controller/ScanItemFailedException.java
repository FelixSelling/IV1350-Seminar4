package se.kth.iv1350.felixselling.mypos.controller;

/**
 * Thrown when method scanItem catches more specific exception.
 */
public class ScanItemFailedException extends Exception {

    ScanItemFailedException(String msg) {
        super(msg);
    }
}
