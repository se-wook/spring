package com.ssafy.pms.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.ssafy.pms.model.dto.Phone;
import com.ssafy.pms.model.service.PhoneService;

import io.swagger.annotations.ApiOperation;

/**
 * @RestController
 * REST ful 을 위한 Controller로 모든 메서드에 @ResponseBody를 추가하지 않아도 
 * 직접 출력하는 Controller
 *  */
@RestController
public class PhoneRestController {
	@Autowired
	private PhoneService service;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	@GetMapping("/phone")
	@ApiOperation("전체  Phone 목록을 조회하는 기능")
	public ResponseEntity<Map<String, Object>> phones(){
		return handleSuccess(service.searchAll());
	}
	
	@GetMapping("/phone/{num}")  //1개 추출 하기 
	@ApiOperation("전체  Phone 목록을 조회하는 기능")
	public ResponseEntity<Map<String, Object>> phone(@PathVariable String num){
		return handleSuccess(service.search(num));
	}
	
	@PostMapping("/phone")
	@ApiOperation("Phone 정보 등록")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Phone phone){
		service.insert(phone);
		return handleSuccess("등록 완료");
	}
	
	@DeleteMapping("/phone/{num}")
	@ApiOperation("Phone 정보 삭제")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String num){
		service.delete(Arrays.asList(num));
		return handleSuccess("삭제 완료");
	}
	
	public ResponseEntity<Map<String, Object>> handleSuccess(Object data){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "ok");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus status){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "fail");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
}













