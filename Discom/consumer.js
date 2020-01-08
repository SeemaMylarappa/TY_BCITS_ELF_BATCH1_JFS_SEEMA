function accountid(){
    var accountdetail=document.forms['accountdetail'];
    var acc=document.forms['accountid'];
    if(acc.trim().length>10){
       document.getElementById('accErr').style.display='none'
       console.log('acc id is valid')
    }else{
        document.getElementById('accErr').style.display='block'
        document.getElementById('id').style.border='1px solid red'
        console.log('enter 10 digit number')
    }
}


