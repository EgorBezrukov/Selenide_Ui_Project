package ru.egor.qa.uitest.config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс для чтения файлов .properties
 */
public class ConfigReader {
    /**
     * считываем test.properties
     */
    public static final TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());
}
