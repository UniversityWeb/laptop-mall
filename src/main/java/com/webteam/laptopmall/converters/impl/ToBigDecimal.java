package com.webteam.laptopmall.converters.impl;

import com.webteam.laptopmall.converters.Conv;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ToBigDecimal extends Conv<BigDecimal> {

    @Override
    public BigDecimal toModel(ResultSet resultSet) throws SQLException {
        return resultSet.getBigDecimal(1);
    }

    @Override
    public List<BigDecimal> toList(ResultSet resultSet) {
        throw new UnsupportedOperationException("toList() method is not implemented in ToInteger class");
    }
}
