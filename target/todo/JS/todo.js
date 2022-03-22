

              var id;
              function sendData(){
           
                let req=new XMLHttpRequest();
                let task=document.getElementById("task").value;
                let hour=document.querySelector('#hour').value;
                let minute=document.querySelector('#minute').value;
                
                if(task===""){
                    console.log("input data first then call send Data");
                
                }else{
             req.open('GET',`sv?task=${task}&hour=${hour}&minute=${minute}`,true);
                req.send();
                document.getElementById('task').value="";
                 setTimeout(()=>{ getTasksData(); },1000);
               
            }
                
            }
            
             function getTasksData(){
                let req=new XMLHttpRequest();
                console.log("we are in getdata");
                req.open("GET",'showTasks.jsp',true);
                req.send();
                req.onreadystatechange=function(){
                    if(req.readyState===4){
                       console.log("we are in onreadystatechange");
                       //console.log(req.responseText);
                       document.getElementsByClassName('container')[0].innerHTML=req.responseText;
                    }
                };
                //clearTimeout(id);
                        
            }
            console.log("getdata is called");
            getTasksData();



 async function mark(url){
        let req=new XMLHttpRequest();
                req.open('GET',url,true);
               await req.send();
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