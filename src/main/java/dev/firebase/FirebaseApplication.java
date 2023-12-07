// FirebaseAutoConfigureAnnotation

package dev.firebase;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(FirebaseConfigureAdapter.class)
public @interface FirebaseApplication {

    // FirebaseAutoConfigureAnnotation

}