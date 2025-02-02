import controller.RegisterController;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import view.RegisterView;

public class Main {
    public static void main(String[] args) {
        RegisterView view = new RegisterView();
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        new RegisterController(view, mapper);
        view.setVisible(true);
    }
}
