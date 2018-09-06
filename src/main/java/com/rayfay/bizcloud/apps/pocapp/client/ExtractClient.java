package com.rayfay.bizcloud.apps.pocapp.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "POC-SERVICE")
public interface ExtractClient {
    @RequestMapping(method = {RequestMethod.GET}, value = "/user/findUserById")
    JSONObject findUserById(@RequestParam(name = "userId") Long userId);

    @RequestMapping(method = {RequestMethod.POST}, value = "/user/createUser")
    JSONObject createUser(@RequestBody JSONObject user);

    @RequestMapping(method = {RequestMethod.GET}, value = "/user/deleteUser")
    JSONObject deleteUser(@RequestParam(name = "userId") Long userId);

    @RequestMapping(method = {RequestMethod.POST}, value = "/user/updateUser")
    JSONObject updateUser(@RequestBody JSONObject user);

    @RequestMapping(method = {RequestMethod.POST}, value = "/user/findUserPageByQuery")
    JSONObject findUserPageByQuery(@RequestParam(name = "pageSize", required = false) int pageSize,
                                   @RequestParam(name = "pageNumber", required = false) int pageNumber,
                                   @RequestBody JSONObject queryObject);

}
