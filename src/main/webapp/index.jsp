<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/todo.css">
        <title>Todo</title>
        <link rel="shortcut icon" href="#">
        
    </head>
    <body >
        <header>
            Todo
        </header>
        <form>
            <textarea class="item" name="task" id="task" cols="30" rows="10" placeholder="Enter Your Task"></textarea>
            <div>
                <label class="item" for="hour">Hour</label><select class="item" name="hour" id="hour"></select>
                <label class="item" for="minute">Minute</label><select class="item" name="minute" id="minute"></select>
            </div>
            <input class="item btn" type="button" onsubmit="e.preventDefault()" onclick="sendData()" value="Add Task">
        </form>
        <div class="container">

        </div>
        <!-- javascript -->
        <script src="JS/todo.js"></script>
        <script>
            var id;
            function sendData(){
           
                let req=new XMLHttpRequest();
                let task=document.getElementById('task').value;
                let hour=document.getElementById('hour').value;
                let minute=document.getElementById('minute').value;
                if(task===""){
                    console.log("input data first then call send Data");
                
                }else{
            req.open('GET',`sv?task=${task}&hour=${hour}&minute=${minute}`,true);
                req.send();
                document.getElementById('task').value="";
                 id=setTimeout(()=>{ getTasksData(); },2000);
                
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
                clearTimeout(id);
            }
            console.log("getdata is called");
            getTasksData();
            
        </script>
    </body>
</html>