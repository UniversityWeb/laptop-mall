package com.webteam.laptopmall.db;

import com.webteam.laptopmall.converters.ConvFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbConv {
    private ConvFactory factory;

    public DbConv() {
        factory = new ConvFactory();
    }

    public <T> T toModel(ResultSet rs, Class<T> type) throws SQLException {
        var converter = factory.create(type);
        return converter.toModel(rs);
    }

    public <T> List<T> toList(ResultSet rs, Class<T> type) throws SQLException {
        var converter = factory.create(type);
        return converter.toList(rs);
    }
}
