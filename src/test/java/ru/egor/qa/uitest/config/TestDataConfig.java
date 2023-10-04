package ru.egor.qa.uitest.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

/**
 * Чтение ключей из testData.properties
 */
@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties", //читаем env
        "file:src/test/resources/testData.properties", //читаем из файла
})
public interface TestDataConfig extends Config {
    @Key("SwagLabProductPageUrl")
    String SwagLabProductPageUrl();

    @Key("SwagLabBaseUrl")
    String SwagLabBaseUrl();

    @Key("SwagLabLogin")
    String SwagLabLogin();

    @Key("SwagLabPassword")
    String SwagLabPassword();

}
