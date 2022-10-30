package com.project.bank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
@Data
@Document("userData")
public class Users {
	@Id
	private int accountNo;
	private String customerName;
	private String customerAdds;
	private int customerphone;
	private int balance;
}
