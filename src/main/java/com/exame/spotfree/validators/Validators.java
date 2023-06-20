package com.exame.spotfree.validators;

import com.exame.spotfree.exceptions.EmptyListException;

import java.util.List;

public class Validators {

    public static void isEmptyList(String message, List<?> list) throws EmptyListException {
        if(list.isEmpty()){
            throw new EmptyListException( message );
        }
    }
}
