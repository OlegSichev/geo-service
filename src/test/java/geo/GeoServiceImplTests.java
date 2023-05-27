package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceImplTests {
    @ParameterizedTest
    @MethodSource("addTestParameters")
    public void testAddWithParameters(String ip, Location expected) {
        GeoService geoService = new GeoServiceImpl();
        Assertions.assertEquals(expected, geoService.byIp(ip));
    }

    public static Stream<Arguments> addTestParameters() {
        return Stream.of(
                Arguments.of("172.0.32.11", Country.RUSSIA),
                Arguments.of("96.44.183.149", Country.USA)
        );
    }
}
