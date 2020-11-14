package del.ac.id.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import del.ac.id.demo.model.Item;
import del.ac.id.demo.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	
	@GetMapping("")
	public List<Item> getAllItem(){
		return itemService.getAllItem();
	}

	 @GetMapping("/{id}")
	 public ResponseEntity<Item> get(@PathVariable("id") String id) {
		 try {
			 Item item = itemService.getItemById(id);
			 return new ResponseEntity<Item>(item, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}
}
