package techit.boardmvc.repository;

import techit.boardmvc.domain.Board;

import java.util.List;

public interface PageAndSortingRepository {
    List<Board> getBoardsPage(int page, int size);
    int getTotalBoardCount();
}