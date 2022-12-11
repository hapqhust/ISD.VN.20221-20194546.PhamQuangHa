
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import controller.PlaceRushOrderController;
import entity.media.Media;
import entity.order.OrderMedia;

class ChangeFormulaShippingFeesTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}
	@Test
	public void test() throws SQLException {
		//when
		OrderMedia orderMedia = null;
		int isValid = placeRushOrderController.changeFormulaShippingFees(orderMedia);
		//then
		assertEquals(0, isValid);
	}
	@Test
	public void test1() throws SQLException {
		//when
		Media media1 = new Media(1,"POP2","Music",5,9,"CD");
		OrderMedia orderMedia1 = new OrderMedia(media1, 2, 10);
		int isValid = placeRushOrderController.changeFormulaShippingFees(orderMedia1);
		//then
		assertEquals(20, isValid);
	}
	@Test
	public void test2() throws SQLException {
		//when
		Media media2 = new Media(2,"Crash","Music",2,9,"CD");
		OrderMedia orderMedia2 = new OrderMedia(media2, 3, 6);
		int isValid = placeRushOrderController.changeFormulaShippingFees(orderMedia2);
		//then
		assertEquals(30, isValid);
	}
	@Test
	public void test3() throws SQLException {
		//when
		Media media3 = new Media(3,"Charli","Music",7,9,"CD");
		OrderMedia orderMedia3 = new OrderMedia(media3, 0, 0);
		int isValid = placeRushOrderController.changeFormulaShippingFees(orderMedia3);
		//then
		assertEquals(0, isValid);
	}
}