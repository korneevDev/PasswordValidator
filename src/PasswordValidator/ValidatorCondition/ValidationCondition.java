package PasswordValidator.ValidatorCondition;

public interface ValidationCondition {
    boolean checkCondition(String string);
    String getDescription();
}
