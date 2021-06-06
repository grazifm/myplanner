class SignUpFormValidator {
  constructor(form, fields) {
    this.form = form;
    this.fields = fields;
  }

  initialize() {
    this.validateOnSubmit();
    this.validateOnEntry();
  }

  validateOnSubmit() {
    let self = this;
    this.form.addEventListener('submit', (e) => {
      e.preventDefault();
      this.fields.forEach(field => {
        const input = document.querySelector(`#${field}`);
        self.validateFields(input);
      })
    })
  }

  validateOnEntry() {
    let self = this;
    this.fields.forEach(field => {
      const input = document.querySelector(`#${field}`);
      input.addEventListener('input', (e) => {
        self.validateFields(input);
      })

    })
  }

  validateFields(field) {
    if (!field.value.trim()) {
      this.setStatus(field, `Campo obrigatório.`, 'error')
    } else {
      this.setStatus(field, null, 'success');
    }

    if(field.type === "email") {
      const regex = /\S+@\S+.\S+/;

      if(regex.test(field.value)) {
        this.setStatus(field, null, 'success')
      } else {
        this.setStatus(field, 'Digite um endereço de e-mail válido.', 'error')
      }
    }

    if(field.id === "inputConfirmPassword") {
      const password = document.querySelector('#inputPassword');
      const confirmPassword = document.querySelector('#inputConfirmPassword');

      if(!field.value.trim()) {
        this.setStatus(field, 'Confirmação de senha obrigatória.', 'error')
      } else if (field.value !== password.value) {
        this.setStatus(field, 'Senhas não correspondem.', 'error')
      }
    } 
  }

  setStatus(field, message, status) {
    const errorMessage = field.parentElement.querySelector('.error__message');

    if (status === 'success') {
      if(errorMessage) errorMessage.innerText = '';

      if(field.classList.contains(['signup__input__password'])){
        field.nextElementSibling.classList.remove('signup__wrapper__icon--margin');
      }

      field.classList.remove('signup__input--error');
    }
    
    if (status === 'error') {
      if(errorMessage) errorMessage.innerText = message;
      if(field.classList.contains(['signup__input__password'])){
        field.nextElementSibling.classList.add('signup__wrapper__icon--margin');
      }

      field.classList.add('signup__input--error');
    }
  }
}
/* 
const form = document.querySelector('.signup');
const fields = ['name', 'email', 'inputPassword', 'inputConfirmPassword'];

const validator = new SignUpFormValidator(form, fields);

validator.initialize(); */