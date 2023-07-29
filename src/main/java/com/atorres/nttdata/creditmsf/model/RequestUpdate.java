package com.atorres.nttdata.creditmsf.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestUpdate {
	private BigDecimal balance;
	private BigDecimal debt;
}
