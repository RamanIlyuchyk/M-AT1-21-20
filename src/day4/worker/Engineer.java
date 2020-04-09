package day4.worker;

import day4.entity.Result;
import day4.entity.Test;

public abstract class Engineer {
    protected int maxSkill = 10;
    protected int anxiety = 3;
    private int skill;

    public int getAnxiety() {
        return anxiety;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill() {
        this.skill = (int) (1 + Math.random() * maxSkill);
    }

    public Result executeTest(Test test) {
        return null;
    }
}