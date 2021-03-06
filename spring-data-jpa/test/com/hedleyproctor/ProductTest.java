package com.hedleyproctor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.hedleyproctor.domain.Category;
import com.hedleyproctor.domain.Product;
import com.hedleyproctor.repository.ProductRepository;

import config.ApplicationConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ProductTest {

	@Autowired ProductRepository productRepository;

	private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATEFORMAT = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMM");
		}
	};

	@Test
	public void insertProduct() {
		Category category = new Category("TEST000000");
		String productId = generateProductId(category);
		Product prduct = new Product(productId, category);
		productRepository.save(prduct);
	}

//	@Test
	public void findByCategory() {
		List<Product> products = productRepository.findByCategory(new Category("TEST000000"), new PageRequest(0, 4));
		for (Product product : products) {
			System.out.println(product);
		}
	}

	/**
	 * temp use
	 * 
	 * @param maxId
	 * @param category
	 * @return
	 */
	private String generateProductId(Category category) {
		String max = productRepository.getMaxByCategoryId(category.getCategoryId());
		if (StringUtils.isEmpty(max)) {
			StringBuffer sb = new StringBuffer();
			sb.append(THREAD_LOCAL_DATEFORMAT.get().format(new Date()));
			sb.append("-");
			sb.append(String.format("%06d", 1));
			return sb.toString();
		} else {
			String[] token = max.split("\\-");
			StringBuffer sb = new StringBuffer();
			sb.append(THREAD_LOCAL_DATEFORMAT.get().format(new Date()));
			sb.append("-");
			sb.append(String.format("%06d", Integer.valueOf(token[1]) + 1));
			return sb.toString();
		}
	}
}
