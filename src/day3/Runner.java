package day3;

public class Runner {
    public static void main(String[] args) {
        Engineer manualEngineer = new Engineer("Manual engineer",
                true, false,
                "Anna", "Garunovich",
                24, true);
        Engineer automationEngineer = new Engineer("Automation engineer",
                true, true,
                "Roman", "Iliuchik",
                23, true);
        System.out.println(manualEngineer.getPosition()
                + "\nAbility to execute tests: " + manualEngineer.isAbilityToExecuteTests()
                + "\nAbility to invent code: " + manualEngineer.isAbilityToInventCode()
                + "\n" + manualEngineer.getName() + " " + manualEngineer.getSurname() + ", " + manualEngineer.getAge() + " y.o."
                + "\nAbility to speak: " + manualEngineer.isAbilityToSpeak());
        System.out.print("\n" + automationEngineer.getPosition()
                + "\nAbility to execute tests: " + automationEngineer.isAbilityToExecuteTests()
                + "\nAbility to invent code: " + automationEngineer.isAbilityToInventCode()
                + "\n" + automationEngineer.getName() + " " + automationEngineer.getSurname() + ", " + automationEngineer.getAge() + " y.o."
                + "\nAbility to speak: " + automationEngineer.isAbilityToSpeak());
    }
}