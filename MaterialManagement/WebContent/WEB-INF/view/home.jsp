<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="/resources/styles.css">
   <script src="/resources/jquery-3.2.1.min.js" type="text/javascript"></script>
   <script src="/resources/script.js"></script>
   <title>Himalayan Material</title>
</head>
<body>
<div >

<div id='cssmenu'>
<ul>
   <li><a href='#'><span>Home</span></a></li>
   
   <li class='active has-sub'><a href='#'><span>Administration</span></a>
      <ul>
      <li class='has-sub'><a href='#'><span>Users</span></a>
      <ul>
         <li><a href='add_user'><span>Add</span></a>
          </li>
         <li ><a href='edit_user'><span>Modify</span></a>
          </li>
      </ul>
   </li>
  
         <li class='has-sub'><a href='#'><span>Account</span></a>
            <ul>
               <li><a href='add_Account'><span>Add</span></a></li>
               <li class='last'><a href='account_list'><span>Modify</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Account Group</span></a>
            <ul>
               <li><a href='add_AccountGroup'><span>Add</span></a></li>
               <li class='last'><a href='accountgroup_list'><span>Modify</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Item</span></a>
            <ul>
               <li><a href='add_item'><span>Add</span></a></li>
               <li class='last'><a href='item_list'><span>Modify</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Item Group</span></a>
            <ul>
               <li><a href='add_ItemGroup'><span>Add</span></a></li>
               <li class='last'><a href='itemgroup_list'><span>Modify</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Material Center</span></a>
            <ul>
               <li><a href='add_materialcentre'><span>Add</span></a></li>
               <li class='last'><a href='materialcentre_list'><span>Modify</span></a></li>
            </ul>
         </li>
          <li class='has-sub'><a href='#'><span>Units</span></a>
            <ul>
               <li><a href='add_munit'><span>Add</span></a></li>
               <li class='last'><a href='munit_list'><span>Modify</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
   
   
   
   
   
      <li class='has-sub'><a href='#'><span>Transaction</span></a>
      <ul>
      <li class='has-sub'><a href='#'><span>Sale</span></a>
      <ul>
         <li><a href='#'><span>Add</span></a>
          </li>
         <li ><a href='#'><span>Modify</span></a>
          </li>
      </ul>
   </li>
   
   <li class='has-sub'><a href='#'><span>Purchase</span></a>
      <ul>
         <li><a href='#'><span>Add</span></a>
          </li>
         <li ><a href='#'><span>Modify</span></a>
          </li>
      </ul>
   </li>
   
   <li class='has-sub'><a href='#'><span>Stock Transfer</span></a>
      <ul>
         <li><a href='#'><span>Add</span></a>
          </li>
         <li ><a href='#'><span>Modify</span></a>
          </li>
      </ul>
   </li>
   
   <li class='has-sub'><a href='#'><span>Payment</span></a>
      <ul>
         <li><a href='#'><span>Add</span></a>
          </li>
         <li ><a href='#'><span>Modify</span></a>
          </li>
      </ul>
   </li>
   
   <li class='has-sub'><a href='#'><span>Receipts</span></a>
      <ul>
         <li><a href='#'><span>Add</span></a>
          </li>
         <li ><a href='#'><span>Modify</span></a>
          </li>
      </ul>
   </li>
   
   
  </ul>
   <li class='last has-sub'><a href='#'><span>Display</span></a>
   <ul>
    <li><a href='#'><span>Balance Sheet</span></a>
          </li>
    <li><a href='#'><span>Account Summary</span></a>
          </li>
    <li><a href='#'><span>Stock Status</span></a>
          </li>
        
   </ul>
   </li>
</ul>
</div>
</div>

</body>

