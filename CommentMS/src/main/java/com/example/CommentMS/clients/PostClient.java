package com.example.CommentMS.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "POSTMS")
public interface PostClient {

}
