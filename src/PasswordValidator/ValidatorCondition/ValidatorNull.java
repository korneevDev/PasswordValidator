package PasswordValidator.ValidatorCondition;

public class ValidatorNull implements ValidationCondition {
    @Override
    public boolean checkCondition(String string){
        return string != null;
    }

    @Override
    public String getDescription(){
        return "Is string null?";
    }
}
