package com.javateam.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javateam.dao.MemberDAO;
import com.javateam.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;
	

	@Override
	public List<MemberVO> list()throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}


	@Override
	public MemberVO read(int no)throws Exception {
		// TODO Auto-generated method stub
		return dao.select(no);
	}


	@Override
	public void write(MemberVO memberVO) throws Exception{
		dao.insert(memberVO);
		
	}


	@Override
	public void edit(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		 dao.update(memberVO);
	}


	@Override
	public int delete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
	   return dao.delete(memberVO);
	}
	
	
	
	
	

}
