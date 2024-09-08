package com.api.nexus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPageableQuery implements PageableQuery {
    private Integer page;
    private Integer itemsByPage;
    private String orderBy;
    private String inOrder;

    public ProductPageableQuery() {
        this.page = 0;
        this.itemsByPage = 10;
        this.orderBy = "id";
        this.inOrder = "ASC";
    }
}
