package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "0, 9",         // тест верхней границы
            "6, 5"
    })
    public void shouldIncreaseStation(int expected, int set) {
        Radio radio = new Radio();

        radio.setCurrentStation(set);
        radio.increaseStation();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "4, 5",
            "9, 0"          // тест нижней границы
    })
    public void shouldReduceStation(int expected, int set) {
        Radio radio = new Radio();

        radio.setCurrentStation(set);
        radio.reduceStation();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 10",        // тест верхней границы
            "0, -1"        // тест нижней границы
    })
    public void setStationBorderTests(int expected, int set) {
        Radio radio = new Radio();

        radio.setCurrentStation(set);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "51, 50",
            "100, 100"
    })
    public void shouldIncreaseVolume(int expected, int set) {
        Radio radio = new Radio();

        radio.setCurrentVolume(set);
        radio.increaseVolume();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "49, 50",
            "0, 0"
    })
    public void shouldReduceVolume(int expected, int set) {
        Radio radio = new Radio();

        radio.setCurrentVolume(set);
        radio.reduceVolume();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 101"
    })
    public void shouldNotSetVolume(int expected, int set) {
        Radio radio = new Radio();

        radio.setCurrentVolume(set);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
