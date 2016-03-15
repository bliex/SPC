package com.spc.jpa.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "board", itemResourceRel = "board", collectionResourceRel = "board", excerptProjection = BasicBoardProjection.class)
public interface BoardRepository extends JpaRepository<Board, String> {


}
