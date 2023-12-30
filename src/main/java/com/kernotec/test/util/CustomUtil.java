package com.kernotec.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CustomUtil {

    private static final String PERSISTENCE_ERROR_MSG = "persistence_messages_errors.properties";
    private static Map<String, Properties> props = new HashMap<>();

    public static String getErrorPersistenceMsgsProperty(String key, String... args) {
        Properties prop = props.get(PERSISTENCE_ERROR_MSG);
        if (prop == null) {
            try (InputStream stream = CustomUtil.class.getClassLoader().getResourceAsStream(PERSISTENCE_ERROR_MSG)) {
                if (stream == null) {
                    return null;
                }
                prop = new Properties();
                prop.load(new InputStreamReader(stream, StandardCharsets.UTF_8));
                prop.put(PERSISTENCE_ERROR_MSG, prop);
            } catch (IOException ex) {
                return null;
            }
        }
        String value = prop.getProperty(key);
        return (value != null) ? MessageFormat.format(value, (Object[]) args) : value;
    }
}
