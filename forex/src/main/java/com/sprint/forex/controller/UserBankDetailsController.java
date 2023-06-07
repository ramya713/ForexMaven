package com.sprint.forex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.CommonDTO;
import com.sprint.forex.dto.UserBankDetailsDto;
import com.sprint.forex.entity.UserBankDetails;
import com.sprint.forex.service.IUserBankDetailsService;

@RestController

public class UserBankDetailsController {
	
	@Autowired
	private IUserBankDetailsService iUserBankDetails;
	
	
	@PostMapping("/UserBankDetails/save")
	public ResponseEntity<CommonDTO<UserBankDetailsDto>> addBankDetails(@Valid @RequestBody UserBankDetailsDto userBankDetails )
	{
		 UserBankDetailsDto newUserBankDetails = iUserBankDetails.saveBankDetails(userBankDetails);
		return new ResponseEntity<>(new CommonDTO<>("Bank details successfully added",newUserBankDetails), HttpStatus.CREATED);

	}
	@PutMapping("/UserBankDetails/update")
	public ResponseEntity<CommonDTO<UserBankDetailsDto>> updateBankDetails(@Valid @RequestBody UserBankDetailsDto userBankDetails )
	{
		UserBankDetailsDto newUserBankDetails = iUserBankDetails.updateBankDetails(userBankDetails);
		return new ResponseEntity<>(new CommonDTO<>("Bank details updated successfully",newUserBankDetails), HttpStatus.CREATED);

	}
	@GetMapping("/bank-details/{userId}")
	public ResponseEntity<CommonDTO<UserBankDetails>> fetchMyBank(@PathVariable("userId") int userId )
	{
		UserBankDetails newUserBankDetails = iUserBankDetails.findByUserId(userId);
		return new ResponseEntity<>(new CommonDTO<>("Bank details successfully fetched",newUserBankDetails), HttpStatus.OK);

	}
}	