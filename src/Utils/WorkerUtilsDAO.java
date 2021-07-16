package Utils;
import java.util.List;

import beans.Workers;
public interface WorkerUtilsDAO {
	public boolean registerWorker(Workers worker);
	public List<Workers> getAllWorker();
	public Workers getWorkersDetails(int w_id);
}
