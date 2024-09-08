package com.api.nexus.pagination;

public interface PageableQuery {

    Integer getPage();

    Integer getItemsByPage();

    String getOrderBy();

    String getInOrder();
}
