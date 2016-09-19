package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class FindStartIndexOfSubListTest {

    @Test
    public void testShouldReturnMinus1IfSubListIsNotFound() {
        //given
        List<Integer> subList = new ArrayList<>();
        subList.add(3);
        subList.add(2);
        List<Integer> fullList = new ArrayList<>();
        fullList.add(1);
        fullList.add(2);
        fullList.add(3);
        FindStartIndexOfSubList findStartIndexOfSubList = new FindStartIndexOfSubList();

        //when
        int index = findStartIndexOfSubList.findIndex(fullList, subList);

        //then
        assertThat(index, is(equalTo(-1)));
    }

    @Test
    public void testShouldReturnExpectedStartIndexIfSubListIsFound() {
        //given
        List<Integer> subList = new ArrayList<>();
        subList.add(2);
        subList.add(3);
        List<Integer> fullList = new ArrayList<>();
        fullList.add(1);
        fullList.add(2);
        fullList.add(3);
        FindStartIndexOfSubList findStartIndexOfSubList = new FindStartIndexOfSubList();

        //when
        int index = findStartIndexOfSubList.findIndex(fullList, subList);

        //then
        assertThat(index, is(equalTo(1)));
    }

    @Test
    public void testShouldReturnExpectedStartIndexIfSubListIsFoundForLargeList() {
        //given
        List<Integer> subList = new ArrayList<>();
        subList.add(5);
        subList.add(6);
        subList.add(7);
        List<Integer> fullList = new ArrayList<>();
        fullList.add(1);
        fullList.add(2);
        fullList.add(3);
        fullList.add(4);
        fullList.add(5);
        fullList.add(6);
        fullList.add(7);
        fullList.add(8);
        FindStartIndexOfSubList findStartIndexOfSubList = new FindStartIndexOfSubList();

        //when
        int index = findStartIndexOfSubList.findIndex(fullList, subList);

        //then
        assertThat(index, is(equalTo(4)));
    }

}