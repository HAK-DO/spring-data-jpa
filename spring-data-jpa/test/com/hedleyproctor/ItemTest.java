package com.hedleyproctor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hedleyproctor.domain.Category;
import com.hedleyproctor.domain.Item;
import com.hedleyproctor.domain.Product;
import com.hedleyproctor.repository.ItemRepository;
import config.AppConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ItemTest {

	@Autowired ItemRepository itemRepository;

	@Test
	public void insertItem() {
		Product product = new Product("201312-000005", new Category("TEST000000"));
		Item item = new Item("test1234", product);
		itemRepository.save(item);
	}
}
