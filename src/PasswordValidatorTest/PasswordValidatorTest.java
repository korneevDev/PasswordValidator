package PasswordValidatorTest;

import PasswordValidator.ValidationResult.ValidationResult;
import PasswordValidator.ValidationResult.ValidationResultError;
import PasswordValidator.ValidationResult.ValidationResultSuccessful;
import PasswordValidator.ValidatorChain;
import PasswordValidator.ValidatorCondition.*;
import PasswordValidator.ValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private static ValidatorChain validator;

    @BeforeAll
    public static void before(){
        validator = new ValidatorChain(new ValidatorImpl(new ValidatorNull()),
                    new ValidatorChain(new ValidatorImpl(new ValidatorEmptyString()),
                    new ValidatorChain(new ValidatorImpl(new ValidatorLength(5)),
                    new ValidatorChain(new ValidatorImpl(new ValidatorIsLetterLowerCaseInclude()),
                    new ValidatorChain(new ValidatorImpl(new ValidatorIsLetterUpperCaseInclude()),
                    new ValidatorChain(new ValidatorImpl(new ValidatorIsNumberInclude()),
                    new ValidatorImpl(new ValidatorIsSymbolInclude())))))));
    }

    @Test
    public void test_successful(){
        ValidationResult expected = new ValidationResultSuccessful();
        ValidationResult actual = validator.isValid("876dfjks*(&Hiyvua");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_emptyString(){
        ValidationResult expected = new ValidationResultError("Is string empty?");
        ValidationResult actual = validator.isValid("");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_smallString(){
        ValidationResult expected = new ValidationResultError("Is length less or equal than 5?");
        ValidationResult actual = validator.isValid("ugj");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_nullString(){
        ValidationResult expected = new ValidationResultError("Is string null?");
        ValidationResult actual = validator.isValid(null);

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_stringWithoutNumber(){
        ValidationResult expected = new ValidationResultError("Is number included in password?");
        ValidationResult actual = validator.isValid("hukojiIHhuggy");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());

    }

    @Test
    public void test_stringWithoutLetterLowerCase(){
        ValidationResult expected = new ValidationResultError("Is letter on lower case included in password?");
        ValidationResult actual = validator.isValid("9876546JIHJ78");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_stringWithoutLetterUpperCase(){
        ValidationResult expected = new ValidationResultError("Is letter on upper case included in password?");
        ValidationResult actual = validator.isValid("98765467oji8");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_stringWithoutSymbol(){
        ValidationResult expected = new ValidationResultError("Is symbol in password?");
        ValidationResult actual = validator.isValid("ijhugyuftFDV987");

        Assertions.assertEquals(expected.getStatus(), actual.getStatus());
        Assertions.assertEquals(expected.toString(), actual.toString());
    }
}
