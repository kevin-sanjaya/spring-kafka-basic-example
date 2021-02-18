package com.demo.javakafka.consumer;

import com.demo.javakafka.model.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionConsumer {
    private final List<Transaction> transactions = new ArrayList<>();

    @KafkaListener(topics = "transaction", groupId = "transaction-group")
    public void listen(Transaction transaction) {
        synchronized (transactions) {
            transactions.add(transaction);
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
