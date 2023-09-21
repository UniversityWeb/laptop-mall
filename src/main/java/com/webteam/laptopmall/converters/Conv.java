package com.webteam.laptopmall.converters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Conv<T> {
    public abstract T toModel(ResultSet resultSet) throws SQLException;

    public List<T> toList(ResultSet resultSet) throws SQLException {
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            T item = toModel(resultSet);
            list.add(item);
        }
        return list;
    }
}
