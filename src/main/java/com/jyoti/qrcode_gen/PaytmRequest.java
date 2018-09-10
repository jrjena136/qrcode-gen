package com.jyoti.qrcode_gen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaytmRequest {
	private String name;
	private String mobileNo;
	private String accountNo;
	private String accType;

}
