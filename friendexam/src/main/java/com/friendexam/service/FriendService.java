package com.friendexam.service;

import com.friendexam.domain.Friend;
import com.friendexam.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    @Transactional(readOnly = true)
    public Iterable<Friend> findAllFriends() {
        return friendRepository.findAll();
    }

    @Transactional
    // 친구등록
    public Friend saveFriend(Friend friend) {
        // Spring Data 에서 제공하는 save라는 메서드는 id에 해당하는 값이 이미 존재한다면 수정
        // 없다면 생성한다.
        return friendRepository.save(friend);
    }

    @Transactional(readOnly = true)
    // id에 해당하는 친구 정보 조회
    public Friend findFriendById(Long id) {
        return friendRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteFriendById(Long id) {
        friendRepository.deleteById(id);
    }

    // 페이징 처리된 친구 목록 조회
    public Page<Friend> findAllFriends(Pageable pageable){
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC,"id"));

        return friendRepository.findAll(sortedByDescId);
    }
}