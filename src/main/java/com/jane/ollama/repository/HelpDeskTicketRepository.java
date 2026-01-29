package com.jane.ollama.repository;

import com.jane.ollama.entity.HelpDeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelpDeskTicketRepository extends JpaRepository<HelpDeskEntity, Long> {
    List<HelpDeskEntity> findByUsername(String username);
}
