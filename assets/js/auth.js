const loginUser = (e) => {
  e.preventDefault();

  let userName = document.querySelector("#userName").value.trim();
  let userPassword = document.querySelector("#password").value.trim();

  let loginData = {
    userName,
    userPassword,
  };

  console.table(loginData);
};
