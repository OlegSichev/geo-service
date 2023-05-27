package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MessageSenderImplTests {

    @Test
    public void messageSenderImplRussian() {

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String expected = "Добро пожаловать";
        messageSender.send(headers);

        Assertions.assertEquals(expected, messageSender.send(headers));
    }

    @Test
    public void messageSenderInmplUSA() {

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String expected = "Welcome";
        messageSender.send(headers);

        Assertions.assertEquals(expected, messageSender.send(headers));
    }

//    @ParameterizedTest
//    @MethodSource("addTestParameters")
//    public void testAddWithParameters(Map<String, String> headers, String expected){
//        GeoService geoService = new GeoServiceImpl();
//        LocalizationService localizationService = new LocalizationServiceImpl();
//        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
//        String string = messageSender.send(headers);
//        Assertions.assertEquals(expected, string);
//    }
//
//    public static Stream<Map<String, String>> addTestParameters(){
//        return Stream.of(
//                Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19"),
//                Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149")
//        );
//    }
}
