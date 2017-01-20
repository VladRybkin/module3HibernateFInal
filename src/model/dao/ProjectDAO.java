package model.dao;

import java.util.List;

/**
 * Created by asevruk on 12/9/2016.
 */
public interface ProjectDAO<Project> extends DAO<Project> {
    Project findByName(String name);
    public List<Project> getAll();
}
