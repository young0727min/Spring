package com.javateam.service;

import java.util.List;

import com.javateam.domain.MemberVO;

public interface MemberService {
	
	//게시글 전체보기
	public List<MemberVO> list() throws Exception; 
	
	//게시글 상세보기
	public MemberVO read(int no)throws Exception; 
	
	//게시글 입력
	public void write(MemberVO memberVO)throws Exception;
	
	//게시글 수정
	public void edit(MemberVO memberVO) throws Exception;

	//게시글 삭제
	public int delete(MemberVO memberVO) throws Exception;
}
