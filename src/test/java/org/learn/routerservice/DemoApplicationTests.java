package org.learn.routerservice;

import org.learn.routerservice.contract.Router;
import org.learn.routerservice.exception.PathDoesNotExistException;
import org.learn.routerservice.exception.RouteNotAvailableException;
import org.learn.routerservice.implementation.RouterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	private Router router;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void init(){
		router = new RouterImpl();
	}

	@Test
	public void testIfPathIsRegisteredSuccessfully() throws RouteNotAvailableException {
//		Router router = new RouterImpl();
		String response = router.registerRoute("/bar", "result");
		Assertions.assertEquals(response, "route /bar is registered");
	}

	@Test
	public void testIfPathIsAlreadyRegistered() throws RouteNotAvailableException {
//		Router router = new RouterImpl();
		String response = router.registerRoute("/bar", "result");
		Assertions.assertEquals(response, "route /bar is registered");
		Assertions.assertThrows(RouteNotAvailableException.class, () -> {router.registerRoute("/bar", "result1");});
	}

	@Test
	public void testIfPathIsNotRegistered() throws PathDoesNotExistException {
//		Router router = new RouterImpl();
		Assertions.assertThrows(PathDoesNotExistException.class, () -> {
			String response= router.lookupRoute("/bar");
		});
	}

}
