import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlus {

    private List<Item> items = null;

    public SuperMarketPlusPlus() {
        this.items = new ArrayList<>();
        this.populateProductList();
    }

    private void populateProductList() {
        items = new ArrayList<Item>();
        items.add(new Item("Thermal Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Chicken", 5, 7));
        items.add(new Item("Sulfuras", 0, 80));
        items.add(new Item("Backstage Passes", 15, 20));
        items.add(new Item("Ginger Cake", 3, 6));
        items.add(new Item("Organic Bananas", 3, 10));
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Starting Supermarket Plus Plus");
        SuperMarketPlusPlus supermarket = new SuperMarketPlusPlus();
        supermarket.updateQuality();
    }


    public void updateQuality() {
        Item item = null;
        for (int i = 0; i < items.size(); i++) {
            item = items.get(i);
            item.setSellIn(item.getSellIn() - 1);
            switch (item.getName()) {
                case "Aged Brie": {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                    break;
                }
                case "Backstage Passes": {
                    item.setQuality(item.getQuality() + 1);
                    if (item.getSellIn() < 11) {
                            item.setQuality(item.getQuality() + 1);
                    }
                    if (item.getSellIn() < 6) {
                        item.setQuality(item.getQuality() + 1);
                    }
                    item.setQuality(item.getQuality() > 50 ? 50: item.getQuality());
                    break;
                }
                case "Sulfuras": {
                    item.setSellIn(item.getSellIn() + 1);
                    break;
                }
                case "Organic Bananas":
                    item.setQuality(item.getQuality() - 2);
                    break;
                default: {
                    item.setQuality(item.getQuality() - 1);
                }
            }
            checkSelInDate(i);
        }
    }

    private void checkSelInDate(int i) {
        Item item = items.get(i);
        if (item.getSellIn() < 0) {
            switch (item.getName()) {
                case "Aged Brie": {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                    break;
                }
                case "Sulfuras": {
                    // do nothing
                    break;
                }
                // Once the product is past sell by date, it's a junk - unless it's Brie
                default: {
                    item.setQuality(0);
                }
            }
        }
    }

}