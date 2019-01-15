package com.damifan.test;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wanglei
 * @email wanglei59@jd.com
 * @create 2017/9/20 16:25
 * <p>
 * TODO
 */
public class HttpTest {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req =
                HttpRequest.newBuilder(URI.create("https://www.baidu.com"))
                        .header("User-Agent", "Java")
                        .GET()
                        .build();
        HttpResponse<String> httpResponse =
                httpClient.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());

        HttpResponse<String> httpResponse1 = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse1.body());

        CompletableFuture<HttpResponse<String>> httpResponse2 = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());

        System.out.println();

    }
}
