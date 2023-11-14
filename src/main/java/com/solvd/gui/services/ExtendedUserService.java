package com.solvd.gui.services;

import com.solvd.gui.objects.ExtendedUser;

import static com.solvd.gui.services.RandomGen.generateRandomNameOrSurname;
import static com.solvd.gui.services.RandomGen.generateEmail;
import static com.solvd.gui.services.RandomGen.generateValidPassword;

public class ExtendedUserService {


    public static ExtendedUser generateRandomValidUser() {

        return new ExtendedUser(generateRandomNameOrSurname(),generateRandomNameOrSurname(),
                generateEmail(),generateValidPassword());
    }
}
