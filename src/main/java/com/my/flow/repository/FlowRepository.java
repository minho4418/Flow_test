package com.my.flow.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.flow.dto.Flow;

@Repository
public class FlowRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	//추가
		public int insert(Flow flow) {
			try {
				return sqlSession.insert("com.my.flow.FlowMapper.insert", flow);	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		//수정
		public int update(Flow flow) {
			return sqlSession.update("com.my.flow.FlowMapper.update", flow);
		}		
		
		public int updateRemoveyn(int file_num) {
			return sqlSession.update("com.my.flow.FlowMapper.updateRemoveyn", file_num);
		}
		
		public int updateRemoveyn2(int file_num) {
			return sqlSession.update("com.my.flow.FlowMapper.updateRemoveyn2", file_num);
		}
		
		//삭제
		public int delete(String file_extension) {
			return sqlSession.delete("com.my.flow.FlowMapper.delete", file_extension);
		}

		//한건조회
		public int deleteAll() {
			return sqlSession.delete("com.my.flow.FlowMapper.deleteAll");
		}
		
		//리스트
		public List<Flow> selectList() {
			return sqlSession.selectList("com.my.flow.FlowMapper.selectList");
		}
		
		public int selectTotalCnt() {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("com.my.flow.FlowMapper.selectTotalCnt");
		}

		
		
		
}
