package org.acherie.demo.dao;

import org.acherie.demo.config.RootConfig;
import org.acherie.demo.model.Country;
import org.acherie.demo.model.CountryExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by wangjie on 9/18/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class ConuntryMapperTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    CountryMapper countryMapper;

    @Test
    public void selectByExample() {
        List<Country> countries = countryMapper.selectByExample(new CountryExample());
        System.out.println(countries);
    }
}
