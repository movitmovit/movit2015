<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>

<style>

html { 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
body {
  background: transparent;
}

body, input, button {
  font-family: 'Source Sans Pro', sans-serif;
}

/* logo{
	text-align:center;text-indent:50px;color:white;
	pading:15px;width:400px;
}
 */
.search {
  padding: 15px;
  width: 400px;
  min-height: 100px;
  margin: 3% auto 0 auto;

  .heading {
    text-align: center;
    margin-top: 1%;

  }

  form {
    .serchMovie {
      border-bottom: 1px solid rgba(255, 255, 255, 0.1);
      border-top: 1px solid rgba(255, 255, 255, 0.1);

      &:last-of-type {
        border-top: none;
      }

      span {
        background: transparent;
        min-width: 53px;
        border: none;

        i {
          font-size: 1.5em;
          color: rgba(255, 255, 255, 0.2);
        }
      }
    }

    input.form-control {
      @include normalize-input;

      padding: 10px;
      font-size: 1.6em;
      width: 100%;
      background: transparent;
      color: $input-color;

      &:focus {
        border: none;
      }
    }

    button {
      margin-top: 20px;
      background: $button-background-color;
      border: none;
      font-size: 1.6em;
      font-weight: 300;
      padding: 5px 0;
      width: 100%;
      border-radius: 3px;
      color: lighten($button-background-color, 40%);
      border-bottom: 4px solid darken($button-background-color, 10%);

      &:hover {
        background: tint($button-background-color, 4%);
        -webkit-animation: hop 1s;
        animation: hop 1s;
      }
    }
  }
}

</style>

<logo>
<a href="main2.do">Main</a>
</logo>

<f1>
 <form action="#" >
<div class="search">
  <div class="heading">
      <div class="serchMovie">
        <input type="text" class="form-control" placeholder="search"align="center">
        <button type="submit" class="float"align="center">Go!</button>
          </div>
  </form>
   </div>
 </div>
</f1>







<%-- <table background="../images/bkg-topbar.gif" border="0" cellspacing="0" cellpadding="5" width="100%">
  <tbody>
  <tr>
    <td><a href="<c:url value="/shop/index.do"/>"><img border="0" src="../images/logo-topbar.gif" /></a></td>
    <td align="right"><a href="<c:url value="/shop/viewCart.do"/>"><img border="0" name="img_cart" src="../images/cart.gif" /></a>
      <img border="0" src="../images/separator.gif" />

<c:if test="${empty userSession.account}" >
      <a href="<c:url value="/shop/signonForm.do"/>"><img border="0" name="img_signin" src="../images/sign-in.gif" /></a>
</c:if>

<c:if test="${!empty userSession.account}" >
      <a href="<c:url value="/shop/signoff.do"/>"><img border="0" name="img_signout" src="../images/sign-out.gif" /></a>
      <img border="0" src="../images/separator.gif" />
      <a href="<c:url value="/shop/editAccount.do"/>"><img border="0" name="img_myaccount" src="../images/my_account.gif" /></a>
</c:if>

      <img border="0" src="../images/separator.gif" /><a href="../help.html"><img border="0" name="img_help" src="../images/help.gif" /></a>
    </td>
    <td align="left" valign="bottom">
      <form action="<c:url value="/shop/searchProducts.do"/>" method="post">
			  <input type="hidden" name="search" value="true"/>
        <input name="keyword" size="14" />&nbsp;<input border="0" src="../images/search.gif" type="image"/>
      </form>
    </td>
  </tr>
  </tbody>
</table>

<%@ include file="IncludeQuickHeader.jsp" %> --%>
