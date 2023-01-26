package com.beomchul.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
정적 필터링
@JsonIgnoreProperties(필드 이름) : 클래스에서 선언하면서 정적으로 명시한 필드를 통신에서 제외
@JsonIgnore : 필드위에 선언하며 정적으로 선언된 필드를 통신에서 제외

동적 필터링
@JsonFilter(필터 이름) : 컨트롤러 에서 filterprovider에 넣은 필터 이름을 명시해주어 통신에서 제외
 */
@AllArgsConstructor
@Getter
@Setter
@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties({"field1", "field2"})
public class SomeBean {
    private String field1;

    //@JsonIgnore //통신에서 제외
    private String field2;

    private String field3;
}
