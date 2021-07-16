package Utils;
import java.util.List;

import beans.Project;
public interface ProjectUtilsDAO {
	public boolean addProject(Project project);
	public List<Project> getAllProject();
	public Project getProject(int p_id);
	public boolean updateProject(Project project);
	public boolean registerProject(Project project);
}
