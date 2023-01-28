package PasswordValidator.ValidatorCondition;

public class ValidatorEmptyString extends ValidatorLength{
    public ValidatorEmptyString(){
        super(0);
    }

    @Override
    public String getDescription(){
        return "Is string empty?";
    }
}
