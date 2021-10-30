var registerForm = document.getElementById("data-form");
//var API_url= "https://proyecto-1-web-ii.herokuapp.com/Register";
var API_url = window.location.origin+"/WebII_repo_images/Register";


registerForm.addEventListener("submit", send);

async function send(e) {
  e.preventDefault();
  var data = {};
  var form = new FormData(registerForm);
  for (var pair of form.entries()) {
    data[pair[0]] = pair[1];
  }
  console.log(data);

  var res = await fetch(API_url, {
    method: "POST", // or 'PUT'
    body: form,
  }).catch((error) => console.error("Error:", error));
  var response = await res.json();

  if (response.status == 200) {
	console.log(window.location)
    window.location = window.location.origin +"/WebII_repo_images/public/views/login.html";
  } else {
    console.log("No se pudo Registrar los datos");
  }
}

//export { send };