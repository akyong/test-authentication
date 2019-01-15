package test.authentication.services;

import test.authentication.repository.PasswordGeneratorRepository;

import java.nio.charset.Charset;
import java.util.Random;

public class PasswordGeneratorService implements PasswordGeneratorRepository {

    @Override
    public String createRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
