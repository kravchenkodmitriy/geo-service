package ru.netology.geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private Location location;
    private GeoServiceImpl geoServiceImpl;
    @BeforeEach
    void  setUp(){
        geoServiceImpl = new GeoServiceImpl();
        System.out.println("Вызов до выполнения тестов");
    }

    @AfterEach
    void setup(){
        System.out.println("Вызов после выполнения тестов");
    }


    @Test
    void byIpRussian() {
        String ipRussian = "172.0.32.11";
        location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actualLocation = geoServiceImpl.byIp(ipRussian);
        Assertions.assertEquals(location.getCountry(), actualLocation.getCountry());
        Assertions.assertEquals(ipRussian, GeoServiceImpl.MOSCOW_IP);

    }
    @Test
    void byIpUSA(){
        String ipUSA = "96.44.183.149";
        location = new Location(" New York", Country.USA, "10th Avenue", 32);
        Location actualLocation = geoServiceImpl.byIp(ipUSA);
        Assertions.assertEquals(location.getCountry(), actualLocation.getCountry());

    }


}