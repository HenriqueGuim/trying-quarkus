package com.flutter;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

@QuarkusIntegrationTest
public class GreetingIT extends GreetingTest {

    @Test
    public void testJaxrs() {
        super.testJaxrs();
    }
}
