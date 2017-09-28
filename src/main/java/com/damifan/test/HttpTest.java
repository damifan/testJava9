package com.damifan.test;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpHeaders;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/9/20 16:25
 * <p>
 * TODO
 */
public class HttpTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req =
                HttpRequest.newBuilder(URI.create("https://www.baidu.com"))
                        .header("User-Agent", "Java")
                        .GET()
                        .build();
        HttpResponse<Integer> httpResponse =
                httpClient.send(req, (statusCode, responseHeaders) -> HttpResponse.BodyProcessor.discard(statusCode));

        System.out.println(httpResponse.body());

        HttpResponse<String> httpResponse1 = httpClient.send(req, HttpResponse.BodyHandler.asString());
        System.out.println(httpResponse1.body());


    }
}
