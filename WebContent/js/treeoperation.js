function two(id)
{
  var object=document.getElementById(id);
  if(object.style.display=="block" || object.style.display=="")
  {
     object.style.display="none";
     var ob2=document.getElementById('s'+id);
     ob2.style.backgroundImage="url(../images/open.gif)";
  }
  else
  {
    object.style.display="block";
    var ob2=document.getElementById('s'+id);
    ob2.style.backgroundImage="url(../images/closed.gif)";
  }
}
function three(id)
{
  var object=document.getElementById(id);  
  if(object.style!=null&&object.style.display=="block")
  {
     object.style.display="none";
     var ob2=document.getElementById('s'+id);
     ob2.style.backgroundImage="url(../images/open.gif)";
  }
  else
  {
    object.style.display="block";
    var ob2=document.getElementById('s'+id);
    ob2.style.backgroundImage="url(../images/closed.gif)";
  }
}