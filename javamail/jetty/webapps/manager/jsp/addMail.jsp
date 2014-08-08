<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.4.4.js"></script>
</head>
<body>

<form id="form11" method="post" action="/manager/mail/sendmail" >
标题：<input name="mailtitle" type="text">
内容：<textarea rows="10" cols="20" name="mailcontent"></textarea>
<input type="submit" value="发送">
</form>


<!-- 
2：iframe---form提交的时候有target属性，默认值是_self,你在页面中加入一个隐藏的ifram，<iframe name=myiframe width=0 height=0></iframe>，然后将from的target属性设置为myiframe即可。
<iframe id="uploadframe" name="uploadframe"   style="visibility:hidden;"></iframe>
 -->
<form id="form1" method="post" action="sync_upload.jsp" enctype="multipart/form-data"  target="uploadframe" >
附件：<input type="file" id="upload" name="attach" onchange="startUpload(this.form)"/>
</form>
<iframe id="uploadframe" name="uploadframe"   style="height:20px;width=20px" ></iframe>

<button onclick="getIframeContext();">测试iframe里面的内容</button>

</body>
</html>
<script>

$(function(){
	///alert(1);
	
});

var t1;  

//选择了文件后开始异步上传    
function startUpload(oForm) {      
    oForm.submit();
    //alert($("#id").("context"));
    
    t1 = window.setInterval(listenIframe,500);
    
    return false;
}


function listenIframe(){
	getIframeContext();
}

function getIframeContext(){
	var context = $(window.frames["uploadframe"].document).find("#result").html();
	var context1 = $(window.frames["uploadframe"].document).find("#result_context").html();
	if(context=="huangbiao"){
		
	alert(context);
	alert(context1);
		window.clearInterval(t1); 
		
	}
}
  
  
//整个页面的提交    
function formSubmit(oForm) {    
    oForm.action = document.URL;    
    oForm.target = '_self';    
    oForm.submit();    
}   
</script>