//import { send } from './register.js';
//import { send } from "./login";
var button = document.getElementById("data-form");
var name = document.getElementsByName("name");
var age = document.getElementsByName("age");
var cedula = document.getElementsByName("cedula");
var username = document.getElementsByName("username");
var email = document.getElementsByName("email");
var pass = document.getElementsByName("pass");

button.addEventListener("submit", comprobation);

async function comprobation(name, age, cedula, username, email, pass) {
    if (name === "") {
        alert("Name corto o vacio");
    } else if (age === "") {
        alert("Age vacia");
    } else if (cedula === "") {
        alert("Cedula vacia");
    } else if (username === "") {
        alert("username vacio o muy corto");
    } else if (email !== "") {
       // emailcertify();
        /* function emailcertify(email) {
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/.test(email)){
            alert("La dirección de email " + email + " es correcta.");
            if (pass=== "") {
                alert("password vacia o muy corta");
            } else send();
            } else {
            alert("La dirección de email es incorrecta.");
            }
        }*/
        function pruebaemail (email){
            re=/^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
            if(!re.exec(email)){
                alert('email no valido');
            }
            else {
                alert('email valido');
            if (pass=== "") {
                alert("password vacia o muy corta");
            } else send();
            } 
        }
    } else {
        alert("no se especifico un correo");
    }
}

