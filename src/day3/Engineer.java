package day3;

public class Engineer extends Person {
    private String position;
    private boolean abilityToExecuteTests;
    private boolean abilityToInventCode;

    public Engineer(String position, boolean abilityToExecuteTests, boolean abilityToInventCode, String name, String surname, int age, boolean abilityToSpeak) {
        this.position = position;
        this.abilityToExecuteTests = abilityToExecuteTests;
        this.abilityToInventCode = abilityToInventCode;
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setAbilityToSpeak(abilityToSpeak);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isAbilityToExecuteTests() {
        return abilityToExecuteTests;
    }

    public void setAbilityToExecuteTests(boolean abilityToExecuteTests) {
        this.abilityToExecuteTests = abilityToExecuteTests;
    }

    public boolean isAbilityToInventCode() {
        return abilityToInventCode;
    }

    public void setAbilityToInventCode(boolean abilityToInventCode) {
        this.abilityToInventCode = abilityToInventCode;
    }
}