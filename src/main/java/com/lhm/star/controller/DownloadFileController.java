package com.lhm.star.controller;

import io.swagger.annotations.Api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author lhm
 * @date 2019/4/19 14:21
 **/

@Api(tags = "啊里云OSS文件下载", description = "api")
@RefreshScope
@RestController
@RequestMapping("aliOss")
public class DownloadFileController {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("urla") String urla)
            throws IOException {

        URL url = new URL(urla);
        String[] strs = urla.split("/");
        //获取上传时候的文件名称
        String fileName = strs[strs.length-1];
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode(fileName , "utf-8")));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(conn.getContentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(conn.getInputStream()));
    }

}
