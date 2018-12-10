package com.fererlab.spring.palindrome.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class PalindromeServiceImpl implements PalindromeService {

    @Autowired
    Tracer tracer;

    @Override
    public String revert(String string) {
        Span span = tracer.getCurrentSpan();
        String tag = span.tags()
                .entrySet()
                .stream()
                .filter(e -> "PalindromeApplication.tag".equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("NO_TAG_FOUND");

        String baggageItem = span.getBaggageItem("this-is-an-integer-key");

        log.info("Inside Zipkin Service 2, service, tag: " + tag + " baggageItem: " + baggageItem);

        return new StringBuilder(string).reverse().toString();
    }
}
