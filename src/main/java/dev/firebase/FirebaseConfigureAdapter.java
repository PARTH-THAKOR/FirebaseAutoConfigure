// FirebaseConfigureAdapter

package dev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;

public class FirebaseConfigureAdapter {

    private final ResourceLoader resourceLoader;

    public FirebaseConfigureAdapter(@Qualifier("webApplicationContext") ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public Boolean FIREBASE() {
        try {
            Resource resource = resourceLoader.getResource("classpath:firebase.json");
            InputStream serviceAccount = resource.getInputStream();
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
            FirebaseApp.initializeApp(options);
            System.out.println("FIREBASE STATUS OK");
            return true;
        } catch (Exception e) {
            System.out.println("FIREBASE ERROR : " + e.getMessage());
            return false;
        }
    }

}
