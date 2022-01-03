package com.landeros.databaseinteraction;

import com.landeros.customexceptions.PitchNotFound;
import com.landeros.entities.Pitch;
import com.landeros.utility.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PitchDAOImplemented implements PitchDAO {

    @Override
    public List<Pitch> viewPitches() {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from pitches";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Pitch> pitches = new ArrayList<>();
            while(resultSet.next()) {
                Pitch pitch = new Pitch(
                        resultSet.getInt("pitchId"),
                        resultSet.getInt("businessId"),
                        resultSet.getString("creationDate"),
                        resultSet.getString("pitch"),
                        resultSet.getFloat("amount"),
                        resultSet.getFloat("percentage"),
                        resultSet.getString("status")
                );
                pitches.add(pitch);
            }

            return pitches;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean makeOffer(int pitchId, double amount, double percentage) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update pitches set amount = ?, percentage = ? where pitchId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setDouble(2, percentage);
            preparedStatement.setInt(3, pitchId);
            preparedStatement.execute();
            return true;
            }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean acceptOffer(int pitchId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update pitches set status = 'Accepted' where pitchId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pitchId);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
