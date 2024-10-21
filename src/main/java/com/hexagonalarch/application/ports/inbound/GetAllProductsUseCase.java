package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.response.GetProductResponse;
import java.util.List;

public interface GetAllProductsUseCase {

    List<GetProductResponse> getAllProducts();

}
