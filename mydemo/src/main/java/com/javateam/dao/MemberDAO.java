package com.javateam.dao;

import java.util.List;

import com.javateam.domain.MemberVO;


public interface MemberDAO {
	
	//게시글 전체보기
	public List<MemberVO> list()throws Exception; 
	
	//게시글 상세보기
	public MemberVO select(int no) throws Exception;
	
	//게시글 입력
	public void insert(MemberVO memberVO) throws Exception;
	
	//게시글 수정
	public void update(MemberVO memberVO) throws Exception;
	
	//게시글 삭제
	public int delete(MemberVO memberVO) throws Exception;
}
