
<%@ page import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="student" value="${it.student}" scope="page"></c:set>

<br />
<h2>ID:&nbsp;${student.getId()}</h2>
<br />
<h2>Name:&nbsp;${student.getName()}</h2>
<br />
<h2>Email:&nbsp;${student.getEmail()}</h2>
<br />
<h2>Phone:&nbsp;${student.getPhone()}</h2>
<br />
<h2>Sex:&nbsp;${student.getSex()}</h2>
<br />
<h2>Age:&nbsp;${student.getAge()}</h2>
<br />
<h2>Address:&nbsp;${student.getAddress()}</h2>
