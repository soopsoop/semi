//사용자 사진 출력
function MemberPictureThumb(contextPath){
	 for(var target of document.querySelectorAll('.manPicture')){	
		 var id = target.getAttribute('data-id');
		 
		 target.style.backgroundImage="url('"+contextPath+"/member/getPicture.do?id="+id+"')";
		 target.style.backgroundPosition="center";
		 target.style.backgroundRepeat="no-repeat";
		 target.style.backgroundSize="cover";
	}
}	

function CloseWindow(parentURL) {
	if(parentURL) {
		window.opener.parent.location.href=parentURL;
	} else {
		window.opener.parent.location.reload(true);
	}
	window.close();
}

function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", " 
							+"height="+ WinHeight +", top="+ wintop +", left=" 
							+ winleft +", resizable=yes, status=yes"  );
	win.focus() ; 
}