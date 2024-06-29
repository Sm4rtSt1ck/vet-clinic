package vetclinic.dao;

import vetclinic.DatabaseManager;
import vetclinic.model.Vet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VetDAO implements GenericDAO<Vet>{
    private Connection connection;

    public VetDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    @Override
    public void add(Vet entity) {

    }

    @Override
    public Vet get(int id) throws SQLException {
        String query = "SELECT * FROM Vets WHERE vet_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            Vet vet = new Vet(
                    resultSet.getInt("vet_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number"));
            stmt.close();
            resultSet.close();
            return vet;
        }

        resultSet.close();
        stmt.close();
        throw new SQLException();
    }

    @Override
    public void update(Vet entity) {

    }

    @Override
    public void delete(int id) {

    }
}
