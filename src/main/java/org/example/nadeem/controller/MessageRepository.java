package org.example.nadeem.controller;

import org.example.nadeem.service.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
