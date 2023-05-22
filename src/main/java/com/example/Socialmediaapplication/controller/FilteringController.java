package com.example.Socialmediaapplication.controller;

import com.example.Socialmediaapplication.model.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping("/filtering-v1")
    public MappingJacksonValue filteringIgnore(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        PropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    @GetMapping("/filtering-list")
    public List<SomeBean>filteringList(){
        return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"));
    }
    @GetMapping("/filtering-list-v1")
    public MappingJacksonValue filteringListV1(){
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(list);
        PropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}

