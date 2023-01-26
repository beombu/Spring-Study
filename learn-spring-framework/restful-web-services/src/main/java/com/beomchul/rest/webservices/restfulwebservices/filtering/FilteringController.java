package com.beomchul.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
필터링을 통한 값은 mappingJackonValue로 반환해야한다.(형변환 작업 필요)
사용자 정의 필터링 기법이나 SimpleBeanPropertyFilter 같은 필터링 기법을 사용
FilterProvider(필터 이름, 필터링 기법)에 필터이름과 기법을 저장한다.
마지막으로 mappingJackonValue에 필터 프로바이더를 세팅한다.
 */

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
    }
}
