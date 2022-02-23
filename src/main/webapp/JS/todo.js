
 function mark(url){
        let req=new XMLHttpRequest();
                req.open('GET',url,true);
                req.send();
                 setTimeout(()=>{ getTasksData(); },500);
    };


function insertELement(ele,n){
    for(let i=0;i<n;i++){
        let opt=document.createElement("option");
        opt.setAttribute('value',i);
        opt.innerHTML=i;
        ele.appendChild(opt);
    }

}

let ele=document.getElementById('hour');
insertELement(ele,24);
ele=document.getElementById('minute');
insertELement(ele,60);