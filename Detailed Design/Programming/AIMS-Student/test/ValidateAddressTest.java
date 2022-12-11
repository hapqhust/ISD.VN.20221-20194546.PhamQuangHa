
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

class ValidateAddressTest {

	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	@ParameterizedTest
	@CsvSource({
		"hanoi,true",
		"so 15 Hai Ba Trung Hanoi,true",
		"$# Hanoi,false",
		"hai ba trung Ha Noi,true",
		",false",
		"    ,false"
	})
	
	void test(String address, boolean expected) {
		boolean isValid = placeOrderController.validateAddress(address);
		assertEquals(expected, isValid);
	}
}