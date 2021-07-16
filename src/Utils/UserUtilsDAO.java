package Utils;
import beans.User;
public interface UserUtilsDAO {
	public User validate(String email,String password,String role);
}
