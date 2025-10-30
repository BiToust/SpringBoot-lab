package ru.palinov.My4TestAppSpringBoot.exception;

public class ValidationFailedException extends Exception
{
    public ValidationFailedException(String message)
    {
        super(message);
    }
}