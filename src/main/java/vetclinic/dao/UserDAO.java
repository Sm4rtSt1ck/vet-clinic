package vetclinic.dao;

import org.mindrot.jbcrypt.BCrypt;
import vetclinic.DatabaseManager;
import vetclinic.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements GenericDAO<User>{
    private Connection connection;

    public UserDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    @Override
    public void add(User entity) throws SQLException {
        String update = "INSERT INTO Users (login, name, address, phone_number, password_hash, access_level)" +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setString(1, entity.getLogin());
        stmt.setString(2, entity.getName());
        stmt.setString(3, entity.getAddress());
        stmt.setString(4, entity.getPhoneNumber());
        stmt.setString(5, entity.getPasswordHash());
        stmt.setInt(6, entity.getAccessLevel());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public User get(int id) throws SQLException {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        User user = new User(
                id,
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("phone_number"),
                resultSet.getString("login"),
                resultSet.getString("password_hash"),
                resultSet.getInt("access_level"));
        stmt.close();
        resultSet.close();

        return user;
    }

    public User get(String login, String passwordHash) throws SQLException {
        String query = "SELECT * FROM Users WHERE login = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, login);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next() && BCrypt.checkpw(passwordHash, resultSet.getString("password_hash"))) {
            User user = new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number"),
                    login,
                    resultSet.getString("password_hash"),
                    resultSet.getInt("access_level"));
            stmt.close();
            resultSet.close();
            return user;
        }
        stmt.close();
        resultSet.close();
        throw new SQLException();
    }

    @Override
    public void update(User entity) throws SQLException {
        String update = "UPDATE Users SET login = ?, name = ?, address = ?, phone_number = ?, password_hash = ?, access_level = ? WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setString(1, entity.getLogin());
        stmt.setString(2, entity.getName());
        stmt.setString(3, entity.getAddress());
        stmt.setString(4, entity.getPhoneNumber());
        stmt.setString(5, entity.getPasswordHash());
        stmt.setInt(6, entity.getAccessLevel());
        stmt.setInt(7, entity.getUserId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        String update = "DELETE FROM Users WHERE user_id = ?";
        PreparedStatement stmt = connection.prepareStatement(update);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
}
