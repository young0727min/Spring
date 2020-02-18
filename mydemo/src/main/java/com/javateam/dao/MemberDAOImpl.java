package com.javateam.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javateam.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	

	@Override
	public List<MemberVO> list() throws Exception {
		
		return sqlSession.selectList("list");
	}

	@Override
	public MemberVO select(int no) throws Exception {
		
		MemberVO vo = (MemberVO) sqlSession.selectOne("select",no);
		
		return vo;
	}

	@Override
	public void insert(MemberVO memberVO) throws Exception {
		sqlSession.insert("insert",memberVO);
		
	}

	@Override
	public void update(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("update",memberVO);
	}
	
	@Override
	public int delete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		 return sqlSession.delete("delete",memberVO);
	}
	
	

}
