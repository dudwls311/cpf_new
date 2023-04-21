function fnHelpPopup(uri){
		    	var popupLink = '';
		    	var popupOption = 'width=1500,height=700,resizeable=yes,scrollbars=yes,status=no';
		    	
				if(uri == 'main') popupLink = '/guide/support/0001/';												//메인
		    	else if(uri == '/support/su_info/0001/') popupLink = '/guide/support/0002/';						//지원사업소개
				
				//지원사업신청
				else if(uri == '/support/su_sub/supadd/list/') popupLink = '/guide/support/0003/0008/0001/';		//가산금지원
		    	else if(uri == '/support/su_sub/scholarship/list/') popupLink = '/guide/support/0003/0009/0001/';	//장학금지원
				else if(uri == '/support/su_sub/suppay/list/') popupLink = '/guide/support/0003/0010/0001/';		//교육지원금
				else if(uri == '/support/su_sub/video/list/') popupLink = '/guide/support/0003/0012/0001/';			//화상영어
				else if(uri == '/support/su_sub/worksheet/list/') popupLink = '/guide/support/0003/0013/0001/';		//학습지
				else if(uri == '/support/su_sub/manager/list/') popupLink = '/guide/support/0003/0014/0001/';		//정착지원전문관리사
				else if(uri == '/support/su_sub/jobt/list/') popupLink = '/guide/support/0003/0015/0001/';			//취업연계직업훈련
				
				//커뮤니티
				else if(uri == '/support/commu/notice/') popupLink = '/guide/support/0004/0001/';	//공지사항
				else if(uri == '/support/commu/file/') popupLink = '/guide/support/0004/0002/';	//자료실
				else if(uri == '/support/commu/faq/') popupLink = '/guide/support/0004/0003/';	//자주묻는질문
				else if(uri == '/support/commu/qna/') popupLink = '/guide/support/0004/0004/';	//1:1문의
				
				//마이페이지
				else if(uri == '/support/mypage/myinfo/info_edit/') popupLink = '/guide/support/0005/0002/0001/';	//개인정보수정
				else if(uri == '/support/mypage/myinfo/password/') popupLink = '/guide/support/0005/0002/0002/';	//비밀번호 변경
				else if(uri == '/support/mypage/myinfo/logout/') popupLink = '/guide/support/0005/0002/0003/';	//회원탈퇴
				
				else if(uri == '/support/mypage/sup_history/0001/') popupLink = '/guide/support/0005/0001/';	//신청이력
				else if(uri == '/support/mypage/qna_history/') popupLink = '/guide/support/0005/0003/';	//1:1문의
				else if(uri == '/support/mypage/my_document/sign/') popupLink = '/guide/support/0005/0004/';	//서명관리
				else if(uri == '/support/mypage/my_document/docu/') popupLink = '/guide/support/0005/0005/';	//문서관리
				
		    	window.open(popupLink, "도움말", popupOption);
		    }