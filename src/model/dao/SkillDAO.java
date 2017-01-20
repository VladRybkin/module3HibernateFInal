package model.dao;
import java.util.List;

public interface SkillDAO<Skill> extends DAO<Skill> {
    public Skill findByName(String name);
    public List<Skill> getAll();
}
