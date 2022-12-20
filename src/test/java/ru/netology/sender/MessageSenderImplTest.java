package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import java.util.Map;

import static ru.netology.geo.GeoServiceImpl.MOSCOW_IP;
import static ru.netology.geo.GeoServiceImpl.NEW_YORK_IP;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

class MessageSenderImplTest {

    @Mock
    private GeoService geoService;
    @Mock
    private LocalizationService localizationService;

    private MessageSenderImpl messageSender;

    @BeforeEach
    void setUp(){
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }
    @Test
    void sendRussianText() {
        Mockito.when(geoService.byIp(Mockito.eq(MOSCOW_IP)))
                .thenReturn(new Location("MOSCOW", Country.RUSSIA, "Lenina", 25));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        String realResult = "Добро пожаловать";
        String expectedResult = messageSender.send(Map.of(IP_ADDRESS_HEADER, MOSCOW_IP));
        Assertions.assertEquals(realResult, expectedResult);

    }
    @Test
    void sendUSAText(){
        Mockito.when(geoService.byIp(Mockito.eq(NEW_YORK_IP)))
                .thenReturn(new Location("New York", Country.USA, "10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        String realresult = "Welcome";
        String expexterResult = messageSender.send(Map.of(IP_ADDRESS_HEADER, NEW_YORK_IP));
        Assertions.assertEquals(realresult, expexterResult);
    }

}