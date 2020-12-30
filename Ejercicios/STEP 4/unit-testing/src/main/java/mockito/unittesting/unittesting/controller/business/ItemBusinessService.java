package mockito.unittesting.unittesting.controller.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mockito.unittesting.unittesting.data.ItemRepository;
import mockito.unittesting.unittesting.model.Item;
/* STEP 2 - CHAPTER 7 */

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository repository;
	
	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}
}
