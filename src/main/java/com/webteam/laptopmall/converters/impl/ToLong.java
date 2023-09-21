package com.webteam.laptopmall.converters.impl;

import com.webteam.laptopmall.converters.Conv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ToLong extends Conv<Long> {
    @Override
    public Long toModel(ResultSet resultSet) throws SQLException {
        return resultSet.getLong(1);
    }

    @Override
    public List<Long> toList(ResultSet resultSet) {
        throw new UnsupportedOperationException("toList() method is not implemented in ToInteger class");
    }
}
