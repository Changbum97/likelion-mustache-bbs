package com.mustache.springbootmustachebbs.repository;

import com.mustache.springbootmustachebbs.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
