package controller;

import model.User;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import view.RegisterView;

import javax.swing.*;

public class RegisterController {
    private RegisterView view;
    private UserMapper mapper;

    public RegisterController(RegisterView view, UserMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        view.getRegisterButton().addActionListener(e -> registerUser());
    }

    private void registerUser() {
        String username = view.getUsername();
        String password = view.getPassword();
        String email = view.getEmail();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(view, "All fields are required!");
            return;
        }

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setUsername(username);
            user.setPassword(password); // Nanti gunakan hashing
            user.setEmail(email);

            mapper.registerUser(user);
            session.commit();

            JOptionPane.showMessageDialog(view, "Registration successful!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
        }
    }
}
