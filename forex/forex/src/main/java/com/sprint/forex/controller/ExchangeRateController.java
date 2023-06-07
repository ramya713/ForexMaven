package com.sprint.forex.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sprint.forex.dto.CommonDTO;
import com.sprint.forex.dto.RateConvertDTO;
import com.sprint.forex.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.ExchangeRateDto;
import com.sprint.forex.entity.ExchangeRate;
import com.sprint.forex.service.ExchangeRateService;
@CrossOrigin()
@RestController
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService exchangeRateService;
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/rate/convert")
	public ResponseEntity<CommonDTO<Double>> convertAmount(@RequestBody RateConvertDTO r){
		Double convertedAmount = exchangeRateService.convertAmount(r.getAmount(), r.getFromCurrency(), r.getToCurrency());
		return ResponseEntity.ok(new CommonDTO<>("Converted", convertedAmount));
		
	}
	
// To get all the rates by entering date
	@GetMapping("/exchange-rates/{date}")
	public ResponseEntity<List<ExchangeRate>> getRatesByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String dateString = date.format(formatter);
	    List<ExchangeRate> rates = exchangeRateService.getRatesByDate(dateString);
	    ResponseEntity<List<ExchangeRate>> responseEntity = new ResponseEntity<>(rates, HttpStatus.OK);
	    return responseEntity;
	}
	@PutMapping("/exchangeRate/update")
	public ResponseEntity<CommonDTO<ExchangeRate>> modifyRate(@RequestBody ExchangeRate exchangeRate) {
		ExchangeRate updatedexchangeRate = adminService.updateExchangeRate(exchangeRate);
		return new ResponseEntity<>(new CommonDTO<>("Exchange rate successfully updated",updatedexchangeRate), HttpStatus.OK);


	}

	
//	To get rates by providing from currency and to currency and date
	@GetMapping("/exchange-rates/{fromCurrency}/{toCurrency}/{date}")
	public ResponseEntity<List<ExchangeRate>> getRatesByFromToCurrencyAndDate(@PathVariable("fromCurrency")String fromCurrency, @PathVariable("toCurrency")String toCurrency ,@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	    List<ExchangeRate> rates = exchangeRateService.getRatesByFromToCurrencyAndDate(fromCurrency, toCurrency, date);
	    ResponseEntity<List<ExchangeRate>> responseEntity = new ResponseEntity<>(rates, HttpStatus.OK);
	    return responseEntity;
	}
//	To get all rates
	@GetMapping("/rate/all")
	public List<ExchangeRate> findAllRates() {
		List<ExchangeRate> list = exchangeRateService.findAllRates();
		return list;
	}
	
	
	@GetMapping("/rate/{id}")
	public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable("id") int Id) {
		ExchangeRate exchangeRate = exchangeRateService.getById(Id);
		return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
	}
	


}
