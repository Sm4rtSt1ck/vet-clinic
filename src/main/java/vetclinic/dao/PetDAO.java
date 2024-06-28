package vetclinic.dao;

import vetclinic.DatabaseManager;
import vetclinic.model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements GenericDAO<Pet>{
    private Connection connection;

    public PetDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    public List<Pet> getAllPets() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM Pets";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("pet_id");
            String name = resultSet.getString("name");
            int ownerId = resultSet.getInt("owner_id");
            int breedId = resultSet.getInt("breed_id");
            pets.add(new Pet(id, name, ownerId, breedId));
        }

        resultSet.close();
        stmt.close();

        return pets;
    }

    @Override
    public void add(Pet entity) {

    }

    @Override
    public Pet get(int id) {
        return null;
    }

    @Override
    public void update(Pet entity) {

    }

    @Override
    public void delete(int id) {

    }
}
