package com.ss.restaurant.restaurantApp;

import com.ss.restaurant.restaurantApp.controller.CustomerController;
import com.ss.restaurant.restaurantApp.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestaurantAppApplicationTests {


	private CustomerController customerController;

	public RestaurantAppApplicationTests(CustomerController customerController)
	{
		this.customerController = customerController;
	}
	@Test
	void saveDataBaseTest() {

		Customer customerTest = new Customer("SelimTest",
				"SoysalTest",
				"0123456",
				"Sint-Bernardsesteenweg",
				"selimsoysal55@gmail.com",
				"1234566",
				101L);
		customerController.createCustomer(customerTest);
		assertThat(customerTest.getFirst_name()).isNotEmpty();
	}


}
