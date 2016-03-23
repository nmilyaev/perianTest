
public class MyItem extends Item{

    public MyItem(String name, int sellIn, int quality) {
		super(name,sellIn,quality);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;
		return (name.equals(item.name));
	}

}
