package com.jk.soulmatesbackendandroidapp.controllers;

import com.github.javafaker.Faker;
import com.jk.soulmatesbackendandroidapp.models.Users;
import com.jk.soulmatesbackendandroidapp.repositories.UsersRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;


/**
 * Api for user creation.
 * This api will not be protected since it's cause is only the user creation.
 *
 * @author Jk
 * @since 19-12-2023
 */
@RestController
@RequestMapping("/api/usersCreation")
public class UsersCreationController {

    private final UsersRepository usersRepository;
    private final Faker faker;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    Logger logger = LoggerFactory.getLogger(UsersCreationController.class);

    public UsersCreationController(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.faker = new Faker();
    }


    /**
     * This endpoint creates users.
     * We call the uri "<a href="https://picsum.photos/400/400?random">...</a>" to get the images for the users.
     * It returns random images with the sizes of 400/400 as we declared.
     * Notice the initialization of the httpClient with the method setRedirectStrategy(new LaxRedirectStrategy()).build().
     * This happens since we need to redirect to get the actual image. --> try the url in a browser and you will understand.
     *
     * @author Jk
     * @since 19-12-2023
     */
    @PostMapping("/create")
    private void createUsers() throws IOException {

        for (int i = 0; i < 1000; i++) {
            HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
            HttpGet request = new HttpGet("https://picsum.photos/400/400?random");
            HttpResponse response = httpClient.execute(request);
            byte[] imageBytes = EntityUtils.toByteArray(response.getEntity());
            usersRepository.save(new Users(faker.name().firstName(), faker.name().lastName(), faker.country().name(), imageBytes, null,
                    faker.name().username(), bCryptPasswordEncoder.encode(faker.internet().password()), true, false,
                    new Timestamp(System.currentTimeMillis())));
            logger.info("Saving user: " + faker.name().firstName() + " " + faker.name().lastName() + " " + faker.country().name() + faker.name().username() + " " + faker.internet().password());
        }
    }
}
