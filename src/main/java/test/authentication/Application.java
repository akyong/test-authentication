package test.authentication;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
//        Micronaut.run(Application.class);

        Micronaut.build(args)
                .packages("test.authentication.domain")
                .mainClass(Application.class)
                .start();
    }


}