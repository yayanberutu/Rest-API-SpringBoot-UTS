package del.ac.id.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import del.ac.id.demo.model.Item;
import del.ac.id.demo.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemRepository itemRepo;

	public List<Item> getAllItem(){
		return itemRepo.findAll();
	}
	
	public Item getItemById(String id) {
		return itemRepo.findById(id).get();
	}
}
