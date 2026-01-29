package com.jane.ollama.service;

import com.jane.ollama.entity.HelpDeskEntity;
import com.jane.ollama.model.TicketRequest;
import com.jane.ollama.repository.HelpDeskTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpDeskTicketService {

    private final HelpDeskTicketRepository helpDeskTicketRepository;

    public HelpDeskEntity createTicket(TicketRequest ticketInput, String username) {
        HelpDeskEntity ticket = HelpDeskEntity.builder()
                .issue(ticketInput.issue())
                .username(username)
                .status("OPEN")
                .createdAt(LocalDateTime.now())
                .eta(LocalDateTime.now().plusDays(7))
                .build();
        return helpDeskTicketRepository.save(ticket);
    }

    public List<HelpDeskEntity> getTicketsByUsername(String username) {
        return helpDeskTicketRepository.findByUsername(username);
    }

}
