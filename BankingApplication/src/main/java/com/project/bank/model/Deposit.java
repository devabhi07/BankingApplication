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
@Document("depositData")
public class Deposit {
	private int accountNo;
	private int amount;
}
