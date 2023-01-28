package PasswordValidator.ValidatorCondition;

public class ValidatorLength implements ValidationCondition {
    private final int length;

    public ValidatorLength(int length){
        this.length = length;
    }

    @Override
    public boolean checkCondition(String string){
        return string.length() > length;
    }

    @Override
    public String getDescription(){
        return "Is length less or equal than " + this.length + "?";
    }
}
