package del.ac.id.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 
	 @PutMapping(value = "/update/{id}")
	 public ResponseEntity<Item> updateItem(@PathVariable("id") String id, @RequestBody Item item){
		 try {
			 Item existItem = itemService.getItemById(id);
			 item.setId_item(id);
			 System.out.println(item.getItem_name());
			 itemService.saveItem(item);
			 return new ResponseEntity<Item>(item, HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<Item>(item, HttpStatus.NOT_FOUND);
		 }
		 
	 }
	 
	 @PostMapping(value="/add")
	 public ResponseEntity<Item> createItem(@RequestBody Item item){
		 itemService.saveItem(item);
		 
		 return new ResponseEntity<Item>(item, HttpStatus.OK);
	 }
	 
	 @DeleteMapping(value="/delete/{id}")
	 public ResponseEntity<String> deleteItem(@PathVariable("id") String id){
		 try {
			 Item existItem = itemService.getItemById(id);
			 itemService.deleteItem(id);
			 return new ResponseEntity<String>(HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
	 }
}
