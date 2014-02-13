<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${title}</title>
</head>

<body>
this page only for admin <a href="${createLink(controller: 'logout', action: 'index')}">logoff</a>
<br/>
<br/>
Username : <sec:username/><br/>
Role : ${com.testapp.User.findByUsername(sec.username()).getAuthorities().authority}<br/>
</body>
</html>