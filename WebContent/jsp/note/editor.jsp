<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor demo</title>
</head>
<body>
    <div id="editor">
        <p></p>
    </div>

    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="<c:url value="../js/wangEditor.min.js"/>"></script>
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('editor') )
        editor.create()
        function geteditorinfo(){
        	return editor.txt.html();
        }
        
        function seteditorinfo(info){
        	editor.txt.html(info);
        }
    </script>
</body>
</html>