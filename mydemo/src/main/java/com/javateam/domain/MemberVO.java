package com.javateam.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class MemberVO{
	
	private int no;
	@NotNull
	@Size(min=2,max=5, message="이름은 2~5자 입니다")
	private String name;
	@NotNull
	@Size(min=2,max=5, message="제목은 2~5자 입니다")
	private String title;
	@NotNull
	@Size(min=2,max=50, message="내용은 2~50자 입니다")
	private String content;
	@NotNull
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,11}",   
    message="패쓰워드는 특수문자, 숫자, 영문자대소문자를 혼합하여 8~20자로 입력합니다.")  
	private String password;
	private Date date;
	
}
