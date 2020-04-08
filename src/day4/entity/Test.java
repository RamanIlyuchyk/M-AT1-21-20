package day4.entity;

import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;

import java.util.function.Function;

public abstract class Test implements Function<Engineer, Result> {
    private int complexity;
    private int instability;

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
        this.instability = instability;
    }

    public Test(TestLevel testLevel) {
        this.complexity = testLevel.COMPLEXITY;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if (this instanceof ManualTest && engineer instanceof AutomationEngineer) {
            anxiety = engineer.getAnxiety();
        } else {
            if (this instanceof AutomatedTest && engineer instanceof TestEngineer) {
                anxiety = engineer.getAnxiety();
            } else {
                anxiety = 1;
            }
        }
        if (complexity * instability * anxiety > 30) {
            return Result.FAILED;
        } else {
            return Result.PASSED;
        }
    }
}