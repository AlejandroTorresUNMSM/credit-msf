package com.atorres.nttdata.creditmsf.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CreditDto {
	private String id;
	private BigDecimal balance;
	private BigDecimal debt;
	private Date expirationDate;
	private String client;
}
