package ru.palinov.My5TestAppSpringBoot.exception;

public class ValidationFailedException extends Exception
{
    public ValidationFailedException(String message)
    {
        super(message);
    }
}