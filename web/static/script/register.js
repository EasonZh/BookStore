function $(id){
    return document.getElementById(id);
}
function preRegister() {
    var unameTxt = $("unameTxt");
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    var unameReg = /[0-9a-zA-Z]{6,16}/;
    if (!unameReg.test(uname)) {
        unameSpan.style.visibility = "visible"
        return false;
    } else {
        unameSpan.style.visibility = "hidden"

    }
    var pwdTxt1 = $("pwdTxt1");
    var pwdTxt2 = $("pwdTxt2")
    var pwd1 = pwdTxt1.value;
    var pwd2 = pwdTxt2.value;
    var pwdSpan1 = $("pwdSpan1");
    var pwdSpan2 = $("pwdSpan2");
    var pwdReg = /[.]{8,}/;
    if(!pwdReg.test(pwd1)){
        pwdSpan1.style.visibility="visible";
        return false;
    }else{
        pwdSpan1.style.visibility="hidden"
    }
    if(pwd1!=pwd2){
        pwdSpan2.style.visibility="visible";
        return false;
    }else{
        pwdSpan2.style.visibility="hidden"
    }
    return  true;
}

//如果想要发送异步请求，我们需要一个关键的对象 XMLHttpRequest
var xmlHttpRequest ;

function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest() ;
    }else if(window.ActiveXObject){//IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

function ckUname(uname){
    createXMLHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname ;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB ;
    //发送请求
    xmlHttpRequest.send();
}

function ckUnameCB(){
    if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
        //xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
        //alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText ;
        // {'uname':'1'}
        //alert(responseText);
        if(responseText=="{'uname':'1'}"){
            alert("用户名已经被注册！");
        }else{
            alert("用户名可以注册！");
        }
    }
}
