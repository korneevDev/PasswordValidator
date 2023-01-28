package PasswordValidator.ValidatorCondition;

public interface ValidationCondition {
    String getDescription();
    boolean checkCondition(String string);
}
