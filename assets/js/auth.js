const loginUser = (e) => {
  e.preventDefault();

  let userName = document.querySelector("#userName").value.trim();
  let userPassword = document.querySelector("#password").value.trim();

  let role = document.querySelector("#roleSignIn").value;

  let url = `http://127.0.0.1:5000/`;

  let loginData = {
    userName,
    userPassword,
  };

  console.table(role);
};
