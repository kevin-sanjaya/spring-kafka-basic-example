package com.demo.javakafka.controller;

import com.demo.javakafka.consumer.TransactionConsumer;
import com.demo.javakafka.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    private final KafkaTemplate<String, Transaction> transactionTemplate;
    private final TransactionConsumer transactionConsumer;

    @Autowired
    public TransactionController(KafkaTemplate<String, Transaction> transactionTemplate, TransactionConsumer transactionConsumer) {
        this.transactionTemplate = transactionTemplate;
        this.transactionConsumer = transactionConsumer;
    }

    @PostMapping("/transaction")
    public void produce(@RequestBody Transaction transaction) {
        transactionTemplate.send("transaction", transaction);
    }

    @GetMapping("/transaction")
    public List<Transaction> getTransactions() {
        return transactionConsumer.getTransactions();
    }
}
