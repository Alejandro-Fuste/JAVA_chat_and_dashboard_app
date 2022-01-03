package dev.java_investing_app.DAO;

import dev.java_investing_app.connectingtodatabase.ConnectionFile;
import dev.java_investing_app.customexceptions.BusinessNotFound;
import dev.java_investing_app.entities.Business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDAOImp implements BusinessDAO {

    @Override
    public Business createBusiness(Business business){
        try(Connection connection = ConnectionFile.createConnection()) {
            String sql = "insert into business values(default, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1, business.getBusinessNumber());
            preparedStatement.setString(1, business.getFirstName());
            preparedStatement.setString(2, business.getLastName());
            preparedStatement.setString(3, business.getBusinessName());
            preparedStatement.setString(4, business.getUsername());
            preparedStatement.setString(5, business.getPassword());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            business.setBusinessNumber(resultSet.getInt("businessId"));
            return business;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Business getBusinessById(int id){
        try(Connection connection = ConnectionFile.createConnection()) {
            String sql = "select * from business where businessId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Business business = new Business(
                        resultSet.getInt("businessId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("businessName"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
                return business;
            } else {
                throw new BusinessNotFound("Business not found");
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Business> getAllBusinesses(){
        try(Connection connection = ConnectionFile.createConnection()) {
            String sql = "select * from business";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Business> businesses = new ArrayList<>();
            while(resultSet.next()){
                Business business = new Business(
                        resultSet.getInt("businessId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("businessName"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
                businesses.add(business);
            }
            return businesses;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
//    New comment

}
