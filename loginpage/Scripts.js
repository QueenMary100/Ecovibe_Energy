// function login() {
//     let email = document.getElementById("email").value;
//     let password = document.getElementById("password").value;

//     if (email == "" && password == "") {
//         console.log("Please fill in both email and password");
//         alert("Please fill in both email and password");
        
//     } else {
//         var userData = {
//             email: email,
//             password: password
//         };

//         var json = JSON.stringify(userData);//convert to json format

//         var options = {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: json
//         };

//         // Fetch the server
//         fetch('/login', options)
//             .then(response => response.json())
//             .then(data => console.log(data))
//             .catch(error => console.error('Error:', error));
//     }
// }

function login() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    
    if (email !== "" && password !== "") {   //call your backend api    
        console.log("Login successful");
        
    } else if(email === "" || password === ""){
        console.log("Please fill in both email and password");
    } else{
        window.location.href = "signup.html";
    }   
}
function signup() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirm-password").value;

    
    if (email !== "" && password !== "" && confirmPassword !== "") {
        if (password === confirmPassword) {
            console.log("Account created successfully"); 
            alert("Account created successfully"); 
            window.location.href = "Login.html";           
        } else {
            console.log("Passwords do not match");
        }
    } else {
        console.log("Please fill in all fields");
    }


}