package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JavaSetTest {

    @Test
    public void testShouldBeAbleToInsertAnElementToSet(){
        //given
        String element = "element1";
        JavaSet javaSet = new JavaSet();

        //when
        boolean isInserted = javaSet.addToSet(element);

        //then
        assertThat(isInserted, is(equalTo(true)));
    }

    @Test
    public void testShouldNotAllowDuplicateElementsToBeInserted(){
        //given
        String element = "element1";
        JavaSet javaSet = new JavaSet();
        javaSet.addToSet(element);

        //when
        boolean isInserted = javaSet.addToSet(element);

        //then
        assertThat(isInserted, is(equalTo(false)));
    }

    @Test
    public void testShouldBeAbleToRemoveElementsSuccessfullyFromSet(){
        //given
        String element = "element1";
        JavaSet javaSet = new JavaSet();
        javaSet.addToSet(element);

        //when
        boolean isRemovedSuccessfully = javaSet.removeFromSet(element);

        //then
        assertThat(isRemovedSuccessfully, is(equalTo(true)));
    }

    @Test
    public void testShouldNOTBeAbleToRemoveElementFromSetIfTheElementIsNotPresent(){
        //given
        String element = "element1";
        JavaSet javaSet = new JavaSet();

        //when
        boolean isRemovedSuccessfully = javaSet.removeFromSet(element);

        //then
        assertThat(isRemovedSuccessfully, is(equalTo(false)));
    }

    @Test
    public void testShouldBeAbleToReturnSizeOfSet(){
        //given
        String element = "element1";
        JavaSet javaSet = new JavaSet();
        javaSet.addToSet(element);

        //when
        int size = javaSet.sizeOfSet();

        //then
        assertThat(size, is(equalTo(1)));
    }


}