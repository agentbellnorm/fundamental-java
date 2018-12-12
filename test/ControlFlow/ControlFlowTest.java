package ControlFlow;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ControlFlowTest {

    private ControlFlow controlFlow = new ControlFlow();

    @Test
    public void fewLanguagesUsingIf() {
        String swedenLanguage = controlFlow.getSpokenLanguageUsingIf("Sweden");
        String norwayLanguage = controlFlow.getSpokenLanguageUsingIf("Norway");
        String unknownCountryLanguage = controlFlow.getSpokenLanguageUsingIf(randomString());

        assertEquals("Swedish", swedenLanguage);
        assertEquals("Norwegian", norwayLanguage);
        assertEquals("Most likely English", unknownCountryLanguage);
    }

    @Test
    public void manyLanguagesUsingSwitch() {
        String swedenLanguage = controlFlow.getSpokenLanguageUsingIf("Sweden");
        String norwayLanguage = controlFlow.getSpokenLanguageUsingIf("Norway");
        String denmarkLanguage = controlFlow.getSpokenLanguageUsingIf("Danish");
        String finlandLanguage = controlFlow.getSpokenLanguageUsingIf("Finland");
        String germanyLanguage = controlFlow.getSpokenLanguageUsingIf("Germany");
        String franceLanguage = controlFlow.getSpokenLanguageUsingIf("France");
        String spainLanguage = controlFlow.getSpokenLanguageUsingIf("Spain");
        String unknownCountryLanguage = controlFlow.getSpokenLanguageUsingSwitch(randomString());

        assertEquals("Swedish", swedenLanguage);
        assertEquals("Norwegian", norwayLanguage);
        assertEquals("Danish", denmarkLanguage);
        assertEquals("Finnish", finlandLanguage);
        assertEquals("German", germanyLanguage);
        assertEquals("French", franceLanguage);
        assertEquals("Spannish", spainLanguage);
        assertEquals("Most likely English", unknownCountryLanguage);
    }

    @Test
    public void sumOfIntArray() {
        int[] numbers = new int[]{4, 5, 6, 7, 8, 9, 3};

        assertEquals(42, controlFlow.sumArrayOfIntegers(numbers));
    }

    @Test
    public void containsUsingForEach() {
        List<String> toppings = Mockito.spy(new ArrayList<>());
        toppings.add("ketchup");
        toppings.add("mustard");
        toppings.add("mayonnaise");
        toppings.add("onion");

        assertEquals(true, controlFlow.containsUsingForEach(toppings, "mustard"));
        assertEquals(false, controlFlow.containsUsingForEach(toppings, "gurkmajonäs"));

        verify(toppings, times(0)).contains(any());
        verify(toppings, atLeast(1)).iterator();
    }

    @Test
    public void getWithoutUsingGet() {
        List<String> toppings = Mockito.spy(new ArrayList<>());
        toppings.add("ketchup");
        toppings.add("mustard");
        toppings.add("mayonnaise");
        toppings.add("onion");

        assertEquals("mayonnaise", controlFlow.getWithoutUsingGet(toppings, 2));

        verify(toppings, times(0)).get(anyInt());

    }

    private String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
