package com.har.journey.repo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

	@Mock
	private ProductRepository productRepository;

	@Test
	public void testUpdateProdCodeById() {
		String prodCode = "newCode";
		Long prodId = 1L;
		when(productRepository.updateProdCodeById(prodCode, prodId)).thenReturn(1);
		productRepository.updateProdCodeById(prodCode, prodId);
		verify(productRepository,times(1)).updateProdCodeById(prodCode, prodId);

	}

}
