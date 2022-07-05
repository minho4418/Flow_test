package com.my.flow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.flow.advice.ErrorCode;
import com.my.flow.dto.Flow;
import com.my.flow.repository.FlowRepository;

@Service
public class FlowService {
	
	@Autowired
	private FlowRepository flowRepository;
	
		public int insert(Flow flow) {
		
			return flowRepository.insert(flow);
		}
	
		public int update(Flow flow) {
			return flowRepository.update(flow);
		}

		
		public int updateRemoveyn(int file_num) {
			return flowRepository.updateRemoveyn(file_num);
		}
		
		public int updateRemoveyn2(int file_num) {
			return flowRepository.updateRemoveyn2(file_num);
		}
		
		public int delete(String file_extension) {
			return flowRepository.delete(file_extension);
		}

		public int deleteAll() {
			// TODO Auto-generated method stub
			return flowRepository.deleteAll();
		}
		
		public List<Flow> selectList(){
			return flowRepository.selectList();
		}
		
		public int selectTotalCnt() {
			return flowRepository.selectTotalCnt();
		}
		
}
