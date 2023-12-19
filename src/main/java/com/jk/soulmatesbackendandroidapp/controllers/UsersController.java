package com.jk.soulmatesbackendandroidapp.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Api for user creation.
 * This api will not be protected since it's cause is only the user creation.
 *
 * @author Jk
 * @since 19-12-2023
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    /**
     * This endpoint creates users.
     * We call the uri "<a href="https://picsum.photos/300/300?random">...</a>" to get the images for the users.
     * It returns random images with the sizes of 300/300 as we declared.
     * Notice the initialization of the httpClient with the method setRedirectStrategy(new LaxRedirectStrategy()).build().
     * This happens since we need to redirect to get the actual image. --> try the url in a browser and you will understand.
     *
     * @author Jk
     * @since 19-12-2023
     */
    @PostMapping("/createAll")
    private void insertUsers() throws IOException {

        for (int i = 0; i < 30; i++) {
            HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
            HttpGet request = new HttpGet("https://picsum.photos/300/300?random");
            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getEntity());
            byte[] imageBytes = EntityUtils.toByteArray(response.getEntity());
            System.out.println(Arrays.toString(imageBytes));
            Path imagePath = Path.of("C:\\Users\\USER\\Desktop\\" + i + ".jpg");
            Files.write(imagePath, imageBytes, StandardOpenOption.CREATE);
        }
    }
}
