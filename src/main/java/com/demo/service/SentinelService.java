package com.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.entity.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SentinelService {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @SentinelResource(value = "sayHello", blockHandler="blockHandler", fallback = "fallback")
    public Response sayHello() {
        Response response = new Response();
        response.setCode(0);
        response.setMsg("Hello Lenovo");
        return response;
    }

    public Response blockHandler(BlockException e) throws JsonProcessingException {
        Response response = new Response();
        response.setCode(100);
        response.setMsg("block exception");
        log.info(objectMapper.writeValueAsString(response));
        return response;
    }

    public Response fallback() throws JsonProcessingException {
        Response response = new Response();
        response.setCode(101);
        response.setMsg("other exception");
        log.info(objectMapper.writeValueAsString(response));
        return response;
    }
}
