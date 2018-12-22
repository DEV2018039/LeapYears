package com.bnppfortis.channels.controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This is the Class where will be defining the test for LeapYearController.
 *
 * <p>
 * Created by Dev2018039 on 12/23/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LeapYearControllerTest extends TestCase {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    /**
     *
     * This method is used to test ValidateLeapYear Returns 400 when null year is not passed.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsBadRequestForNullYearsPassed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/null" ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns 400
     * when Some random String is passed as year.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsBadRequestForStringYearsPassed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/string" ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns 404
     * when Some random year passed.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotFoundForWrongURIAccessed() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-years/1582" ))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Valid Year for year 0.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotAValidYear() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/0" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Year should be between 1582 to 8000"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Valid Year for year -22.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotAValidYearForValueLessThanZero() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/-22" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Year should be between 1582 to 8000"));
    }

    /**
     *
     * This method is used to test ValidateLeapYear Returns Not a Valid Year for year greater than 8000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsNotAValidYearForValueGreaterThan8000() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/1231432432" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Year should be between 1582 to 8000"));
    }


    // Test case for First Use case

    /**
     * This method is used to test ValidateLeapYear Returns Leap Year for year 2000.
     *
     * @throws Exception
     */
    @Test
    public void testValidateLeapYearReturnsLeapYearFor2000() throws Exception {
        mockMvc.perform(get("/channels/validate/leap-year/2000" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2000 is a Leap Year"));

    }

}