package br.com.roger.integrationtests.swagger;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.roger.configs.TestesConfigs;
import br.com.roger.integrationtests.testscontainers.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTests extends AbstractIntegrationTest {

	@Test
	public void shouldDisplaySwaggerUiPage() {
		var content  = 
		given()
		.basePath("/swagger-ui/index.html")
		.port(TestesConfigs.SERVER_PORT)
		.when()
			.get()
		.then()
			.statusCode(200)
		.extract()
			.body()
			.asString();
		
		assertTrue(content.contains("Swagger UI"));
		
	}

}
