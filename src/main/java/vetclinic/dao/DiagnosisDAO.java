package vetclinic.dao;

import vetclinic.DatabaseManager;
import vetclinic.model.Diagnosis;

import java.sql.Connection;

public class DiagnosisDAO implements GenericDAO<Diagnosis> {
    private Connection connection;

    public DiagnosisDAO() {
        this.connection = DatabaseManager.getConnection();
    }

    @Override
    public void add(Diagnosis entity) {

    }

    @Override
    public Diagnosis get(int id) {
        return null;
    }

    @Override
    public void update(Diagnosis entity) {

    }

    @Override
    public void delete(int id) {

    }
}
