package com.fetchrewardpoints.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fetchrewardpoints.domain.UserRecord;
import com.fetchrewardpoints.service.FetchRewardService;

@RestController
public class FetchRewardController {

	@Autowired
	FetchRewardService fetchRewardService;
	
	@GetMapping("/hello-world")
	public String greeting() {
		return "Hello world from Vedashruti";
	}

	@PostMapping("/addPoints")
	public ResponseEntity<String> addPoints(@RequestBody UserRecord record) {
		fetchRewardService.addPoints(record);
		return new ResponseEntity<String>("Added", HttpStatus.OK);
	}

	@PostMapping("/deductPoints")
	public ResponseEntity<List<UserRecord>> deduct(@RequestParam int points) {

		List<UserRecord> list = fetchRewardService.deduct(points);
		return new ResponseEntity<List<UserRecord>>(list, HttpStatus.OK);
	}

	@GetMapping("/getPoints")
	public ResponseEntity<Map<String, Integer>> getPoints() {
		Map<String, Integer> map = fetchRewardService.getPoints();
		return new ResponseEntity<Map<String, Integer>>(map, HttpStatus.OK);
	}

}
