package com.codeandlearn.ProductService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseEntityExternal {

	private String msg;
	private String errorCode;
	private int errorStatus;
}
