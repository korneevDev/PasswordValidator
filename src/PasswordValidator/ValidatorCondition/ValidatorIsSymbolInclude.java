package PasswordValidator.ValidatorCondition;

public class ValidatorIsSymbolInclude implements ValidationCondition{
    @Override
    public boolean checkCondition(String string){
        return string.matches(".*[~`! @#$%^&*()_\\-+={\\[}\\]|:;\"'<,>.?/].*");
    }

    @Override
    public String getDescription(){
        return "Is symbol in password?";
    }
}
