package com.webteam.laptopmall.converters;

import com.webteam.laptopmall.converters.impl.ToAdmin;
import com.webteam.laptopmall.converters.impl.ToBigDecimal;
import com.webteam.laptopmall.converters.impl.ToCustomer;
import com.webteam.laptopmall.converters.impl.ToLong;
import com.webteam.laptopmall.exceptions.ConvertTypeNotSupportException;
import com.webteam.laptopmall.models.Admin;
import com.webteam.laptopmall.models.Customer;

import java.math.BigDecimal;
import java.util.Map;

public class ConvFactory {
    private final Map<String, Conv> converters = Map.of(
            Customer.class.getName(), new ToCustomer(),
            Admin.class.getName(), new ToAdmin(),
            BigDecimal.class.getName(), new ToBigDecimal(),
            Long.class.getName(), new ToLong()
    );

    public <T> Conv<T> create(Class<T> type) {
        var convIns = converters.get(type.getName());
        if (convIns == null)
            throw new ConvertTypeNotSupportException("Unsupported class type: " + type.getName());
        return convIns;
    }
}
