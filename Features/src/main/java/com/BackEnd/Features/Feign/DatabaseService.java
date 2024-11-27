package com.BackEnd.Features.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("PEOPLESMEDDB")
public interface DatabaseService {


}

