package ru.palinov.My3TestAppSpringBoot.exception;

public class ValidationFailedException extends Exception
{
    public ValidationFailedException(String message)
    {
        super(message);
    }
}