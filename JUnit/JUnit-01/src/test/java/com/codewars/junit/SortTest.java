package com.codewars.junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sulfur on 20.02.16.
 */
public class SortTest {

    @Test
    public void testSortStrings() {

        Comparable[] input = new String[]{"fff", "ddd", "ccc", "bbb", "eee", "aaa", "ggg"};
        Comparable[] expected = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"};

        Comparable [] actual = GoodSort.sortStringArray(input);

        assertArrayEquals(expected,actual);

    }

    @Test
    public void testSortWithEqualStrings() {

        Comparable[] input = new String[]{"fff", "ddd", "ccc", "ccc", "fff", "aaa", "ggg"};
        Comparable[] expected = new String[]{"aaa", "ccc", "ccc", "ddd", "fff", "fff", "ggg"};

        Comparable [] actual = GoodSort.sortStringArray(input);

        assertArrayEquals(expected,actual);

    }

    @Test
    public void testSortNumbers() {

        Comparable[] input = new String[]{"7", "3", "1", "6", "4", "5", "2"};
        Comparable[] expected = new String[]{"1", "2", "3", "4", "5", "6", "7"};

        Comparable [] actual = GoodSort.sortStringArray(input);

        assertArrayEquals(expected,actual);
    }

    @Test
    public void testSortNegativeNumbers() {

        Comparable[] input = new String[]{"7", "3", "1", "-1", "6", "-3", "-2", "4", "5", "2"};
        Comparable[] expected = new String[]{"-1", "-2", "-3", "1", "2", "3", "4", "5", "6", "7"};

        Comparable[] actual = GoodSort.sortStringArray(input);

        assertArrayEquals(expected,actual);

    }

}
