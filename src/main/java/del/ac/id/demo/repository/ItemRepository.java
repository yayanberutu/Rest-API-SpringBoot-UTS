package del.ac.id.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import del.ac.id.demo.model.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

}
