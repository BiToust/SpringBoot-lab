package ru.arkhipov.my2TestAppSpringBoot.exception;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message) { super( message); }
}
