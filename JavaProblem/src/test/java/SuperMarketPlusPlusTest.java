import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlusTest {
	private SuperMarketPlusPlus supermarket;
	private List<List<Item>> checkItemsByDays;
	private final int DAYS = 16;

	private List<List<Item>> populateCheckList(){
		List<List<Item>> checkItemsByDays = new ArrayList<>();
		//Day 1
		List<Item>checkItems = new ArrayList();
		checkItems.add(new Item("Thermal Vest", 9, 19));
		checkItems.add(new Item("Aged Brie", 1, 1));
		checkItems.add(new Item("Chicken", 4, 6));
		checkItems.add(new Item("Sulfuras", 0, 80));
		checkItems.add(new Item("Backstage Passes", 14, 21));
		checkItems.add(new Item("Ginger Cake", 2, 5));
		checkItems.add(new Item("Organic Bananas", 2, 8));
		checkItemsByDays.add(checkItems);
		//Day 2
		checkItems = new ArrayList();
		checkItems.add(new Item("Thermal Vest", 8, 18));
		checkItems.add(new Item("Aged Brie", 0, 2));
		checkItems.add(new Item("Chicken", 3, 5));
		checkItems.add(new Item("Sulfuras", 0, 80));
		checkItems.add(new Item("Backstage Passes", 13, 22));
		checkItems.add(new Item("Ginger Cake", 1, 4));
		checkItems.add(new Item("Organic Bananas", 1, 6));
		checkItemsByDays.add(checkItems);
		//Day 3
		checkItems = new ArrayList();
		checkItems.add(new Item("Thermal Vest", 7, 17));
		checkItems.add(new Item("Aged Brie", -1, 4));
		checkItems.add(new Item("Chicken", 2, 4));
		checkItems.add(new Item("Sulfuras", 0, 80));
		checkItems.add(new Item("Backstage Passes", 12, 23));
		checkItems.add(new Item("Ginger Cake", 0, 3));
		checkItems.add(new Item("Organic Bananas", 0, 4));
		checkItemsByDays.add(checkItems);
		//Day 4
		checkItems = new ArrayList();
		checkItems.add(new Item("Chicken", 1, 3));
		checkItems.add(new Item("Sulfuras", 0, 80));
		checkItems.add(new Item("Backstage Passes", 11, 24));
		checkItems.add(new Item("Ginger Cake", -1, 0));
		checkItems.add(new Item("Organic Bananas", -1, 0));
		checkItemsByDays.add(checkItems);
		//Day 5
		checkItems = new ArrayList();
		checkItems.add(new Item("Chicken", 0, 2));
		checkItems.add(new Item("Sulfuras", 0, 80));
		checkItems.add(new Item("Backstage Passes", 10, 26));
		checkItemsByDays.add(checkItems);
		//Day 6
		checkItems = new ArrayList();
		checkItems.add(new Item("Chicken", -1, 0));
		checkItems.add(new Item("Sulfuras", 0, 80));
		checkItems.add(new Item("Backstage Passes", 9, 28));
		checkItemsByDays.add(checkItems);
		//Day 7
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 8, 30));
		checkItemsByDays.add(checkItems);
		//Day 8
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 7, 32));
		checkItemsByDays.add(checkItems);
		//Day 9
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 6, 34));
		checkItemsByDays.add(checkItems);
		//Day 10
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 5, 37));
		checkItemsByDays.add(checkItems);
		//Day 11
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 4, 40));
		checkItemsByDays.add(checkItems);
		//Day 12
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 3, 43));
		checkItemsByDays.add(checkItems);
		//Day 13
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 2, 46));
		checkItemsByDays.add(checkItems);
		//Day 14
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 1, 49));
		checkItemsByDays.add(checkItems);
		//Day 15
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", 0, 50));
		checkItemsByDays.add(checkItems);
		//Day 16
		checkItems = new ArrayList();
		checkItems.add(new Item("Backstage Passes", -1, 0));
		checkItemsByDays.add(checkItems);
		return checkItemsByDays;
	}

	@Before
	public void setUp() {
		this.supermarket = new SuperMarketPlusPlus();
		checkItemsByDays = populateCheckList();
	}

	@Test
	public void testUpdateQaulity() {
		for (int day=0; day < DAYS; day++) {
			System.out.println(day);
			supermarket.updateQuality();
			if (day==3){
				//We've proven that Brie & Thermal vest works as expected
				supermarket.getItems().remove(0);
				supermarket.getItems().remove(0);
			}
			if (day==4){
				//Ginger cake is gone
				supermarket.getItems().remove(3);
				//Bananas are off
				supermarket.getItems().remove(3);
			}
			if (day==6){
				//We throw away the chicken and Sulfuras work as expected
				supermarket.getItems().remove(0);
				supermarket.getItems().remove(0);
			}
			for (int i = 0; i < supermarket.getItems().size(); i++) {
				assertEquals(supermarket.getItems().get(i).getSellIn(), checkItemsByDays.get(day).get(i).getSellIn());
				assertEquals(supermarket.getItems().get(i).getQuality(), checkItemsByDays.get(day).get(i).getQuality());
			}
		}
	}


}
