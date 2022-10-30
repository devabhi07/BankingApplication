package com.project.bank.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor

@Document("transferData")
public class Transfer {
	private int accountNo;
	private int aNo;
	private int amount;
}
