var email_id;
function validate() {
    
    // var f_name = document.getElementsById("fname").values;
    // var l_name = document.getElementsById("lname").values;
    // var father_name = document.getElementsById("father_name").values;
    
    email_id = document.getElementsByName("email").value;
    
     

    // var standard = document.getElementsById("class").values;
    // var age = document.getElementsById("age").values;
     var emailRegx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
     alert("tojoh3");

    
    if(!email_id.match(emailRegx))  
    {
        alert("inavlid email");
        return false;
    }
    
    }

