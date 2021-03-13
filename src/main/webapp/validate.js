function validateForm() {
  const username = document.forms["registerUser"]["username"].value;
  const email = document.forms["registerUser"]["email"].value;
  const password = document.forms["registerUser"]["password"].value;
  const passwordConfirm = document.forms["registerUser"]["passwordConfirm"].value;
  const formMsg = document.getElementById("formMsg");

  if (username.length === 0) {
    formMsg.innerHTML = "Username must be provided.";
    return false;
  } else if (email.length === 0) {
    formMsg.innerHTML = "Email must be provided.";
    return false;
  } else if (password.length === 0) {
    formMsg.innerHTML = "Password must be provided.";
    return false;
  } else if (passwordConfirm.length === 0) {
    formMsg.innerHTML = "Confirmation of password must be provided.";
    return false;
  } else {
    return true;
  }
}