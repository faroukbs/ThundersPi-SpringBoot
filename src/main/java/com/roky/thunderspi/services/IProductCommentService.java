package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.ProductComment;

import java.util.List;

public interface IProductCommentService {
    public List<ProductComment> retrieveAllCommentaires();

    public ProductComment addCommentaire(ProductComment c);

    public void deleteCommentaire(Long id);
    public ProductComment updateCommentaire(ProductComment u);
    public ProductComment retrieveCommentaire(Long id);
}