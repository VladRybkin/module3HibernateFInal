package model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Skills")
public class Skill {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "skillID")
    private int skillId;
    @Column(name = "skillName")
    private String skillName;

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Skill(int skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public Skill() {
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
