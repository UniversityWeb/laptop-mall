package com.webteam.laptopmall.daos;

import com.webteam.laptopmall.db.ConnectionPool;
import com.webteam.laptopmall.db.DbConv;
import com.webteam.laptopmall.models.UpdateResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseDAO {
    protected ConnectionPool pool;
    protected DbConv dbConv;

    public BaseDAO() {
        pool = ConnectionPool.getIns();
        dbConv = new DbConv();
    }


    /**
     * Executes an add query and returns the number of affected rows and the generated key.
     *
     * @param query The SQL query to execute.
     * @return An instance of UpdateResult containing the effect rows and generated key.
     * @throws SQLException If a database access error occurs.
     */
    protected UpdateResult executeUpdateReturnGeneratedKey(String query) throws SQLException {
        int effectRows = 0;
        long generatedId = 0;

        try (Connection conn = pool.getConn();
             PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            effectRows = ps.executeUpdate();
            if (effectRows > 0) {
                try (ResultSet generatedKey = ps.getGeneratedKeys()) {
                    if (generatedKey.next()) {
                        generatedId = dbConv.toModel(generatedKey, Long.class);
                    }
                }
            }
        }

        return new UpdateResult(effectRows, generatedId);
    }

    /**
     * Executes an update query and returns the number of affected rows.
     *
     * @param query The SQL query to execute.
     * @return The number of affected rows.
     * @throws SQLException If a database access error occurs.
     */
    protected int executeUpdate(String query) throws SQLException {
        int effectRows = 0;
        try (Connection conn = pool.getConn();
             PreparedStatement ps = conn.prepareStatement(query)) {
            effectRows = ps.executeUpdate();
        }
        return effectRows;
    }

    /**
     * Retrieves a single object of the specified type based on the provided SQL query.
     *
     * @param query The SQL query to execute.
     * @param type  The class type of the retrieved object, which have to be implemented in the `ConvFactory` class.
     * @return An Optional containing the retrieved object if available, or empty if not found.
     * @throws SQLException If a database access error occurs.
     */
    protected <T> Optional<T> getSingleObject(String query, Class<T> type) throws SQLException {
        try (Connection conn = pool.getConn();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                T obj = dbConv.toModel(rs, type);
                return Optional.of(obj);
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Retrieves a list of objects of the specified type based on the provided SQL query.
     *
     * @param query The SQL query to execute.
     * @param type  The class type of the retrieved object, which have to be implemented in the `ConvFactory` class.
     * @return A list containing the retrieved objects.
     * @throws SQLException If a database access error occurs.
     */
    protected <T> List<T> getList(String query, Class<T> type) throws SQLException {
        List<T> list = new ArrayList<>();

        try (Connection conn = pool.getConn();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            list = dbConv.toList(rs, type);
        }

        return list;
    }

    /**
     * Retrieves a single numeric value of the specified type based on the provided SQL query,
     * or a default value if the value is not available.
     *
     * @param query       The SQL query to execute.
     * @param type  The class type of the retrieved object, which have to be implemented in the `ConvFactory` class.
     * @param defaultValue The default value to return if the numeric value is not available.
     * @return The retrieved numeric value if available, or the default value if not found.
     * @throws SQLException If a database access error occurs.
     */
    protected  <T extends Number> T getNumber(String query, Class<T> type, T defaultValue) throws SQLException {
        T num = getSingleObject(query, type).orElse(defaultValue);
        return num;
    }
}

