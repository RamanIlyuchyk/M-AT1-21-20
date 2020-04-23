package entity;

import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.function.Function;

public abstract class Test implements Function<Engineer, Result> {
    private int complexity, instability;

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getInstability() {
        return instability;
    }

    public void setInstability(int instability) {
        if (instability <= 0) {
            this.instability = 1;
        } else if (instability > 10) {
            this.instability = 10;
        } else {
            this.instability = instability;
        }
    }

    public Test(TestLevel testLevel, int instability) {
        this.complexity = testLevel.COMPLEXITY;
        this.setInstability(instability);
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if ((this instanceof ManualTest && engineer instanceof AutomationEngineer) ||
                (this instanceof AutomatedTest && engineer instanceof TestEngineer)) {
            anxiety = engineer.getAnxiety();
        } else {
            anxiety = 1;
        }
        System.out.println(String.format("Internal complexity is: %s", complexity * instability * anxiety / engineer.getSkill()));
        if (complexity * instability * anxiety / engineer.getSkill() > 30) {
            return Result.FAILED;
        } else {
            return Result.PASSED;
        }
    }
}