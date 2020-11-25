package com.codeacademy.eshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class StreamsTest {

    @Test
    public void optional() {
        Optional<String> optionalOfString = Optional.ofNullable("aaaa");

        kazkoksMetodas(optionalOfString);
    }

    private void kazkoksMetodas(Optional<String> optionalOfString) {

//        optionalOfString
//                .ifPresentOrElse(daiktasViduj -> System.out.println(daiktasViduj),
//                        () -> System.out.println("Duok man ne null!"));

        String tekstas = optionalOfString.orElse("Duok man ne null!");
        System.out.println(tekstas);

//        if (optionalOfString.isPresent()) {
//            System.out.println(optionalOfString.get());
//        } else {
//            System.out.println("Duok man ne null!");
//        }

//        String aaa = Stream.of("aaa").findAny().orElse()
    }

    @Test
    public void testStreams() {
        List<MobilePhone> phones = List.of(
                new MobilePhone("Iphone", "12 Pro", 1000.50),
                new MobilePhone("Samsung", "S10", 300.99),
                new MobilePhone("Samsung", "Note 10", 899.90),
                new MobilePhone("Samsung", "S20+", 1200.99),
                new MobilePhone("Samsung", "S20", 999.99));

//        BigDecimal sum = BigDecimal.ZERO;
//
//        for (MobilePhone phone : phones) {
////            BigDecimal price = phone.getPrice();
////            sum = addPrice(sum, price);
//        }
//
//        System.out.println("For loop: " + sum);
//
//        System.out.println("Streams: " + phones.stream() // source - phone
////                .map(mobilePhone -> mobilePhone.getPrice())
//                .mapToDouble(MobilePhone::getPrice) // intermediate operation 0-...
//                .sum());
////                .reduce(BigDecimal.ZERO, (initialValue, price) -> initialValue.add(price))); // terminal operation
//
//        List<String> aaa = new ArrayList<>();

        findSamsungWithFor(phones);
        findSamsungWithStreams(phones);
    }

    // Surasti brangiausia samsung telefona ir atvaizduoti jo modeli
    private void findSamsungWithFor(List<MobilePhone> phones) {

        String brangiausiasSamsungModelis = null;
        double brangiausioSamsungModelioKaina = 0;
        for (MobilePhone phone : phones) {
            if (phone.getBrand().equals("Samsung") && brangiausioSamsungModelioKaina < phone.getPrice()) {
                brangiausioSamsungModelioKaina = phone.getPrice();
                brangiausiasSamsungModelis = phone.getModel();
            }
        }

        System.out.println(brangiausiasSamsungModelis);

    }

    private void findSamsungWithStreams(List<MobilePhone> phones) {

        List<MobilePhone> samsungai = phones.stream()
                .filter(MobilePhone::isSamsung)
                .collect(Collectors.toList());
//                .sorted(comparing(MobilePhone::getPrice).reversed())
//                .findFirst()
//                .get()
//                .getModel();

        System.out.println(samsungai);

    }

    private static boolean suraskSamsunga(MobilePhone phone) {
        return phone.getBrand().equals("Samsung");
    }

    private <T> BigDecimal extractFromObjectAndLog(T objektas, Funkcija<T> funkcija) {

        BigDecimal price = funkcija.iskviesk(objektas);

        System.out.println(price);

//        dar daug logikos....
//
//
        return price;
    }

    private BigDecimal addPrice(BigDecimal sum, BigDecimal price) {
        return sum.add(price);
    }
    private static interface Funkcija<T> {

        BigDecimal iskviesk(T objektas);

    }

//    static class FunkcijaSuMobilePhone implements Funkcija<MobilePhone> {
//
//        @Override
//        public BigDecimal iskviesk(MobilePhone objektas) {
//            return objektas.getPrice();
//        }
//    }

    public static double kazkoksMetodas(MobilePhone mobilePhone) {
        return mobilePhone.getPrice();
    }

    @Getter
    @AllArgsConstructor
    @ToString
    private static class MobilePhone {
        private String brand;
        private String model;
        private double price;

        public boolean isSamsung() {
            return brand.equals("Samsung");
        }
    }
}
