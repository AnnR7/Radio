
package ru.netology.Radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio(0, 9, 0, 0, 100, 0);

    @Test
    public void shouldSetStation() {

        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(9, radio.getMaxStation());
        Assertions.assertEquals(0, radio.getCurrentStation());
        Assertions.assertEquals(0, radio.getMinVolume());
        Assertions.assertEquals(100, radio.getMaxVolume());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    public void test() {
        Radio radio = new Radio(10);
        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(9, radio.getMaxStation());
    }

    @Test
    public void testDefault() {
        Radio radio = new Radio();
    }

    @Test
    public void shouldSetToBelowMinStation() {
        radio.setCurrentStation(-1);

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetToNearMinStation() {
        radio.setCurrentStation(1);

        Assertions.assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void shouldSetToNearMaxStation() {
        radio.setCurrentStation(8);

        Assertions.assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMax() {
        radio.setCurrentStation(10);

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNextStation() {
        radio.setCurrentStation(0);

        radio.nextStation();

        Assertions.assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void shouldNotNextStation() {
        radio.setCurrentStation(9);

        radio.nextStation();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStation() {
        radio.setCurrentStation(9);

        radio.prevStation();

        Assertions.assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void shouldNotPrevStation() {

        radio.setCurrentStation(0);

        radio.prevStation();

        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetToBelowMinVolume() {
        radio.setCurrentVolume(-1);

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetToNearMinVolume() {
        radio.setCurrentVolume(1);

        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetToNearMaxVolume() {
        radio.setCurrentVolume(99);

        Assertions.assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {
        radio.setCurrentVolume(101);

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolume() {
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setCurrentVolume(0);

        radio.increaseVolume();


        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setCurrentVolume(100);

        radio.decreaseVolume();

        Assertions.assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeMin() {
        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        Assertions.assertEquals(0, radio.getMinVolume());
    }
}
