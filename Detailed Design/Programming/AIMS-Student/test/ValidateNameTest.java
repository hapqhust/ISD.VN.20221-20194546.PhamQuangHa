
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

class ValidateNameTest {

	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	@ParameterizedTest
	@CsvSource({
		"phamquangha,true",
		"ha1234,false",
		"#?Ha,false",
		"Pham Quang Ha,true",
		"PhamQuangHa,true",
		",false",
		"   ,false"
	})

	void test(String name, boolean expected) {
		//when
		boolean isValid = placeOrderController.validateName(name);
		//then
		assertEquals(expected, isValid);
	}
}