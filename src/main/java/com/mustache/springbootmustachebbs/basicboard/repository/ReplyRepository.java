package com.mustache.springbootmustachebbs.basicboard.repository;

import com.mustache.springbootmustachebbs.basicboard.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
