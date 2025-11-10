package br.edu.insper.pf;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Ignorando teste de contexto durante build CI")
class PfApplicationTests {

	@Test
	void contextLoads() {
	}
}
