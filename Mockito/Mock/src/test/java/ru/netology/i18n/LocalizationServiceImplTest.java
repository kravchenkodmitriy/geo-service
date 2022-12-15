package ru.netology.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    private LocalizationServiceImpl localizationService;

    @BeforeEach
    void  setUp(){
        localizationService = new LocalizationServiceImpl();
        System.out.println("Вызов до выполнения тестов");
    }

    @AfterEach
    void setup(){
        System.out.println("Вызов после выполнения тестов");
    }
    @Test
    void localeRussia() {
        String locate = "Добро пожаловать";
        String expectedResult = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(locate, expectedResult);
    }

    @Test
    void localeUSA(){
        String locate = "Welcome";
        String expectedResult = localizationService.locale(Country.USA);
        Assertions.assertEquals(locate, expectedResult);
    }




}