const passwordIcon = document.querySelector('#passwordIcon');
const confirmPasswordIcon = document.querySelector('#confirmPasswordIcon');
const inputPassword = document.querySelector('#inputPassword');
const inputConfirmPassword = document.querySelector('#inputConfirmPassword');

passwordIcon.addEventListener('click', () => {
  if(passwordIcon.innerHTML == feather.icons['eye']) {
    passwordIcon.innerHTML = feather.icons['eye-off'];
    inputPassword.type = 'text'
  }      
  else {
    passwordIcon.innerHTML = feather.icons['eye'];
    inputPassword.type = 'password'
  }      
})

confirmPasswordIcon.addEventListener('click', () => {
  if(confirmPasswordIcon.innerHTML == feather.icons['eye']) {
    confirmPasswordIcon.innerHTML = feather.icons['eye-off'];
    inputConfirmPassword.type = 'text'
  }      
  else {
    confirmPasswordIcon.innerHTML = feather.icons['eye'];
    inputConfirmPassword.type = 'password'
  }      
})