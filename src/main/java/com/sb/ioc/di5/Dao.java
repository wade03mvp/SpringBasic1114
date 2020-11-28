package com.sb.ioc.di5;

import java.util.List;
import java.util.Map;

public interface Dao {
    List<Map<String, String>> query();
}
