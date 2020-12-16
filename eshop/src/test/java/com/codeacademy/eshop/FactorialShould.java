package com.codeacademy.eshop;

import org.junit.jupiter.api.Test;

import static com.codeacademy.eshop.Factorial.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TDD (Test Driven Development) != Tests
 *  Rasau testa, kuris failina.
 *  Rasau implementacija, kuri padaro testa veikianciu paciu paprasciausiu budu.
 *  Refactorinu, kad gauciau grazu testa ir / arba implementacija.
 *
 *  1! = 1
 *  2! = 2 * 1
 *  3! = 3 * 2 * 1 = 6
 *  5! = 5 * 4 * 3 * 2 * 1
 *  0! = 1
 *  -1! = neegzituojami aibe
 *  ... = neegzituojami aibe
 */
public class FactorialShould {

    @Test
    void return_one_when_one_passed() {
        // given
        int input = 1;

        // when
        int result = factorial(input);

        // then
        assertEquals(1, result);
    }

    @Test
    void return_two_when_two_passed() {
        // when
        int result = factorial(2);

        // then
        assertEquals(2, result);
    }

    @Test
    void return_six_when_three_passed() {
        // when
        int result = factorial(3);

        // then
        assertEquals(6, result);
    }

    @Test
    void return_120_when_5_passed() {
        // when
        int result = factorial(5);

        // then
        assertEquals(120, result);
    }

    @Test
    void return_big_number_when_10_passed() {
        // when
        int result = factorial(10);

        // then
        assertEquals(10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2, result);
    }

    @Test
    void return_1_when_0_passed() {
        // when
        int result = factorial(0);

        // then
        assertEquals(1, result);
    }

    @Test
    void throws_exception_when_negative_passed() {
        assertThrows(IllegalArgumentException.class, () -> factorial(-5));
    }
}
